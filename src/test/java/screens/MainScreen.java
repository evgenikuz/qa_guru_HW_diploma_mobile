package screens;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.*;
import static io.qameta.allure.Allure.step;

public class MainScreen {
    private static final SelenideElement moreButton = $(id("org.wikipedia.alpha:id/nav_tab_more")),
                                        loginButton = $(id("org.wikipedia.alpha:id/main_drawer_account_container")),
                                        searchField = $(accessibilityId("Search Wikipedia")),
                                        searchInput = $(id("org.wikipedia.alpha:id/search_src_text")),
                                        savedButton = $(id("org.wikipedia.alpha:id/nav_tab_reading_lists"));
    private static final ElementsCollection searchResults = $$(id("org.wikipedia.alpha:id/page_list_item_description"));

    public MainScreen clickMoreButton() {
        step("Click on More button", () -> {
            moreButton.click();
            loginButton.shouldBe(visible);
        });
        return this;
    }

    public MainScreen clickLoginButton() {
        step("Click on Log in button", () ->
            loginButton.click());
        return this;
    }

    public MainScreen searchArticle(String name) {
        step("Type search", () -> {
            searchField.click();
            searchInput.sendKeys(name);
        });
        return this;
    }

    public MainScreen clickOnResult(String text) {
        step("Find search result", () -> {
        searchResults.findBy(text(text)).click();
        });
        return this;
    }

    public MainScreen savedButtonClick() {
        step("Click on Saved button", () -> {
            savedButton.click();
        });
        return this;
    }
}
