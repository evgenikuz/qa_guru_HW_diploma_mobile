package screens.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static io.appium.java_client.AppiumBy.id;

public class GameModalComponent {
    private static final SelenideElement gameModal = $(id("org.wikipedia.alpha:id/container")),
                                        closeModalButton = $(id("org.wikipedia.alpha:id/closeButton"));

    @Step("Close modal window if needed")
    public void closeGameModal() {
        sleep(5000);
        if (gameModal.isDisplayed()) {
            closeModalButton.click();
        }
    }
}
