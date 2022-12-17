package com.denal.elements;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ElementsPractice {

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