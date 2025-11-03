package screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.className;
import static io.appium.java_client.AppiumBy.id;

public class CreateAnAccountScreen {
    private static final SelenideElement loginButton = $(id("org.wikipedia.alpha:id/create_account_login_button")),
            usernameInput = $(id("org.wikipedia.alpha:id/create_account_username")).$(className("android.widget.EditText")),
            usernameValidityError = $(id("org.wikipedia.alpha:id/textinput_error"));

    @Step("Click on Log in button")
    public CreateAnAccountScreen clickLoginButton() {
            loginButton.click();
        return this;
    }

    @Step("Insert new username")
    public CreateAnAccountScreen insertNewUsername(String username) {
        usernameInput.sendKeys(username);
        return this;
    }

    @Step("Check validation error")
    public CreateAnAccountScreen checkValidationError(String username) {
        usernameValidityError.shouldHave(text("The user name \"" +
                username + "\" is not available. Please choose a different name."));
        return this;
    }


}
