package screens.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

public class GameModalComponent {
    private static final SelenideElement gameModal = $(id("org.wikipedia.alpha:id/container")),
                                        closeModalButton = $(id("org.wikipedia.alpha:id/closeButton"));

    public void closeGameModal() {
        step("Close modal window if needed", () -> {
            sleep(5000);
            if (gameModal.isDisplayed()) {
                closeModalButton.click();
            }
        });
    }
}
