package screens.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static io.appium.java_client.AppiumBy.id;

public class HintComponent {
    private static final SelenideElement gotItButton = $(id("org.wikipedia.alpha:id/buttonView"));

    @Step("Close hint")
    public void closeHint() {
        sleep(2000);
        gotItButton.click();
    }
}
