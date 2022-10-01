package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byXpath;

import static com.codeborne.selenide.Selenide.$;

public class AppHeaderPage {

    private final By accountButtonLocator = byXpath("//a[@href='/account']");
    private final By constructorButtonLocator = byXpath("//a[@href='/']/p[text()='Конструктор']");
    private final By logoLocator = byClassName("AppHeader_header__logo__2D0X2");

    @Step("Нажатие кнопки \"Личный кабинет\"")
    public void clickAccountButton() {
        $(accountButtonLocator).shouldBe(enabled).click();
    }

    @Step("Нажатие кнопки \"Конструктор\"")
    public void clickConstructorButton() {
        $(constructorButtonLocator).shouldBe(enabled).click();
    }

    @Step("Нажатие логотипа")
    public void clickLogo() {
        $(logoLocator).shouldBe(visible).click();
    }
}
