package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byXpath;

public abstract class AuthorizationFormPage {

    public By emailInputLocator = byXpath("//label[text()='Email']/..//input[@type='text']");

    abstract By enterTitleLocator();

}
