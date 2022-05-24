package com.gildedrose;

import java.util.ArrayList;
import java.util.List;

class GildedRose {
	Item[] items;
	

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		List<Item> itemsExceptAgedAndBackAndConjuredAndSulfuras=new ArrayList<Item>();
		List<Item> itemsWithSulfuras= new ArrayList<Item>();
		List<Item> itemsWithBackStage=new ArrayList<Item>();
		List<Item> itemsWithConjured=new ArrayList<Item>();
		List<Item> itemsWithAged=new ArrayList<Item>();
		initializingItems(items,itemsExceptAgedAndBackAndConjuredAndSulfuras,itemsWithSulfuras,itemsWithBackStage,itemsWithConjured,itemsWithAged);
		
		for (Item item : itemsExceptAgedAndBackAndConjuredAndSulfuras) {
			item.quality = ((item.sellIn <= 0) ? item.quality - 2 : item.quality - 1);
			item.quality = (item.quality < 0) ? 0 : item.quality;
			item.sellIn = item.sellIn - 1;
		}

		for (Item item : itemsWithConjured) {
			item.quality = item.quality - 2;
			item.quality = (item.quality < 0) ? 0 : item.quality;
			item.sellIn = item.sellIn - 1;
		}

		for (Item item : itemsWithSulfuras) {
			item.quality = 80;
		}

		for (Item item : itemsWithBackStage) {
			/*The below ternary line of code is equal to following 7 lines of code
			 * if(item.sellIn<=0)
			 * 		item.quality=0
			 * else if (item.sellIn <= 5 && item.quality <= 50)
			 * 		item.quality=item.quality+3
			 * else if(item.sellIn <= 10 && item.quality <= 50)
			 * 		item.quality=item.quality+2
			 * else item.quality=item.quality+1
			 */
			
			item.quality = ((item.sellIn <= 0) ? 0: (item.sellIn <= 5 && item.quality <= 50) ? item.quality + 3: (item.sellIn <= 10 && item.quality <= 50) ? item.quality + 2 : item.quality + 1);
			item.quality = (item.quality > 50) ? 50 : item.quality;
			item.sellIn = item.sellIn - 1;
		}

		for (Item item : itemsWithAged) {
			item.quality = (item.sellIn <= 0) ? item.quality + 2 : item.quality + 1;
			item.quality = (item.quality > 50) ? 50 : item.quality;
			item.sellIn = item.sellIn - 1;
		}
      }

	private void initializingItems(Item[] items, List<Item> itemsExceptAgedAndBackAndConjuredAndSulfuras,List<Item> itemsWithSulfuras, List<Item> itemsWithBackStage, List<Item> itemsWithConjured,List<Item> itemsWithAged) {
		for(Item item:items) {
			if(!item.name.equalsIgnoreCase("Aged Brie") && !item.name.contains("Backstage passes")&& !item.name.contains("Conjured") && !item.name.contains("Sulfuras"))
				itemsExceptAgedAndBackAndConjuredAndSulfuras.add(item);
			else if(item.name.contains("Sulfuras"))
				itemsWithSulfuras.add(item);
			else if(item.name.contains("Backstage passes"))
				itemsWithBackStage.add(item);
			else if(item.name.contains("Conjured"))
				itemsWithConjured.add(item);
			else if(item.name.contains("Aged"))
				itemsWithAged.add(item);
			}
		}
	}