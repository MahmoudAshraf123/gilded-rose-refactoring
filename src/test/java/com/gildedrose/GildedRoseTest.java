package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void itemNameTest() {
        Item[] items = new Item[] { new Item("fixme", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("fixme", app.items[0].name);
    }

    @Test
    void sellInDefaultDecrementValuteBy1() {
        Item[] items = new Item[] { new Item("fixme", 10, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
    }

    @Test
    void sellInNegativeValueTest() {
        Item[] items = new Item[] { new Item("fixme", 0, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
    }

    
    @Test
    void qualityDefalutDecrementValuteBy1() {
        Item[] items = new Item[] { new Item("fixme", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].quality);
    }

    
    @Test
    void qualityEqualZero() {
        Item[] items = new Item[] { new Item("fixme", 10, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    
    @Test
    void qualityValueWhenSellInEqualZero() {
        Item[] items = new Item[] { new Item("fixme", 0, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, app.items[0].quality);
    }


}
