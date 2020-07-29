package com.nya.fgopedia.ui.craftessence;

public class Craft {
    private String iconimg, name, rarity, type;

    public Craft(String iconimg, String name, String rarity, String type) {
        this.iconimg = iconimg;
        this.name = name;
        this.rarity = rarity;
        this.type = type;
    }

    public Craft() {
    }

    public String getIconimg() {
        return iconimg;
    }

    public void setIconimg(String iconimg) {
        this.iconimg = iconimg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
