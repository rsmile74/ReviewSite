package com.example.demo;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Collection;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ReviewController.class) //creating the review controller class

public class ReviewControllerMvcTest {  //model view controller test

    @Autowired
    private MockMvc mockMvc;  //adding the test from the Spring document, mimics a user making request at the endpoint and getting information back

    @MockBean  //Review Repository will be a MockBean
    private ReviewRepository reviewRepo;

    @Mock
    private Review reviewOne; //creating mock data

    @Mock
    private Review reviewTwo; //creating mock data

    @Test
    public void shouldBeOkForAllReviewsInTheReviewsTemplate() throws Exception { //want to see all the reviews registered in a template when we find all
        mockMvc.perform(get("/reviews")).andExpect(status().isOk()) //want to get the reviews and see the status and expect a view with the name courses template (want to see a 200 status code)
                .andExpect(view().name("reviewsTemplate"));

    }


    @Test
    public void shouldFindAllReviewsInModel() throws Exception { //find all the reviews in the model
        Collection<Review> allReviewsInModel = Arrays.asList(reviewOne, reviewTwo); //all reviews in our model will be pulled in as a list
        when(reviewRepo.findAll()).thenReturn(allReviewsInModel); //using the when and then call method
        mockMvc.perform(get("/reviews")) //peform a test at /reviews want the model to bring back all the reviews we have in our database
                .andExpect(model().attribute("reviewsModel", allReviewsInModel));


    }

    @Test
    public void shouldBeOkForOneReviewInTheReviewTemplate() throws Exception { //want to see all the review registered in a template when we find all
        Long reviewOneId = 1L;
        when(reviewRepo.findOne(reviewOneId)).thenReturn(reviewOne);
        mockMvc.perform(get("/review?id=1")).andExpect(status().isOk()) //want to get the review and see the status and expect a view with the name courses template (want to see a 200 status code)
                .andExpect(view().name("reviewTemplate"));

        //will get a status that is okay for a singular review template


    }

    @Test
    void shouldFindCourseOneInModel() throws Exception { //see if we can located ReviewOne in the Moedel
        Long reviewOneId = 1L;
        when(reviewRepo.findOne(reviewOneId)).thenReturn(reviewOne); //singular review
        mockMvc.perform(get("/review?id=1")).
                andExpect(model().attribute("reviewModel", reviewOne));
    }
}
