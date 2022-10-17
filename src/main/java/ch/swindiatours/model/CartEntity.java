package ch.swindiatours.model;

import java.util.Enumeration;
import java.util.Hashtable;

public class CartEntity {

    protected Hashtable items;

    public CartEntity() {
        this.items = new Hashtable();

    }


    public void addItem(String itemId,
                        String desc,
                        String price,
                        int quantity) {

        String[] item = {itemId, desc, price, Integer.toString(quantity)};

        if (items.containsKey(itemId)) {

            String[] tmpItem = (String[]) items.get(itemId);
            int tmpQuant = Integer.parseInt(tmpItem[3]);
            quantity += tmpQuant;
            tmpItem[3] = Integer.toString(quantity);
        } else {

            items.put(itemId, item);
        }
    }

    public void updateQuantity(String itemId, int quantity) {

        if (items.contains(itemId)) {

            String[] tmpItem = (String[]) items.get(itemId);
            tmpItem[3] = Integer.toString(quantity);
        }
    }

    public Enumeration getEnumeration() {

        return items.elements();
    }


    public int getNumOfItems() {

        Enumeration enume = items.elements();
        String[] tmpItem;
        int numOfItems = 0;
        while (enume.hasMoreElements()) {

            tmpItem = (String[]) enume.nextElement();
            numOfItems += Integer.parseInt(tmpItem[3]);
        }

        return numOfItems;
    }
}

