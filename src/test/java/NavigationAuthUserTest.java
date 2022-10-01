import client.AuthClient;
import io.restassured.response.ValidatableResponse;
import models.User;
import models.UserCredentials;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.Account;
import pages.HomePage;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.localStorage;
import static com.codeborne.selenide.Selenide.open;

public class NavigationAuthUserTest {

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
    }

    @After
    public void tearDown() {
        authClient.deleteExistUser(userCredentials);
    }

    @Test
    public void logoutTest() {
        HomePage homePage = new HomePage();
        homePage.waitLoading()
                .clickAccountButton();

        Account account = new Account();
        account.waitLoading()
                .clickLogoutButton();

        LoginPage loginPage = new LoginPage();
        loginPage.waitLoading();
    }

}
