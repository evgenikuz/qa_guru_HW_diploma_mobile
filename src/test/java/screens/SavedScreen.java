package screens;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import screens.components.HintComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.className;
import static io.appium.java_client.AppiumBy.id;

public class SavedScreen {
    HintComponent hintComponent = new HintComponent();
    private static final SelenideElement savedList = $(id("org.wikipedia.alpha:id/recycler_view")).$(className("android.view.ViewGroup"));
    private static final ElementsCollection savedArticles = $$(id("org.wikipedia.alpha:id/page_list_item_description"));

    @Step("Click on Saved list")
    public SavedScreen goToSavedList() {
        savedList.click();
        return this;
    }

    @Step("Check article was saved")
    public SavedScreen checkArticleWasSaved(String article) {
        savedArticles.findBy(text(article)).shouldBe(visible);
        return this;
    }

    public SavedScreen closeHint() {
        hintComponent.closeHint();
        return this;
    }
}
