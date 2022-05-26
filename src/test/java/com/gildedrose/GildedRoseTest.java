package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void once_the_sell_by_date_has_passed_then_Quality_degrades_twice_as_fast() {
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", 0, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(18, app.items[0].quality);
    }
    
    @Test
    void the_quality_of_an_item_is_never_negative() {
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", -1, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }
    
    @Test
    void the_case_of_aged_brie_whose_quality_increases_as_older_it_gets() {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 2)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, app.items[0].quality);
    }
    
    @Test
    void the_quality_of_an_item_is_never_more_than_fifty() {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }
    
    @Test
    void the_case_of_sulfuras_which_is_never_sold_or_decreases_in_quality() {
        Item[] items = new Item[] { new Item("Sulfuras", 5, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
    }
    
    @Test
    void the_case_of_backstage_when_seliin_is_less_than_ten_days() {
        Item[] items = new Item[] { new Item("Backstage passes", 7, 25)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(27, app.items[0].quality);
    }
    
    @Test
    void the_case_of_backstage_when_seliin_is_less_than_five_days() {
        Item[] items = new Item[] { new Item("Backstage passes", 3, 25)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(28, app.items[0].quality);
    }
    
    @Test
    void the_case_of_backstage_when_seliin_date_has_passed() {
        Item[] items = new Item[] { new Item("Backstage passes", -1, 25)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }
    @Test
    void the_case_of_conjured_when__quality_decreases_twice_as_fast() {
        Item[] items = new Item[] { new Item("Conjured", 6, 18)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(16, app.items[0].quality);
    }
    
    @Test
    void the_sellin_value__and_quality_decreases() {
        Item[] items = new Item[] { new Item("Dexterity", 6, 18)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(17, app.items[0].quality);
        assertEquals(5, app.items[0].sellIn);
    }
    
    
    
    

}
