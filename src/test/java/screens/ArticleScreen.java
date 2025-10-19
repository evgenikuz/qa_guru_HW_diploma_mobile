package screens;

import com.codeborne.selenide.SelenideElement;
import screens.components.GameModalComponent;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

public class ArticleScreen {
    GameModalComponent gameModalComponent = new GameModalComponent();
    private static final SelenideElement pageContent = $(id("org.wikipedia.alpha:id/page_header_view")),
    saveButton = $(id("org.wikipedia.alpha:id/page_save"));

    public ArticleScreen checkContent() {
        step("Check content is present", () ->
            pageContent.shouldBe(visible));
        return this;
    }

    public ArticleScreen saveArticle() {
        step("Save article by Save button", () ->
            saveButton.click());
        return this;
    }

    public ArticleScreen closeModalWindow() {
        gameModalComponent.closeGameModal();
        return this;
    }

}
