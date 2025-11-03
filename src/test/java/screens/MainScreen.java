package screens;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.*;

public class MainScreen {
    private static final SelenideElement moreButton = $(id("org.wikipedia.alpha:id/nav_tab_more")),
                                        loginButton = $(id("org.wikipedia.alpha:id/main_drawer_account_container")),
                                        searchField = $(accessibilityId("Search Wikipedia")),
                                        searchInput = $(id("org.wikipedia.alpha:id/search_src_text")),
                                        savedButton = $(id("org.wikipedia.alpha:id/nav_tab_reading_lists"));
    private static final ElementsCollection searchResults = $$(id("org.wikipedia.alpha:id/page_list_item_description"));

    @Step("Click on More button")
    public MainScreen clickMoreButton() {
        moreButton.click();
        loginButton.shouldBe(visible);
        return this;
    }

    @Step("Click on Log in button")
    public MainScreen clickLoginButton() {
        loginButton.click();
        return this;
    }

    @Step("Type search")
    public MainScreen searchArticle(String name) {
        searchField.click();
        searchInput.sendKeys(name);
        return this;
    }

    @Step("Find search result")
    public MainScreen clickOnResult(String text) {
        searchResults.findBy(text(text)).click();
        return this;
    }

    @Step("Click on Saved button")
    public MainScreen savedButtonClick() {
        savedButton.click();
        return this;
    }
}
