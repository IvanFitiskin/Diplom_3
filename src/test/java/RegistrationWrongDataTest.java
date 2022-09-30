import client.AuthClient;
import models.User;
import models.UserCredentials;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;
import static org.apache.http.HttpStatus.SC_OK;
import static org.apache.http.HttpStatus.SC_UNAUTHORIZED;
import static org.junit.Assert.assertEquals;

public class RegistrationWrongDataTest {

    private AuthClient authClient;
    private UserCredentials userCredentials;
    private User user;

    private static final String TEST_NAME = "FitiskinIP";
    private static final String TEST_EMAIL = "test-fitiskin-data@yandex.ru";
    private static final String TEST_PASSWORD = "test";

    @Before
    public void setUp() {
        authClient = new AuthClient();
        user = new User(TEST_NAME, TEST_EMAIL, TEST_PASSWORD);
        userCredentials = UserCredentials.from(user);

        open("https://stellarburgers.nomoreparties.site/register");
    }

    @Test
    public void registrationTest() {
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage
                .waitLoading()
                .submitRegistration(user);

        registrationPage.findErrorMessage();

        // В идеале это через базу проверять, так как есть слой с API тестами.
        // Но можно и так, чтобы убедиться, что новый пользователь действительно зарегистрировался
        int statusCode = authClient.login(userCredentials).extract().statusCode();
        assertEquals("Status code is not corrected", SC_UNAUTHORIZED, statusCode);
    }

}
