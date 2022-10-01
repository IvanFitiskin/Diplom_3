import client.AuthClient;
import io.qameta.allure.Epic;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import models.User;
import models.UserCredentials;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.*;

@Epic("Авторизация")
public class LogoutTest {

    private AuthClient authClient;
    private UserCredentials userCredentials;

    private static final String TEST_NAME = "FitiskinIP";
    private static final String TEST_EMAIL = "test-fitiskin-data@yandex.ru";
    private static final String TEST_PASSWORD = "test-api-22!";

    @Before
    public void setUp() {
        authClient = new AuthClient();
        User user = new User(TEST_NAME, TEST_EMAIL, TEST_PASSWORD);
        userCredentials = UserCredentials.from(user);

        ValidatableResponse response = authClient.create(user);

        String accessToken = response.extract().path("accessToken");
        String refreshToken = response.extract().path("refreshToken");

        open("https://stellarburgers.nomoreparties.site");
        localStorage().setItem("accessToken", accessToken);
        localStorage().setItem("refreshToken", refreshToken);

        // обновляем страницу, чтобы нормально работали accessToken и refreshToken
        refresh();
    }

    @After
    public void tearDown() {
        authClient.deleteExistUser(userCredentials);
    }

    @Test
    @DisplayName("Выход из личного кабинета")
    public void logoutTest() {
        HomePage homePage = new HomePage();
        homePage.waitLoading()
                .clickAccountButton();

        AccountPage accountPage = new AccountPage();
        accountPage.waitLoading()
                .clickLogoutButton();

        LoginPage loginPage = new LoginPage();
        loginPage.waitLoading();
    }

}
