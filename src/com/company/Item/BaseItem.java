package com.company.Item;

public abstract class BaseItem {
    private String name;
    private String description;

    protected BaseItem(String name, String description){
        this.name = name;
        this.description = description;
    }

    private BaseItem(){

    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
