package com.nya.fgopedia;

public class Servant {
    private String name, id, key;

    public Servant(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public Servant() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String toString() {
        return " "+name+"\n"+" "+id;
    }
}
