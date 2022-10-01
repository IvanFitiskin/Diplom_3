package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class Account implements IPage<Account> {

    private final By logoutLocator = byXpath("//button[text()='Выход']");

    private final By nameInputLocator = byXpath("//label[text()='Имя']/..//input[@type='text']");
    private final By loginInputLocator = byXpath("//label[text()='Логин']/..//input[@type='text']");
    private final By passwordInputLocator = byXpath("//input[@type='password']");

    public String getName() {
        return $(nameInputLocator).shouldBe(visible).getValue();
    }

    public String getLogin() {
        return $(loginInputLocator).shouldBe(visible).getValue();
    }

    public void clickLogoutButton() {
        $(logoutLocator).click();
    }

    @Override
    public Account waitLoading() {
        $(nameInputLocator).shouldBe(visible);
        $(loginInputLocator).shouldBe(visible);
        $(passwordInputLocator).shouldBe(visible);

        return new Account();
    }
}
