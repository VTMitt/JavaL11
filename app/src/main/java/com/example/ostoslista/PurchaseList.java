package com.example.ostoslista;

import java.util.ArrayList;
import java.util.Collections;

public class PurchaseList {

    ArrayList<Purchase> purchases = new ArrayList<Purchase>();
    private static PurchaseList purchaseList = null;

    private PurchaseList() {

    }

    public static PurchaseList getInstance() {
        if (purchaseList == null) {
            purchaseList = new PurchaseList();

        }
        return purchaseList;
    }

    public void addPurchase(Purchase purchase) {
        purchases.add(purchase);
    }

    public ArrayList<Purchase> getPurchases() {
        return purchases;
    }

    public void removePurchase(String name) {
        int i = 0;
        for (Purchase purchase : purchases) {
            if (purchase.getName().equals(name)) {
                purchases.remove(i);
                break;
            }

        }


    }

    public Purchase getPurchaseById(int id) {
        return purchases.get(id);

    }

    public ArrayList<String> getNames(){
        ArrayList<String> names = new ArrayList<String>();


        return names;


    }

    public void sortByAlphabet(){
        ArrayList<String> names = new ArrayList<String>();
        for (Purchase purchase: purchases) {
            names.add(purchase.getName());
        }
        Collections.sort(names);
        int j = 0;
        for (Purchase purchase: purchases) {
            for (int i = 0; i < purchases.size(); i++) {
                if(names.get(i) .equals(purchase.getName())){
                Collections.swap(purchases,j,i);
            }
            }

            j++;
        }

    }

    public void sortByAge(){
        ArrayList<Integer> ages = new ArrayList<Integer>();
        for (Purchase purchase: purchases) {
            ages.add(purchase.getAge());
        }
        Collections.sort(ages);
        int j = 0;
        for (Purchase purchase: purchases) {
            for (int i = 0; i < purchases.size(); i++) {
                if(ages.get(i) == purchase.getAge()){
                    Collections.swap(purchases,j,i);
                }
            }

            j++;
        }

    }


    }

