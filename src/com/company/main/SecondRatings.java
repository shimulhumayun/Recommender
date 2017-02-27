package com.company.main;
/**
 * Write a description of SecondRatings here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.*;

public class SecondRatings {
    private ArrayList<Movie> myMovies;
    private ArrayList<EfficientRater> myRaters;
/*    private String movieFile="/Users/shimul/MEGA/Recommender/src/com/company/data/ratedmoviesfull.csv";
    private String ratedFile="/Users/shimul/MEGA/Recommender/src/com/company/data/ratings.csv";*/

    public SecondRatings() {
        // default constructor
        this("ratedmoviesfull.csv", "ratings.csv");
    }


    public SecondRatings(String moviefile, String ratingsfile) {
        /*Write an additional SecondRatings constructor that has two String parameters named moviefile and ratingsfile.
         The constructor should create a FirstRatings object and then call the loadMovies and loadRaters methods in
         FirstRatings to read in all the movie and ratings data and store them in the two private ArrayList variables
         of the SecondRatings class, myMovies and myRaters.*/
        FirstRatings firstRatings = new FirstRatings();
        this.myMovies = firstRatings.loadMovies(moviefile);
        this.myRaters = firstRatings.loadRaters(ratingsfile);

    }

    /*In the SecondRatings class, write a public method named getMovieSize, which returns the number of movies that
     were read in and stored in the ArrayList of type Movie.*/
    public int getMovieSize() {
        return myMovies.size();
    }

    /*In the SecondRatings class, write a public method named getRaterSize, which returns the number of raters
    that were read in and stored in the ArrayList of type Rater.*/
    public int getRaterSize() {
        return myRaters.size();
    }

    //In the SecondRatings class, write a public method named getAverageRatings, which has one int parameter named
    // minimalRaters. This method should find the average rating for every movie that has been rated by at least
    // minimalRaters raters. Store each such rating in a Rating object in which the movie ID and the average rating
    // are used in creating the Rating object. The method getAverageRatings should return an ArrayList of all the
    // Rating objects for movies that have at least the minimal number of raters supplying a rating.
    // For example, if minimalRaters has the value 10, then this method returns rating information
    // (the movie ID and its average rating) for each movie that has at least 10 ratings. You should consider
    // calling the private getAverageByID method.
    public ArrayList<Rating> getAverageRatings(int minimalRaters) {
        ArrayList<Rating> raterList = new ArrayList<>();
        int count = 0;
        for (Movie movie : myMovies) {
            double average = getAverageByID(movie.getID(), minimalRaters);
            //average=Math.round(average*100.0)/100.0;
            //System.out.println("Average: "+average);
            if (!(average <= 0)) {
                Rating rate = new Rating(movie.getID(), average);
                raterList.add(rate);
            }
        }
        Collections.sort(raterList);
        return raterList;
    }

    /*In the SecondRatings class, write a private helper method named getAverageByID that has two parameters:
    a String named id representing a movie ID and an integer named minimalRaters. This method returns a double
    representing the average movie rating for this ID if there are at least minimalRaters ratings. If there are
     not minimalRaters ratings, then it returns 0.0.*/
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

    public String getTitle(String id) {
        for (int i = 0; i < myMovies.size(); i++) {
            if (myMovies.get(i).getID().equalsIgnoreCase(id)) {
                return myMovies.get(i).getTitle();
            }

        }
        return "NO SUCH ID FOUND.";
    }

    public String getID(String title) {
        for (Movie movie : myMovies) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                return movie.getID();
            }
        }
        return "NO SUCH TITLE.";


    }


}
