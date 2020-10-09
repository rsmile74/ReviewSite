package com.example.demo;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller  //adding the controller
public class ReviewController {

    @Resource
    private ReviewRepository reviewRepo; //creating the repo

    @RequestMapping({"/reviews", "/", ""})
    //this will be string methods returning the name of the template you want add the end point /reviews
    public String findAllReviews(Model model) { //inputting the info in our parameter
        model.addAttribute("reviewsModel", reviewRepo.findAll()); //adding the add attribute when the user goes to /reviews in the web browser the the findAll reviews it will bring back all the Reviews
        return "reviewsTemplate"; //make sure you create your template under resources
    }

    @RequestMapping("/review")
    //need to create a request mapping the test that was created for the singular test was a 404
    public String findOneCourse(@RequestParam(value = "id") Long id, Model model) { //add the RequestParam
        model.addAttribute("reviewModel", reviewRepo.findOne(id)); //add the model attribute, and in the request Param call in Model model
        return "reviewTemplate";
    }



}
