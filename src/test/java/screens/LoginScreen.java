package screens;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.className;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

public class LoginScreen {
    private static final SelenideElement loginButton = $(id("org.wikipedia.alpha:id/login_button")),
            usernameInput = $(id("org.wikipedia.alpha:id/login_username_text")).$(className("android.widget.EditText")),
            passwordInput = $(id("org.wikipedia.alpha:id/login_password_input")).$(className("android.widget.EditText")),
            captcha = $(id("org.wikipedia.alpha:id/captcha_text")),
            captchaError = $(id("org.wikipedia.alpha:id/textinput_error"));

    public LoginScreen insertUsername(String username) {
        step("Enter username", () -> {
            usernameInput.sendKeys(username);
        });
        return this;
    }

    public LoginScreen insertPassword(String password) {
        step("Enter username", () -> {
            passwordInput.sendKeys(password);
        });
        return this;
    }

    public LoginScreen clickLoginButton() {
        step("Click on Log in button", () -> {
            loginButton.click();
            captcha.shouldBe(visible);
        });
        return this;
    }

    public LoginScreen checkCaptchaError() {
        step("Check captcha is required", () -> {
            loginButton.click();
            captchaError.shouldHave(text("Repeat words from above"));
        });
        return this;
    }
}
