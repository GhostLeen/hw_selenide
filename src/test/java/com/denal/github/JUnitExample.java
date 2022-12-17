package com.denal.github;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class JUnitExample extends TestBase {

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
}