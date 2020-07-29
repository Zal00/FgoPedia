package com.nya.fgopedia.ui.servant;

public class Servant {
    private String icomimg, icon, name, rarity;

    public Servant(String icomimg, String icon, String name, String rarity) {
        this.icomimg = icomimg;
        this.icon = icon;
        this.name = name;
        this.rarity = rarity;
    }


    public Servant() {
    }

    public String getIcomimg() {
        return icomimg;
    }

    public void setIcomimg(String icomimg) {
        this.icomimg = icomimg;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
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
}
