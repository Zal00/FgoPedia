package com.nya.fgopedia.ui.home;

public class News {
    private String judul, tanggal, banner;

    public News(String judul, String tanggal, String banner) {
        this.judul = judul;
        this.tanggal = tanggal;
        this.banner = banner;
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

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }
}
