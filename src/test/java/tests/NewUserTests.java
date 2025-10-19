package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import screens.CreateAnAccountScreen;
import screens.MainScreen;

import static com.codeborne.selenide.Selenide.back;
import static io.qameta.allure.SeverityLevel.CRITICAL;

@Epic("Пользователи")
@Feature("Создание нового пользователя")
public class NewUserTests extends TestBase {
    MainScreen mainScreen = new MainScreen();
    CreateAnAccountScreen createAnAccountScreen = new CreateAnAccountScreen();

    @Test
    @DisplayName("При создании пользователя с username, имеющимся в БД, появляется ошибка The user name [username] is not available. Please choose a different name.")
    @Story("Ошибка при создании пользователя с именем как у пользователя в базе данных")
    @Owner("KharitonovaES")
    @Severity(CRITICAL)
    void newUsernameValidityTest() {
        back();
        mainScreen.clickMoreButton()
                .clickLoginButton();
        createAnAccountScreen.insertNewUsername("kvak")
                .checkValidationError("kvak");
    }
}
