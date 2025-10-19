package screens;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import screens.components.HintComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.className;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

public class SavedScreen {
    HintComponent hintComponent = new HintComponent();
    private static final SelenideElement savedList = $(id("org.wikipedia.alpha:id/recycler_view")).$(className("android.view.ViewGroup"));
    private static final ElementsCollection savedArticles = $$(id("org.wikipedia.alpha:id/page_list_item_description"));

    public SavedScreen goToSavedList() {
        step("Click on Saved list", () -> {
            savedList.click();
        });
        return this;
    }

    public SavedScreen checkArticleWasSaved(String article) {
        step("Check article was saved", () -> {
            savedArticles.findBy(text(article)).shouldBe(visible);
        });
        return this;
    }

    public SavedScreen closeHint() {
        hintComponent.closeHint();
        return this;
    }
}
