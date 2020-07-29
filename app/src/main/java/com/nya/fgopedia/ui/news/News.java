package com.nya.fgopedia.ui.news;

public class News {
    private String judul, tanggal, banner, webview;


    public News(String judul, String tanggal, String banner, String webview) {
        this.judul = judul;
        this.tanggal = tanggal;
        this.banner = banner;
        this.webview = webview;
    }

    public String getWebview() {
        return webview;
    }

    public void setWebview(String webview) {
        this.webview = webview;
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
