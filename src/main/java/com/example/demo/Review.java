package com.example.demo;

public class Review {
    private Long id;   //access modifier
    private String name;
    private String description;
    private String images;



    public Long getId() {
        return id;  //creating the getter
    }


    public String getName() {
        return name;
    }

    public String getImage(){
        return images;
    }

    public String getDescription() {
        return description;
    }


    public Review(long id, String name, String images, String description) { //Constructor is created
        this.id = id;  //creating the key word
        this.name = name;
        this.description = description;
        this.images=images;
    }
}
