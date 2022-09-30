package client;

import io.restassured.response.ValidatableResponse;
import models.User;
import models.UserCredentials;

import static io.restassured.RestAssured.given;

public class AuthClient extends RestClient {

    private static final String AUTH_PATH = "/api/auth";

    public ValidatableResponse create(User user) {
        return given()
                .spec(getBaseSpec())
                .body(user)
                .when()
                .post(AUTH_PATH + "/register")
                .then();
    }

    public ValidatableResponse login(UserCredentials userCredentials) {
        return given()
                .spec(getBaseSpec())
                .body(userCredentials)
                .post(AUTH_PATH + "/login")
                .then();
    }

    public ValidatableResponse delete(String token, String name) {
        return given()
                .spec(getBaseSpecWithToken(token))
                .queryParam("name", name)
                .when()
                .delete(AUTH_PATH + "/user")
                .then();
    }

    public void deleteExistUser(UserCredentials userCredentials) {
        ValidatableResponse responseLogin = login(userCredentials);

        if (responseLogin.extract().statusCode() == 200) {
            String token = responseLogin.extract().path("accessToken");
            String name = responseLogin.extract().path("user.name");
            delete(token, name);
        }
    }

}
