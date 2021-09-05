package com.stolicki.collections.sortedCollections;

import java.util.Map;

public class Main {
    private static final StockList stocklist = new StockList();

    public static void main(String[] args) {
        StockItem temp = new StockItem("bread", 0.86, 100);
        stocklist.addStock(temp);

        temp = new StockItem("cake", 1.10, 7);
        stocklist.addStock(temp);

        temp = new StockItem("cheese", 2.2, 11);
        stocklist.addStock(temp);

        temp = new StockItem("car", 11111.10, 2);
        stocklist.addStock(temp);

        temp = new StockItem("door", 40.11, 12);
        stocklist.addStock(temp);

        temp = new StockItem("cup", 6.11, 22);
        stocklist.addStock(temp);

        temp = new StockItem("lamp", 12.51, 6);
        stocklist.addStock(temp);

        System.out.println(stocklist);

        Basket basket = new Basket("basket");

        sellItem(basket, "door", 1);
        sellItem(basket, "lamp", 2);
        sellItem(basket, "cup", 4);

        adjustPosition(basket, "cup", 2);

        checkedOut(basket);

        System.out.println(basket);

        System.out.println(stocklist);
//
//        sellItem(basket, "car", 1);
//        System.out.println(basket);
//
//        if (sellItem(basket, "car", 1) != 1) {
//            System.out.println("There are no more cars in stock.");
//        }
//
//        System.out.println(basket);
//
//        sellItem(basket, "radio", 1);
//        System.out.println(basket);
//
//        sellItem(basket, "cup", 20);
//        System.out.println(basket);
//
//        stocklist.Items().get("car").adjustStock(1000);
//        stocklist.get("car").adjustStock(-500);
//        System.out.println(stocklist);
//
//        for (Map.Entry<String, Double> price : stocklist.priceList().entrySet()) {
//            System.out.println(price.getKey() + " costs " + price.getValue());
//        }
    }

    public static int sellItem(Basket basket, String item, int quantity) {
        StockItem stockItem = stocklist.get(item);
        if (stockItem == null) {
            System.out.println("Can't sell item " + item);
            return 0;
        }
        if (stocklist.sellStock(item, quantity) != 0) {
            basket.addToBasket(stockItem, quantity);
            return quantity;
        }
        return 0;
    }

    public static int adjustPosition(Basket basket, String item, int quantity) {
        StockItem stockItem = stocklist.get(item);
        if (stockItem == null) {
            System.out.println("Can't adjust quantity of an item " + item);
            return 0;
        }
        for (Map.Entry<StockItem, Integer> targetItem : basket.items().entrySet()) {
            if (targetItem.getKey().getName().equals(item)) {
                targetItem.getKey().adjustReservedQuantity(-quantity);
                targetItem.getKey().adjustStock(quantity);
                System.out.println("Quantities adjusted.");
                return targetItem.getValue();
            }
        }
        System.out.println("Can't adjust quantity of an item " + item);
        return 0;
    }

    public static void checkedOut(Basket basket) {
        if (basket != null) {
            System.out.println("Thank you for purchase. You just bought: " + basket);
            for (Map.Entry<StockItem, Integer> itemInBasket : basket.items().entrySet()) {
                itemInBasket.getKey().adjustReservedQuantity(-(itemInBasket.getValue()));
            }
            basket.clearBasket();
        }
    }
}
