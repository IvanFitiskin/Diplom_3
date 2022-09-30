package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;


public class HomePage implements IPage<HomePage>{

    private final By titleLocator = byXpath("//h1[text()='Соберите бургер']");
    private final By accountButtonLocator = byXpath("//a//p[text()='Личный Кабинет']");

    @Override
    public HomePage waitLoading() {
        $(titleLocator).shouldBe(visible);
        return new HomePage();
    }

    public RegistrationPage clickAccountButton() {
        $(accountButtonLocator).shouldBe(enabled).click();
        return new RegistrationPage();
    }
}
