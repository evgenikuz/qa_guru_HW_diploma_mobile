package tests;

import org.junit.jupiter.api.Test;
import screens.CreateAnAccountScreen;
import screens.LoginScreen;
import screens.MainScreen;

import static com.codeborne.selenide.Selenide.back;

public class NewUserTests extends TestBase {
    MainScreen mainScreen = new MainScreen();
    CreateAnAccountScreen createAnAccountScreen = new CreateAnAccountScreen();

    @Test
    void newUsernameValidityTest() {
        back();
        mainScreen.clickMoreButton()
                .clickLoginButton();
        createAnAccountScreen.insertNewUsername("kvak")
                .checkValidationError("kvak");
    }
}
