package com.denal.elements;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class DragAndDropPractice {

    @Test
    void dragAddDropTest() {
        step("Open drag and drop practice page", () ->
                open("https://the-internet.herokuapp.com/drag_and_drop"));
        step("Drag and drop A to B", () ->
                //Ошибки не выдает, но и не работает. Выделяет элемент А, но не перетаскивает на другое место
                //actions().dragAndDrop($("#column-a"), $("#column-b")).perform()

                $("#column-a").dragAndDropTo("#column-b")
        );
        step("Verify if A and B change positions", () ->
                $$(".column").first().shouldHave(text("B"))
        );
    }
}


