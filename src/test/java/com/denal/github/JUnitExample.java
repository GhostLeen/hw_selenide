package com.denal.github;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class JUnitExample {

    @Test
    void checkJUnitExampleTest() {
        step("Open Selenide project on GitHub", () ->
                open("https://github.com/selenide/selenide"));
        step("Open Wiki section in Selenide project", () ->
                $("#wiki-tab").click()
        );
        step("Check SoftАssertions page existence", () -> {
            $(".js-wiki-more-pages-link").click();
            $(".wiki-pages-box").shouldHave(text("SoftAssertions"));
        });
        step("Open SoftАssertions page", () ->
                $(".wiki-pages-box").find(byText("SoftAssertions")).click()
        );
        step("Check JUnit5 example code", () -> {
            $(".markdown-body").shouldHave(text("Using JUnit5 extend test class"));
        });
    }

    @Test
    @Disabled
        /* Предусловие: в дереве содержится 3 div, h3 есть только у ВТОРОГО div.
        В 1 случае он ищет любой элемент div у которого есть h3, находит совпадение и выводит.
        Во 2 случае он ищет h3 у ПЕРВОГО div в дереве, но у первого div нет h3, поэтому тест падает,
        поскольку такой элемент не существует.
        */
    void elementsTreeCheckTest() {
        open("https://selenide.org/documentation.html");
        System.out.println("вывод $(div h3) поиска: " + $("div h3").getText());
        System.out.println("вывод $(div).$(h3) поиска: " + $("div").$("h3").getText());
    }
}