package com.gildedrose;

class GildedRose {
    Item[] items;
    // we have 4 main items
    final String aged_brie = "Aged Brie";
    final String back_stage_passes = "Backstage passes to a TAFKAL80ETC concert";
    final String sulfuras = "Sulfuras, Hand of Ragnaros";
    final String Conjured = "Conjured Mana Cake";

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {

            switch (items[i].name) {
                case sulfuras:
                    continue;
                case back_stage_passes:
                    backStageCase(items[i]);
                    break;
                case aged_brie:
                    qualityUpdating(items[i], 1);
                    break;
                case Conjured:
                    qualityUpdating(items[i], -2);
                    break;
                default:
                    qualityUpdating(items[i], -1);
                    break;
            }

            items[i].sellIn--;

            if (items[i].sellIn < 0)
                negativeSellInCase(items[i]);
        }
    }

    // update quality depend on specific value
    private void qualityUpdating(Item item, int value) {
        item.quality += value;
        item.quality = (item.quality < 0) ? 0 : item.quality;
        item.quality = (item.quality > 50) ? 50 : item.quality;

    }

    private void backStageCase(Item item) {
        qualityUpdating(item, 1);
        if (item.sellIn < 11)
            qualityUpdating(item, 1);
        if (item.sellIn < 6)
            qualityUpdating(item, 1);
    }

    private void negativeSellInCase(Item item) {
        switch (item.name) {
            case aged_brie:
                qualityUpdating(item, 1);
                break;
            case back_stage_passes:
                item.quality = 0;
                break;
            case Conjured:
                qualityUpdating(item, -2);
                break;
            default:
                qualityUpdating(item, -1);
                break;
        }
    }
}