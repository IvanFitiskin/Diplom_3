package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;


public class HomePage extends AppHeaderPage implements IPage<HomePage> {

    private final By singInButtonLocator = byXpath("//button[text()='Войти в аккаунт']");
    private final By createOrderButtonLocator = byXpath("//button[text()='Оформить заказ']");

    private final By titleLocator = byXpath("//h1[text()='Соберите бургер']");

    @Override
    public HomePage waitLoading() {
        $(titleLocator).shouldBe(visible);
        return new HomePage();
    }

    public void clickSingInButton() {
        $(singInButtonLocator).shouldBe(enabled).click();
    }

    public boolean isOrderButtonExist() {
        return $(createOrderButtonLocator).exists();
    }
}
