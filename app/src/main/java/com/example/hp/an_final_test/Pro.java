package com.example.hp.an_final_test;

public class Pro {
    private int img;
    private String title;
    private String content;
    private int img2;
    private int img3;
    private int img4;
    private String time;


    public Pro(int img, String title,String content, int img2, int img3, int img4, String time) {
        this.img = img;
        this.title = title;
        this.content=content;
        this.time = time;
        this.img2=img2;
        this.img3=img3;
        this.img4=img4;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    public int getImg2() {
        return img2;
    }

    public void setImg2(int img2) {
        this.img2 = img2;
    }
    public int getImg3() {
        return img3;
    }

    public void setImg3(int img3) {
        this.img3 = img3;
    }
    public int getImg4() {
        return img4;
    }

    public void setImg4(int img4) {
        this.img4 = img4;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
