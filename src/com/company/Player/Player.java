package com.company.Player;

import com.company.Item.BaseItem;

import java.util.ArrayList;
import java.util.Collection;

public class Player {
    private static Player instance = null;
    private Collection<BaseItem> inventory;

    public static Player getInstance() {
        if(instance == null) {
            instance = new Player();
        }
        return instance;
    }

    private Player(){
        inventory = new ArrayList<>();
    }

    public Collection<BaseItem> getInventory() {
        return inventory;
    }
}
