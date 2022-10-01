import client.AuthClient;
import models.User;
import models.UserCredentials;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.Account;
import pages.HomePage;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginTest {

    private AuthClient authClient;
    private User user;
    private UserCredentials userCredentials;

    private static final String TEST_NAME = "FitiskinIP";
    private static final String TEST_EMAIL = "test-fitiskin-data@yandex.ru";
    private static final String TEST_PASSWORD = "test-api-22!";

    @Before
    public void setUp() {
        authClient = new AuthClient();
        user = new User(TEST_NAME, TEST_EMAIL, TEST_PASSWORD);
        userCredentials = UserCredentials.from(user);

        authClient.create(user);

        open("https://stellarburgers.nomoreparties.site/login");
    }

    @After
    public void tearDown() {
        authClient.deleteExistUser(userCredentials);
    }

    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.waitLoading()
                .submitLogin(userCredentials);

        HomePage homePage = new HomePage();
        boolean isLogin = homePage.waitLoading()
                .isOrderButtonExist();

        assertTrue("User is not authorization", isLogin);

        homePage.clickAccountButton();

        Account account = new Account();
        account.waitLoading();

        String name = account.getName();
        String login = account.getLogin();
        assertEquals("name does not match", user.getName(), name);
        assertEquals("email does not match", user.getEmail(), login);
    }
}
