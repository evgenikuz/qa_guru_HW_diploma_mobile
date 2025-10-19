package tests;

import org.junit.jupiter.api.Test;
import screens.MainScreen;

import static com.codeborne.selenide.Selenide.back;

public class ArticleTests extends TestBase {
    MainScreen mainScreen = new MainScreen();

    @Test
    void SaveArticleTest() {
        back();

    }
}
