package com.way.rapid.myapplication;

public class Bean {
    private int img;
    private String name;
    private String content;



    public Bean(int img, String name, String content) {
        this.img = img;
        this.name = name;
        this.content = content;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name =name;
    }

    public String getContent() {
        return content;
    }

    public void setPrice(String content) {
        this.content = content;
    }
}
