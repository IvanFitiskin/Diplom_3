package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;


public class HomePage extends AppHeaderPage implements IPage<HomePage> {

    private final By singInButtonLocator = byXpath("//button[text()='Войти в аккаунт']");
    private final By createOrderButtonLocator = byXpath("//button[text()='Оформить заказ']");

    private final By titleLocator = byXpath("//h1[text()='Соберите бургер']");
    private final By burgerBasketLocator = byClassName("BurgerConstructor_basket__list__l9dp_");

    @Override
    @Step("Ожидание домашней страницы")
    public HomePage waitLoading() {
        $(titleLocator).shouldBe(visible);
        $(burgerBasketLocator).shouldBe(visible);
        return new HomePage();
    }

    @Step("Нажатие кнопки \"Войти\"")
    public void clickSingInButton() {
        $(singInButtonLocator).shouldBe(enabled).click();
    }

    @Step("Проверка наличия кнопки \"Оформить заказ\"")
    public boolean isOrderButtonExist() {
        return $(createOrderButtonLocator).exists();
    }
}
