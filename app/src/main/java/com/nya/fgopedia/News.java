package com.nya.fgopedia;

public class News {
    private String judul, tanggal, key;

    public News(String judul, String tanggal ) {
        this.judul = judul;
        this.tanggal = tanggal;
    }

    public News() {
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return " "+judul+"\n" +
                " "+tanggal;
    }

}
