package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import screens.CreateAnAccountScreen;
import screens.LoginScreen;
import screens.MainScreen;

import static com.codeborne.selenide.Selenide.back;
import static io.qameta.allure.SeverityLevel.CRITICAL;

@Epic("Пользователи")
@Feature("Авторизация")
public class LoginTests extends TestBase {
    MainScreen mainScreen = new MainScreen();
    CreateAnAccountScreen createAnAccountScreen = new CreateAnAccountScreen();
    LoginScreen loginScreen = new LoginScreen();

    @Test
    @DisplayName("Ошибка Repeat words from above при попытке обойти капчу")
    @Story("При авторизации присутствует обязательная проверка капчи")
    @Owner("KharitonovaES")
    @Severity(CRITICAL)
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
