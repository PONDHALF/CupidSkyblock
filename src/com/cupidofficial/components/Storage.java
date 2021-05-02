package com.cupidofficial.components;

import org.bukkit.inventory.Inventory;

public class Storage {
    
    private Inventory a;
    private Inventory b;
    private Inventory c;
    private Inventory d;
    private Inventory e;
    private Inventory f;

    private String OwnerName;

    public Storage(Inventory a, Inventory b, Inventory c, Inventory d, Inventory e, Inventory f, String OwnerName) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.OwnerName = OwnerName;
    }

    public Inventory getInventoryA() {
        return a;
    } 

    public Inventory getInventoryB() {
        return b;
    }

    public Inventory getInventoryC() {
        return c;
    }

    public Inventory getInventoryD() {
        return d;
    }

    public Inventory getInventoryE() {
        return e;
    }

    public Inventory getInventoryF() {
        return f;
    }

    public String getOwnerName() {
        return OwnerName;
    }
    
}
