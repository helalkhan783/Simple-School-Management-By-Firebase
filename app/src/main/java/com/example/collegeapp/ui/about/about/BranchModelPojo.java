package com.example.collegeapp.ui.about.about;

public class BranchModelPojo {
    private int image;
    private String  title,descrption;


    public BranchModelPojo(int image, String title, String descrption) {
        this.image = image;
        this.title = title;
        this.descrption = descrption;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescrption() {
        return descrption;
    }

    public void setDescrption(String descrption) {
        this.descrption = descrption;
    }
}
