package screens;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

public class MainScreen {
    private static final SelenideElement moreButton = $(id("org.wikipedia.alpha:id/nav_tab_more")),
                                        loginButton = $(id("org.wikipedia.alpha:id/main_drawer_account_container"));

    public MainScreen clickMoreButton() {
        step("Click on More button", () -> {
            moreButton.click();
            loginButton.shouldBe(visible);
        });
        return this;
    }

    public MainScreen clickLoginButton() {
        step("Click on Log in button", () -> {
            loginButton.click();
        });
        return this;
    }
}
