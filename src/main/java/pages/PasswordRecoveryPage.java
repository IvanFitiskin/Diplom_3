package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class PasswordRecoveryPage extends AuthorizationFormPage implements IPage<PasswordRecoveryPage> {

    private final By goToLoginButtonLocator = byXpath("//a[@href='/login']");

    @Override
    By enterTitleLocator() {
        return byXpath("//h2[text()='Восстановление пароля']");
    }

    @Override
    public PasswordRecoveryPage waitLoading() {
        $(enterTitleLocator()).shouldBe(visible);
        $(emailInputLocator).shouldBe(visible);

        return new PasswordRecoveryPage();
    }

    public void clickGoToLoginButton() {
        $(goToLoginButtonLocator).shouldBe(visible).click();
    }

}
