package com.example.demo;


import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository //adding the @Repository
public class ReviewRepository {

    Map<Long, Review> reviewsList = new HashMap<>();//using the Hasmap to gather the collection

    public ReviewRepository(){
        Review plane = new Review(1L,"Traveling by Airplane", "./images/plane.jpg","Traveling by plane can great but lets take a closer look, you do have to worry about security measures and since we are in a pandemic you need to do your research and understand the guidelines. " +
                "Remember luggage fees, the plus side you can get where you need faster, well most of the time if there are no delays"); //building a constructor for the database
        Review boat = new Review(2L, "Let's take a Cruise", "./images/ship.jpg","Taking a cruise is also fun, seeing the body of water is relaxing, look for deals, and you have that all inclusive, and transportation between ports, " +
                "the downside of course the every loving pandemic, and your cruise can get stuck in the middle of the ocean");
        Review car = new Review(3L, "Road Trip", "./images/car.jpg","Did anyone say road trip, taking a road trip is also fun, you get to see fantastic views fun pit stops along with way, " +
                "the downside can be tolls and gas and just make sure your car is maintenance, and you may run into a traffic jam. ");

        reviewsList.put(plane.getId(),plane); //creating a database
        reviewsList.put(boat.getId(),boat);
        reviewsList.put(car.getId(),car);

    }

    public ReviewRepository(Review...reviewsToAdd) { //using the varArgs and none or as many as needed ...is the spread operator
     for(Review review: reviewsToAdd){
         reviewsList.put(review.getId(),review);//this will place the review inside the collection, the primary key is the ID and the reviewToAdd is the object
                                                //for each review place it into the list, this is why the for loop is called. There could be multiple courses
     }
    }

    public Review findOne(long id) {  //changing the L to Id, changed null to the reviewsList, and adding the .get(Id) to get the primaary key
        return reviewsList.get(id);
    }

    public Collection<Review> findAll() {
        return reviewsList.values(); //return all the reviews because this is a collection method
    }
}
