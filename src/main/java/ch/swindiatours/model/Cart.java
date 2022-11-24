package ch.swindiatours.model;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.logging.Logger;

public class Cart {
    private static final Logger LOGGER = Logger.getLogger(Cart.class.getName());

       protected Hashtable items;

    public Cart() {
        this.items = new Hashtable();

    }


    public void addItem(String tourId,
                        String tour,
                        String desc,
                        String price,
                        int quantity) {

        String[] item = {tourId, tour, desc, price, Integer.toString(quantity)};

        if (items.containsKey(tourId)) {

            String[] tmpItem = (String[]) items.get(tourId);
            int tmpQuant = Integer.parseInt(tmpItem[3]);
            quantity += tmpQuant;
            tmpItem[3] = Integer.toString(quantity);
        } else {

            items.put(tourId, item);
        }
    }

    public void edit(String tourId, int quantity) {

        if (items.contains(tourId)) {

            String[] tmpItem = (String[]) items.get(tourId);
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

