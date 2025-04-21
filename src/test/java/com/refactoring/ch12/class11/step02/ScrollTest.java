package com.refactoring.ch12.class11.step02;

import com.refactoring.ch12.class11.CatalogItem;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ScrollTest {

    @DisplayName("해당 스크롤은 클리닝이 필요하다")
    @Test
    void needsCleaning() {
        // given
        Catalog catalog = new Catalog();
        CatalogItem itemStone = new CatalogItem(1, "Stone", List.of("revered"));
        CatalogItem itemBible = new CatalogItem(2, "Bible", List.of("BestSeller"));

        catalog.add(itemStone);
        catalog.add(itemBible);

        Scroll scroll = new Scroll(101,  LocalDate.of(1900, 1, 1), 1, catalog);

        // when
        boolean result = scroll.needsCleaning(LocalDate.now());

        // then
        Assertions.assertThat(scroll.getTitle()).isEqualTo("Stone");
        Assertions.assertThat(result).isTrue();
    }
}