package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
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

    @Step("Нажатие кнопки \"Булки\"")
    public ConstructorPage clickBunButton() {
        $(bunButtonLocator).shouldBe(enabled).click();
        return new ConstructorPage();
    }

    @Step("Нажатие кнопки \"Соусы\"")
    public ConstructorPage clickSauceButton() {
        $(sauceButtonLocator).shouldBe(enabled).click();
        return new ConstructorPage();
    }

    @Step("Нажатие кнопки \"Начинки\"")
    public ConstructorPage clickFillingButton() {
        $(fillingButtonLocator).shouldBe(enabled).click();
        return new ConstructorPage();
    }

    @Step("Проверка свойства selected кнопки \"Булки\"")
    public boolean isSelectedBunButton() {
        return isSelectedButton(bunButtonLocator);
    }

    @Step("Проверка свойства selected кнопки \"Соусы\"")
    public boolean isSelectedSauceButton() {
        return isSelectedButton(sauceButtonLocator);
    }

    @Step("Проверка свойства selected кнопки \"Начинки\"")
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
