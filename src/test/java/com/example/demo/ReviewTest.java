package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;

public class ReviewTest {

    private ReviewRepository underTest;
    private Review reviewOne = new Review(1L, "review name","review image", "review description");
    private Review reviewTwo = new Review(2L, "review name","review image", "review description"); //change the primary key to 2L

    @Test
    public void shouldFindReviewOne() {
        underTest = new ReviewRepository(reviewOne); //creating a repository, this will maintain our database
        Review foundReview = underTest.findOne(1L);//primary key, fineOne will create a method
        assertEquals(foundReview, foundReview);
    }

    @Test
    public void shouldFindReviewOneAndReviewTwo() {
        underTest = new ReviewRepository(reviewOne, reviewTwo); //adding in courseTwo
        Collection<Review> foundReviews = underTest.findAll(); //create the findAll method
        assertThat(foundReviews).contains(reviewOne, reviewTwo);


    }


}
