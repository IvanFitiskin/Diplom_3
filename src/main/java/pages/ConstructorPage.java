package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.Objects;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Condition.focused;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ConstructorPage extends HomePage {

    private final By bunButtonLocator = byXpath("//span[text()='Булки']/parent::div");
    private final By sauceButtonLocator = byXpath("//span[text()='Соусы']/parent::div");
    private final By fillingButtonLocator = byXpath("//span[text()='Начинки']/parent::div");

    public ConstructorPage clickBunButton() {
        $(bunButtonLocator).shouldBe(enabled).click();
        return new ConstructorPage();
    }

    public ConstructorPage clickSauceButton() {
        $(sauceButtonLocator).shouldBe(enabled).click();
        return new ConstructorPage();
    }

    public ConstructorPage clickFillingButton() {
        $(fillingButtonLocator).shouldBe(enabled).click();
        return new ConstructorPage();
    }

    public boolean isSelectedBunButton() {
        return isSelectedButton(bunButtonLocator);
    }

    public boolean isSelectedSauceButton() {
        return isSelectedButton(sauceButtonLocator);
    }

    public boolean isSelectedFillingButton() {
        return isSelectedButton(fillingButtonLocator);
    }

    private boolean isSelectedButton(By buttonLocator) {
        SelenideElement buttonElement = $(buttonLocator);
        return Objects.equals(
                buttonElement.getAttribute("class"),
                "tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect");
    }

}
