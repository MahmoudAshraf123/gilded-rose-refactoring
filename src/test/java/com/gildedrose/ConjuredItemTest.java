package com.gildedrose;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class ConjuredItemTest {
    
    @Test
    void itemNameTest() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Conjured Mana Cake", app.items[0].name);
    }

    @Test
    void sellInDefaultDecrementValuteBy1() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 10, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
    }

    @Test
    void sellInNegativeValueTest() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 0, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
    }

    
    @Test
    void qualityDefalutDecrementValuteBy2() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
    }

    
    @Test
    void qualityEqualZero() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 10, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    
    @Test
    void qualityValueWhenSellInEqualZero() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 0, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].quality);
    }

    @Test
    void qualityValueWhenSellInNegative() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", -1, 3) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }
}
