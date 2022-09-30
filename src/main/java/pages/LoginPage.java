package pages;

import models.UserCredentials;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends AuthorizationFormPage implements IPage<LoginPage> {

    private final By submitButtonLocator = byXpath("//button[text()='Войти']");

    @Override
    By enterTitleLocator() {
        return byXpath("//h2[text()='Вход']");
    }

    @Override
    public LoginPage waitLoading() {
        $(enterTitleLocator()).shouldBe(visible);
        $(emailInputLocator).shouldBe(visible);
        $(passwordInputLocator).shouldBe(visible);

        return new LoginPage();
    }

    public HomePage submitLogin(UserCredentials userCredentials) {
        $(emailInputLocator).setValue(userCredentials.getEmail());
        $(passwordInputLocator).setValue(userCredentials.getPassword());
        $(submitButtonLocator).click();

        return new HomePage();
    }

}
