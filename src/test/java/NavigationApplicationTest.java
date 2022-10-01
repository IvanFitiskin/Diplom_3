import io.qameta.allure.Epic;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.PasswordRecoveryPage;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;

@Epic("Навигация")
public class NavigationApplicationTest {

    @Test
    @DisplayName("Переход с домашней страницы на страницу авторизации через кнопку \"Личный кабинет\"")
    public void goLoginFromHomeAccountButtonTest() {
        open("https://stellarburgers.nomoreparties.site");

        HomePage homePage = new HomePage();
        homePage.waitLoading()
                .clickAccountButton();

        LoginPage loginPage = new LoginPage();
        loginPage.waitLoading();
    }

    @Test
    @DisplayName("Переход с домашней страницы на страницу авторизации через кнопку \"Войти\"")
    public void goLoginFromHomeSingInButtonTest() {
        open("https://stellarburgers.nomoreparties.site");

        HomePage homePage = new HomePage();
        homePage.waitLoading()
                .clickSingInButton();

        LoginPage loginPage = new LoginPage();
        loginPage.waitLoading();
    }

    @Test
    @DisplayName("Переход с страницы реагистрации на страницу авторизации")
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
    @DisplayName("Переход с страницы восстановления пароля на страницу авторизации")
    public void goLoginFromPasswordRecoveryTest() {
        open("https://stellarburgers.nomoreparties.site/forgot-password");

        PasswordRecoveryPage passwordRecoveryPage = new PasswordRecoveryPage();
        passwordRecoveryPage
                .waitLoading()
                .clickGoToLoginButton();

        LoginPage loginPage = new LoginPage();
        loginPage.waitLoading();
    }

    @Test
    @DisplayName("Переход с страницы авторизации на домашнюю страницу через логотип")
    public void goHomeFromLoginTest() {
        open("https://stellarburgers.nomoreparties.site/login");

        LoginPage loginPage = new LoginPage();
        loginPage.waitLoading()
                .clickLogo();

        HomePage homePage = new HomePage();
        homePage.waitLoading();
    }

    @Test
    @DisplayName("Переход с страницы авторизации на домашнюю страницу через кнопку \"Конструктор\"")
    public void goConstructorFromLoginTest() {
        open("https://stellarburgers.nomoreparties.site/login");

        LoginPage loginPage = new LoginPage();
        loginPage.waitLoading()
                .clickConstructorButton();

        HomePage homePage = new HomePage();
        homePage.waitLoading();
    }
}
