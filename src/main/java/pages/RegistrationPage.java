package pages;

import com.codeborne.selenide.Condition;
import models.User;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage extends AuthorizationFormPage implements IPage<RegistrationPage> {

    private final By nameInputLocator = byXpath("//label[text()='Имя']/..//input[@type='text']");
    private final By submitButtonLocator = byXpath("//button[text()='Зарегистрироваться']");

    private final By errorMessageLocator = byXpath("//p[text()='Некорректный пароль']");

    @Override
    By enterTitleLocator() {
        return byXpath("//h2[text()='Регистрация']");
    }

    @Override
    public RegistrationPage waitLoading() {
        $(enterTitleLocator()).shouldBe(enabled);
        $(nameInputLocator).shouldBe(visible);
        $(emailInputLocator).shouldBe(visible);
        $(passwordInputLocator).shouldBe(visible);

        return new RegistrationPage();
    }

    public void submitRegistration(User user) {
        $(nameInputLocator).setValue(user.getName());
        $(emailInputLocator).setValue(user.getEmail());
        $(passwordInputLocator).setValue(user.getPassword());
        $(submitButtonLocator).click();
    }

    public void findErrorMessage() {
        $(errorMessageLocator).shouldBe(visible);
    }

}
