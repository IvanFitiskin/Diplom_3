package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class PasswordRecoveryPage extends AppHeaderPage implements IPage<PasswordRecoveryPage> {

    private final By emailInputLocator = byXpath("//label[text()='Email']/..//input[@type='text']");
    private final By goToLoginButtonLocator = byXpath("//a[@href='/login']");
    private final By enterTitleLocator = byXpath("//h2[text()='Восстановление пароля']");

    @Override
    public PasswordRecoveryPage waitLoading() {
        $(enterTitleLocator).shouldBe(visible);
        $(emailInputLocator).shouldBe(visible);

        return new PasswordRecoveryPage();
    }

    public void clickGoToLoginButton() {
        $(goToLoginButtonLocator).shouldBe(visible).click();
    }

}
