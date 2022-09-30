import org.junit.Before;
import org.junit.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.PasswordRecoveryPage;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;

public class NavigationToLoginTest {


    @Test
    public void goLoginFromHomeAccountButtonTest() {
        open("https://stellarburgers.nomoreparties.site");

        HomePage homePage = new HomePage();
        homePage.waitLoading()
                .clickAccountButton();

        LoginPage loginPage = new LoginPage();
        loginPage.waitLoading();
    }

    @Test
    public void goLoginFromHomeSingInButtonTest() {
        open("https://stellarburgers.nomoreparties.site");

        HomePage homePage = new HomePage();
        homePage.waitLoading()
                .clickSingInButton();

        LoginPage loginPage = new LoginPage();
        loginPage.waitLoading();

    }

    @Test
    public void goLoginFromRegistrationTest() {
        open("https://stellarburgers.nomoreparties.site/register");

        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage
                .waitLoading()
                .clickGoToLoginButton();

        LoginPage loginPage = new LoginPage();
        loginPage.waitLoading();
    }

    @Test
    public void goLoginFromPasswordRecoveryTest() {
        open("https://stellarburgers.nomoreparties.site/forgot-password");

        PasswordRecoveryPage passwordRecoveryPage = new PasswordRecoveryPage();
        passwordRecoveryPage
                .waitLoading()
                .clickGoToLoginButton();

        LoginPage loginPage = new LoginPage();
        loginPage.waitLoading();
    }
}
