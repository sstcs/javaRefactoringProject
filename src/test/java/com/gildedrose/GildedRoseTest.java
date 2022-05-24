package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", 10, 20), 
				new Item("Aged Brie", 2, 0),
				new Item("Elixir of the Mongoose", 5, 7), 
				new Item("Sulfuras, Hand of Ragnaros", 0, 80),
				new Item("Sulfuras, Hand of Ragnaros", -1, 80),
				new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
				new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
				new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
				// this conjured item does not work properly yet
				new Item("Conjured Mana Cake", 3, 6) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(19, app.items[0].quality);
        assertEquals(1, app.items[1].quality);
        assertEquals(6, app.items[2].quality);
        assertEquals(80, app.items[3].quality);
        assertEquals(80, app.items[4].quality);
        assertEquals(21, app.items[5].quality);
        assertEquals(50, app.items[6].quality);
        assertEquals(50, app.items[7].quality);
        assertEquals(4, app.items[8].quality);
        app.updateQuality();
        assertEquals(18, app.items[0].quality);
        assertEquals(2, app.items[1].quality);
        assertEquals(5, app.items[2].quality);
        assertEquals(80, app.items[3].quality);
        assertEquals(80, app.items[4].quality);
        assertEquals(22, app.items[5].quality);
        assertEquals(50, app.items[6].quality);
        assertEquals(50, app.items[7].quality);
        assertEquals(2, app.items[8].quality);
    }

}
