import io.qameta.allure.Epic;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.ConstructorPage;
import pages.HomePage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@Epic("Конструктор")
public class ConstructorTest {

    @Test
    @DisplayName("Открытие списка соусов")
    public void openSauceBoardTest() {
        open("https://stellarburgers.nomoreparties.site");

        HomePage homePage = new HomePage();
        homePage.waitLoading();

        ConstructorPage constructorPage = new ConstructorPage();
        constructorPage.clickSauceButton();

        boolean isSauceButtonSelected = constructorPage.isSelectedSauceButton();
        assertTrue("sauce button is not selected", isSauceButtonSelected);

        boolean isSelectedBunButton = constructorPage.isSelectedBunButton();
        boolean isSelectedFillingButton = constructorPage.isSelectedFillingButton();
        assertFalse("bun button is selected", isSelectedBunButton);
        assertFalse("filling button is selected", isSelectedFillingButton);
    }

    @Test
    @DisplayName("Открытие списка булочек")
    public void openBunBoardTest() {
        open("https://stellarburgers.nomoreparties.site");

        HomePage homePage = new HomePage();
        homePage.waitLoading();

        ConstructorPage constructorPage = new ConstructorPage();
        constructorPage.clickSauceButton()
                .clickBunButton();

        boolean isSelectedBunButton = constructorPage.isSelectedBunButton();
        assertTrue("bun button is not selected", isSelectedBunButton);

        boolean isSauceButtonSelected = constructorPage.isSelectedSauceButton();
        boolean isSelectedFillingButton = constructorPage.isSelectedFillingButton();
        assertFalse("sauce button is selected", isSauceButtonSelected);
        assertFalse("filling button is selected", isSelectedFillingButton);
    }

    @Test
    @DisplayName("Открытие списка начинки")
    public void openFillingBoardTest() {
        open("https://stellarburgers.nomoreparties.site");

        HomePage homePage = new HomePage();
        homePage.waitLoading();

        ConstructorPage constructorPage = new ConstructorPage();
        constructorPage.clickFillingButton();

        boolean isSelectedFillingButton = constructorPage.isSelectedFillingButton();
        assertTrue("filling button is not selected", isSelectedFillingButton);

        boolean isSauceButtonSelected = constructorPage.isSelectedSauceButton();
        boolean isSelectedBunButton = constructorPage.isSelectedBunButton();
        assertFalse("sauce button is selected", isSauceButtonSelected);
        assertFalse("bun button is selected", isSelectedBunButton);
    }
}
