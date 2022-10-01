package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selectors.byXpath;

import static com.codeborne.selenide.Selenide.$;

public class AppHeaderPage {

    private final By accountButtonLocator = byXpath("//a[@href='/account']");
    private final By constructorButtonLocator = byXpath("//a[@href='/']/p[text()='Конструктор']");
    private final By logoLocator = byXpath("//a[@href='/' and @class='active']");

    public void clickAccountButton() {
        $(accountButtonLocator).shouldBe(enabled).click();
    }

    public void clickConstructorButton() {
        $(constructorButtonLocator).shouldBe(enabled).click();
    }

    public void clickLogo() {
        $(logoLocator).shouldBe(enabled).click();
    }
}
