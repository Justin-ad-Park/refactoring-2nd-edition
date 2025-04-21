package com.refactoring.ch12.class11.step02;

import com.refactoring.ch12.class11.CatalogItem;
import java.util.HashMap;

public class Catalog {
    private HashMap<Integer, CatalogItem> items;

    public Catalog() {
        this.items = new HashMap<>();
    }

    public void add(CatalogItem catalogItem) {
        this.items.put(catalogItem.getId(), catalogItem);
    }

    public CatalogItem get(int id) {
        return this.items.get(id);
    }

}
