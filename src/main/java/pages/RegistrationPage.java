package pages;

import io.qameta.allure.Step;
import models.User;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage extends AppHeaderPage implements IPage<RegistrationPage> {

    private final By nameInputLocator = byXpath("//label[text()='Имя']/..//input[@type='text']");
    private final By emailInputLocator = byXpath("//label[text()='Email']/..//input[@type='text']");
    private final By passwordInputLocator = byXpath("//input[@type='password']");

    private final By submitButtonLocator = byXpath("//button[text()='Зарегистрироваться']");

    private final By errorMessageLocator = byXpath("//p[text()='Некорректный пароль']");

    private final By goToLoginButtonLocator = byXpath("//a[@href='/login']");

    private final By enterTitleLocator = byXpath("//h2[text()='Регистрация']");

    @Override
    @Step("Ожидание домашней страницы")
    public RegistrationPage waitLoading() {
        $(enterTitleLocator).shouldBe(enabled);
        $(nameInputLocator).shouldBe(visible);
        $(emailInputLocator).shouldBe(visible);
        $(passwordInputLocator).shouldBe(visible);

        return new RegistrationPage();
    }

    @Step("Заполнение формы регистрации")
    public void submitRegistration(User user) {
        $(nameInputLocator).setValue(user.getName());
        $(emailInputLocator).setValue(user.getEmail());
        $(passwordInputLocator).setValue(user.getPassword());
        $(submitButtonLocator).click();
    }

    @Step("Проверка появления сообщения об ошибке")
    public void findErrorMessage() {
        $(errorMessageLocator).shouldBe(visible);
    }

    @Step("Нажатие кнопки \"Войти\"")
    public void clickGoToLoginButton() {
        $(goToLoginButtonLocator).shouldBe(visible).click();
    }
}
