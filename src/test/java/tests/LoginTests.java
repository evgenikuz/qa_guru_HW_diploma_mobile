package tests;

import org.junit.jupiter.api.Test;
import screens.CreateAnAccountScreen;
import screens.LoginScreen;
import screens.MainScreen;

import static com.codeborne.selenide.Selenide.back;

public class LoginTests extends TestBase {
    MainScreen mainScreen = new MainScreen();
    CreateAnAccountScreen createAnAccountScreen = new CreateAnAccountScreen();
    LoginScreen loginScreen = new LoginScreen();

    @Test
    void captchaExistsTest() {
        back();
        mainScreen.clickMoreButton()
                .clickLoginButton();
        createAnAccountScreen.clickLoginButton();
        loginScreen.insertUsername("kvak")
                .insertPassword("kvak")
                .clickLoginButton()
                .checkCaptchaError();
    }
}
