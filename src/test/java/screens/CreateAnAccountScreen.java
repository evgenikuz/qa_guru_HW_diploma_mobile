package screens;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.className;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

public class CreateAnAccountScreen {
    private static final SelenideElement loginButton = $(id("org.wikipedia.alpha:id/create_account_login_button")),
            usernameInput = $(id("org.wikipedia.alpha:id/create_account_username")).$(className("android.widget.EditText")),
            usernameValidityError = $(id("org.wikipedia.alpha:id/textinput_error"));

    public CreateAnAccountScreen clickLoginButton() {
        step("Click on Log in button", () -> {
            loginButton.click();
        });
        return this;
    }

    public CreateAnAccountScreen insertNewUsername(String username) {
        step("Insert new username", () ->
            usernameInput.sendKeys(username));
        return this;
    }

    public CreateAnAccountScreen checkValidationError(String username) {
        step("Check validation error", () ->
            usernameValidityError.shouldHave(text("The user name \"" +
                    username + "\" is not available. Please choose a different name.")));
        return this;
    }


}
