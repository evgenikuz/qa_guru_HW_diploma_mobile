package screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import screens.components.GameModalComponent;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class ArticleScreen {
    GameModalComponent gameModalComponent = new GameModalComponent();
    private static final SelenideElement pageContent = $(id("org.wikipedia.alpha:id/page_header_view")),
    saveButton = $(id("org.wikipedia.alpha:id/page_save"));

    @Step("Check content is present")
    public ArticleScreen checkContent() {
        pageContent.shouldBe(visible);
        return this;
    }

    @Step("Save article by Save button")
    public ArticleScreen saveArticle() {
        saveButton.click();
        return this;
    }

    public ArticleScreen closeModalWindow() {
        gameModalComponent.closeGameModal();
        return this;
    }

}
