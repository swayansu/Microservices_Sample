package com.swayansu.moviecatalogservice.models;

public class CatalogItem {

    private String name;
    private String desc;
    private int rating;

    public CatalogItem(String name, String desc, int rating) {
        this.name = name;
        this.desc = desc;
        this.rating = rating;
    }

    public CatalogItem() {
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public int getRating() {
        return rating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "CatalogItem{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", rating=" + rating +
                '}';
    }
}
