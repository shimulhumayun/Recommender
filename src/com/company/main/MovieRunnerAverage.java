package com.company.main;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by shimul on 2/18/17.
 */
public class MovieRunnerAverage {
    public static void main(String[] args) {
        String ratedFile = "/Users/shimul/MEGA/Recommender/src/com/company/data/ratings_short.csv";
       // printAverageRatings();
        //getAverageRatingOneMovie();
       // printAverageRatingsByGenre(ratedFile);
        //printAverageRatingsByYear(ratedFile);

    }

    public static void printAverageRatings() {
        String movieFile = "/Users/shimul/MEGA/Recommender/src/com/company/data/ratedmoviesfull.csv";
        String ratedFile = "/Users/shimul/MEGA/Recommender/src/com/company/data/ratings.csv";
        /*- Create a SecondRatings object and use the CSV filenames of movie information and
        ratings information from the first assignment when calling the constructor.*/
        SecondRatings secondRatings = new SecondRatings(movieFile, ratedFile);
        ArrayList<Rating> ratings=secondRatings.getAverageRatings(20);
        Collections.sort(ratings);
        System.out.println("Size: "+ratings.size());

        for (Rating rating: ratings){
           System.out.println(rating.getValue()+" "+secondRatings.getTitle(rating.getItem()));
        }
    }


    public static void getAverageRatingOneMovie(){
        String movieFile = "/Users/shimul/MEGA/Recommender/src/com/company/data/ratedmovies_short.csv";
        String ratedFile = "/Users/shimul/MEGA/Recommender/src/com/company/data/ratings_short.csv";
        SecondRatings secondRatings = new SecondRatings(movieFile, ratedFile);
        ArrayList<Rating> ratings=secondRatings.getAverageRatings(1);
        for (Rating rating: ratings){
            if (secondRatings.getTitle(rating.getItem()).equalsIgnoreCase("No Country for Old Men")){
                System.out.println("Movie: "+secondRatings.getTitle(rating.getItem())+" Rating: "+rating.getValue());
            }
        }

    }

}
