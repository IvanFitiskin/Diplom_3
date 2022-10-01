package pages;

import io.qameta.allure.Step;
import models.UserCredentials;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends AppHeaderPage implements IPage<LoginPage> {

    private final By submitButtonLocator = byXpath("//button[text()='Войти']");
    private final By emailInputLocator = byXpath("//label[text()='Email']/..//input[@type='text']");
    private final By passwordInputLocator = byXpath("//input[@type='password']");

    private final By enterTitleLocator = byXpath("//h2[text()='Вход']");

    @Override
    @Step("Ожидание домашней страницы")
    public LoginPage waitLoading() {
        $(enterTitleLocator).shouldBe(visible);
        $(emailInputLocator).shouldBe(visible);
        $(passwordInputLocator).shouldBe(visible);

        return new LoginPage();
    }

    @Step("Заполнение формы авторизации")
    public void submitLogin(UserCredentials userCredentials) {
        $(emailInputLocator).setValue(userCredentials.getEmail());
        $(passwordInputLocator).setValue(userCredentials.getPassword());
        $(submitButtonLocator).click();
    }
}
