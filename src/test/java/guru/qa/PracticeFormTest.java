package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        // Name
        $("#firstName").setValue("Aleksandr");
        // Фамилия
        $("#lastName").setValue("Pushkin");
        // Почта
        $("#userEmail").setValue("test999@mail.ru");
        // Пол
        $("#genterWrapper").$(byText("Male")).click();
        // Номер телефона
        $("#userNumber").setValue("8920000000");
        // Дата рождения
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("November");
        $(".react-datepicker__year-select").selectOption("1992");
        $(".react-datepicker__day--016").click();
        // Предмет
        $("#subjectsInput").setValue("m").sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        // Хобби
        $("#hobbiesWrapper").$(byText("Sports")).click();
        // Картинка
        $("#uploadPicture").uploadFromClasspath("smile.png");
        // Текущий адрес
        $("#currentAddress").setValue("1523 Stellar Dr, Kenai, Alaska 99611, USA");
        // Штат и город
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Gurgaon").pressEnter();
        // click
        $("#submit").click();

        $(".table-dark").shouldHave(text("Aleksandr"));
        $(".table-dark").shouldHave(text("Pushkin"));
        $(".table-dark").shouldHave(text("test999@mail.ru"));
        $(".table-dark").shouldHave(text("Male"));
        $(".table-dark").shouldHave(text("8920000000"));
        $(".table-dark").shouldHave(text("16 November,1992"));
        $(".table-dark").shouldHave(text("Chemistry"));
        $(".table-dark").shouldHave(text("Sport"));
        $(".table-dark").shouldHave(text("1523 Stellar Dr, Kenai, Alaska 99611, USA"));
        $(".table-dark").shouldHave(text("NCR"));
        $(".table-dark").shouldHave(text("Gurgaon"));
    }
}
