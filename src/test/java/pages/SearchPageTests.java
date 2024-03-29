package pages;

import org.example.pages.SearchPage;
import org.junit.jupiter.api.*;

import static org.example.config.AllureSetup.enableAllureListener;
import static org.example.config.WebDriverSetup.openPage;

@Tag("All")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
 class SearchPageTests {

    SearchPage searchPage = new SearchPage();

    @BeforeAll
    public void setup() {
        enableAllureListener();
        openPage("/");
        searchPage.allowCookies();
        searchPage.searchFor("IFRS");
    }

    @Test
     void testFilterField() {
        searchPage.selectFromFilterField("ContentGroup");
        searchPage.find();
        Assertions.assertEquals(searchPage.getNumberOfItemsInResults(), searchPage.getSearchResultsNumber());

    }
}
