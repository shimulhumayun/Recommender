package com.company.main;
/**
 * Write a description of SecondRatings here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.*;

public class ThirdRatings {
    //private ArrayList<Movie> myMovies;
    private ArrayList<EfficientRater> myRaters;
    //The constructor will no longer have a moviefile parameter

    public ThirdRatings() {
        // default constructor
        this( "ratings.csv");
    }


    public ThirdRatings(String ratingsfile) {
        FirstRatings firstRatings = new FirstRatings();
        //this.myMovies = firstRatings.loadMovies(moviefile);
        this.myRaters = firstRatings.loadRaters(ratingsfile);

    }


    public int getRaterSize() {
        return myRaters.size();
    }

    public ArrayList<Rating> getAverageRatings(int minimalRaters) {
        ArrayList<String>movieIds=MovieDatabase.filterBy(new TrueFilter());
        ArrayList<Rating> raterList = new ArrayList<>();
        int count = 0;
        for (String ids : movieIds) {
            double average = getAverageByID(ids, minimalRaters);
            if (!(average <= 0)) {
                Rating rate = new Rating(ids, average);
                raterList.add(rate);
            }
        }
        Collections.sort(raterList);
        return raterList;
    }

    private double getAverageByID(String id, int minimalRaters) {
        while (id.length() < 7) {
            id = "0" + id;
        }
        int sum = 0, count = 0;
        for (int i = 0; i < myRaters.size(); i++) {
            double rating = myRaters.get(i).getRating(id);
            if (rating != -1) {
                sum += rating;
                count++;
            }
        }
        if (count < minimalRaters) {
            return 0.0;
        }
        return (double) sum / count;

    }
    /*In the ThirdRatings class, write a public helper method named getAverageRatingsByFilter that has two parameters,
    an int named minimalRaters for the minimum number of ratings a movie must have and a Filter named filterCriteria.
    This method should create and return an ArrayList of type Rating of all the movies that have at least minimalRaters
     ratings and satisfies the filter criteria. This method will need to create the ArrayList of type String of movie
     IDs from the MovieDatabase using the filterBy method before calculating those averages.*/

    public ArrayList<Rating> getAverageRatingsByFilter(int minimalRaters,Filter filterCriteria) {
        ArrayList<String> movieIds = MovieDatabase.filterBy(filterCriteria);
        System.out.println("Movie ids: "+movieIds.size());
        ArrayList<Rating> raterList = new ArrayList<>();
        for (int i = 0; i < movieIds.size(); i++) {
            double average = getAverageByID(movieIds.get(i), minimalRaters);
            if (!(average <= 0)) {
                Rating rate = new Rating(movieIds.get(i), average);
                raterList.add(rate);
            }
        }
        Collections.sort(raterList);
        return raterList;
    }


}
