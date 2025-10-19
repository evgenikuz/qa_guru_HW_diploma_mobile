package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import screens.ArticleScreen;
import screens.MainScreen;
import screens.SavedScreen;

import static com.codeborne.selenide.Selenide.back;
import static io.qameta.allure.SeverityLevel.NORMAL;

@Epic("Статьи")
@Feature("Сохраненные листы для чтения")
public class ArticleTests extends TestBase {
    MainScreen mainScreen = new MainScreen();
    ArticleScreen articleScreen = new ArticleScreen();
    SavedScreen savedScreen = new SavedScreen();

    @Test
    @DisplayName("Сохраненная статья Selenium отображается в списке для чтения Saved")
    @Story("Сохраненная статья отображается в списке для чтения")
    @Owner("KharitonovaES")
    @Severity(NORMAL)
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
