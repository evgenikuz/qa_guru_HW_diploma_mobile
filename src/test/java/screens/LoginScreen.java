package screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.className;
import static io.appium.java_client.AppiumBy.id;

public class LoginScreen {
    private static final SelenideElement loginButton = $(id("org.wikipedia.alpha:id/login_button")),
            usernameInput = $(id("org.wikipedia.alpha:id/login_username_text")).$(className("android.widget.EditText")),
            passwordInput = $(id("org.wikipedia.alpha:id/login_password_input")).$(className("android.widget.EditText")),
            captcha = $(id("org.wikipedia.alpha:id/captcha_text")),
            captchaError = $(id("org.wikipedia.alpha:id/textinput_error"));

    @Step("Enter username")
    public LoginScreen insertUsername(String username) {
        usernameInput.sendKeys(username);
        return this;
    }

    @Step("Enter username")
    public LoginScreen insertPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    @Step("Click on Log in button")
    public LoginScreen clickLoginButton() {
        loginButton.click();
        captcha.shouldBe(visible);
        return this;
    }

    @Step("Check captcha is required")
    public LoginScreen checkCaptchaError() {
        loginButton.click();
        captchaError.shouldHave(text("Repeat words from above"));
        return this;
    }
}
