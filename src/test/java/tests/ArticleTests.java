package tests;

import org.junit.jupiter.api.Test;
import screens.ArticleScreen;
import screens.MainScreen;
import screens.SavedScreen;

import static com.codeborne.selenide.Selenide.back;

public class ArticleTests extends TestBase {
    MainScreen mainScreen = new MainScreen();
    ArticleScreen articleScreen = new ArticleScreen();
    SavedScreen savedScreen = new SavedScreen();

    @Test
    void SaveArticleTest() {
        back();
        mainScreen.searchArticle("Selenium")
                .clickOnResult("Chemical element with atomic number 34 (Se)");

        articleScreen.closeModalWindow()
                .checkContent()
                .saveArticle();
        back();
        back();
        back();
        mainScreen.savedButtonClick();
        savedScreen.goToSavedList()
                .closeHint()
                .checkArticleWasSaved("Chemical element with atomic number 34 (Se)");
    }
}
