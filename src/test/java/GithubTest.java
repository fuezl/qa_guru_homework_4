import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GithubTest {
    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://github.com/";
    }

    @Test
    void githubSelenideTest() {
        //Arrange
        open("/selenide/selenide");
        //Act
        $("[data-content='Wiki']").click();
        $(".js-wiki-more-pages-link").click();
        $("[data-filterable-for='wiki-pages-filter']").shouldHave(text("SoftAssertions"));
        $("[data-filterable-for='wiki-pages-filter']").$(byText("SoftAssertions")).click();
        //Assert
        $("#wiki-body").shouldHave(text("Using JUnit5 extend test class"));
    }
}
