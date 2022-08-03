package ru.netology.card;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;


public class AppCardDeliveryTest {

    @Test
    void shouldBookAppointment() {

        open("http://localhost:9999/");
        $("[data-test-id='city'] input").setValue("Уфа");
        $("[data-test-id='date'] input").sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
        String date = LocalDate.now().plusDays(4).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $("[data-test-id='date'] input").setValue(date);
        $("[name='name']").setValue("Филипп Кошечкин");
        $("[name='phone']").setValue("+79000000000");
        $("[data-test-id='agreement']").click();
        $(".button__text").click();
        $(".notification__content").should(ownText("Встреча успешно забронирована на " + date)).shouldBe((visible), Duration.ofSeconds(15));


    }
}