package screens.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

public class HintComponent {
    private static final SelenideElement gotItButton = $(id("org.wikipedia.alpha:id/buttonView"));

    public void closeHint() {
        step("Close hint", () -> {
            sleep(2000);
            gotItButton.click();
        });
    }
}
