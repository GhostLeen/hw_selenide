package com.denal.github;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;


public class SolutionsTest {

    @Test
    void openEnterprisePageTest() {
        step("Open GitHub main page", () ->
                open("https://github.com"));
        step("Point at Solution section", () ->
                $(".header-menu-wrapper").find(byText("Solutions")).hover()
        );
        step("Click on Enterprise subsection", () ->
                $(By.linkText(("Enterprise"))).click()
        );
        step("Check Enterprise page header", () ->
                $$("div h4").findBy(text("GitHub for enterprises")).shouldBe(Condition.visible)
        );
    }
}