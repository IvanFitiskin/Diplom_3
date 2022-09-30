import client.AuthClient;
import models.User;
import models.UserCredentials;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;
import static org.apache.http.HttpStatus.SC_OK;
import static org.junit.Assert.assertEquals;

public class RegistrationTest {

    private AuthClient authClient;
    private UserCredentials userCredentials;
    private User user;

    private static final String TEST_NAME = "FitiskinIP";
    private static final String TEST_EMAIL = "test-fitiskin-data@yandex.ru";
    private static final String TEST_PASSWORD = "test-api-22!";

    @Before
    public void setUp() {
        authClient = new AuthClient();
        user = new User(TEST_NAME, TEST_EMAIL, TEST_PASSWORD);
        userCredentials = UserCredentials.from(user);

        authClient.deleteExistUser(userCredentials);

        open("https://stellarburgers.nomoreparties.site/register");
    }

    @After
    public void tearDown() {
        authClient.deleteExistUser(userCredentials);
    }

    @Test
    public void registrationTest() {
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage
                .waitLoading()
                .submitRegistration(user);

        LoginPage loginPage = new LoginPage();
        loginPage.waitLoading();

        // В идеале это через базу проверять, так как есть слой с API тестами.
        // Но можно и так, чтобы убедиться, что новый пользователь действительно зарегистрировался
        int statusCode = authClient.login(userCredentials).extract().statusCode();
        assertEquals("Status code is not corrected", SC_OK, statusCode);
    }

}
