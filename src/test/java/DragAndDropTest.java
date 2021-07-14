import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DragAndDropTest {
    @Test
    void dragAndDropTest() {
        //Arrange
        open("https://the-internet.herokuapp.com/drag_and_drop");
        //Act
        $("#column-a").dragAndDropTo("#column-b");
        //Assert
        $("#column-a").shouldHave(matchText("B"));
        $("#column-b").shouldHave(matchText("A"));
    }

    //Попытался реализовать через actions, не удалось. Хотелось бы услышать комментарии в чём ошибка
//    @Test
//    void actionsTest() {
//        //Arrange
//        open("https://the-internet.herokuapp.com/drag_and_drop");
//        //Act
//        actions().dragAndDrop($("#column-a"), $("#column-b")).build().perform();
//        //Assert
//        $("#column-a").shouldHave(matchText("B"));
//        $("#column-b").shouldHave(matchText("A"));
//    }
}
