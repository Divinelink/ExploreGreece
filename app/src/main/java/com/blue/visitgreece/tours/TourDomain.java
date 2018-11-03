package com.blue.visitgreece.tours;

public class TourDomain {
    private int id;
    private String title;
    private String description;


    public TourDomain(int Id, String Title, String Description) {
        id = Id;
        title = Title;
        description = Description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}