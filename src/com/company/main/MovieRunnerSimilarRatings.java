package com.company.main;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by shimul on 2/20/17.
 */
public class MovieRunnerSimilarRatings {
    public static void main(String[] args) {
        MovieRunnerSimilarRatings rat=new MovieRunnerSimilarRatings();
        String movie = "/Users/shimul/MEGA/Recommender/src/com/company/data/ratedmoviesfull.csv";
        String rated = "/Users/shimul/MEGA/Recommender/src/com/company/data/ratings.csv";
        rat.printSimilarRatings(rated,movie);
    }

    public void printAverageRatings(String rated,String movie) {
        RaterDatabase.initialize(rated);
        System.out.println("read data for " + RaterDatabase.size() + " raters");
        MovieDatabase.initialize(movie);
        System.out.println("read data for " + MovieDatabase.size() + " movies");
        FourthRatings fr = new FourthRatings();
        int minimalRaters = 1;
        ArrayList<Rating> ratings = fr.getAverageRatings(minimalRaters);
        System.out.println("found " + ratings.size() + " movies");
        Collections.sort(ratings);
        for(Rating r: ratings) {
            System.out.println(r.getValue() + " " + MovieDatabase.getTitle(r.getItem()));
        }
    }

    public void printAverageRatingsByYearAfterAndGenre(String rated,String movie) {
        RaterDatabase.initialize(rated);
        MovieDatabase.initialize(movie);
        System.out.println("read data for " + RaterDatabase.size() + " raters");
        System.out.println("read data for " + MovieDatabase.size() + " movies");
        FourthRatings fr = new FourthRatings();
        int minimalRaters = 1;
        int year = 1980;
        String genre = "Romance";
        AllFilters filterCriteria = new AllFilters();
        filterCriteria.addFilter(new YearAfterFilter(year));
        filterCriteria.addFilter(new GenreFilter(genre));
        ArrayList<Rating> ratings = fr.getAverageRatingsByFilter(minimalRaters, filterCriteria);
        if (ratings.size() == 0 || ratings.size() == 1)
            System.out.println(ratings.size() + " movie matched");
        else
            System.out.println(ratings.size() + " movies matched");
        Collections.sort(ratings);
        for(Rating r: ratings) {
            System.out.println(r.getValue() + " " + MovieDatabase.getYear(r.getItem()) + " " + MovieDatabase.getTitle(r.getItem()) + "\n    " + MovieDatabase.getGenres(r.getItem()));
        }
    }
    /*Run the printSimilarRatings method in the MovieRunnerSimilarRatings class using the files ratedmoviesfull.csv
    and ratings.csv and the rater id 337, the number of minimal raters to 3 and the number of top similar raters set
    to 10. What is the movie with the top rated average?*/

    public void printSimilarRatings(String rated,String movie) {
        RaterDatabase.initialize(rated);
        MovieDatabase.initialize(movie);
        System.out.println("read data for " + RaterDatabase.size() + " raters");
        System.out.println("read data for " + MovieDatabase.size() + " movies");
        FourthRatings fr = new FourthRatings();
        String raterID = "337";
        int numSimilarRaters = 10;
        int minimalRaters = 3;
        ArrayList<Rating> ratings = fr.getSimilarRatings(raterID, numSimilarRaters, minimalRaters);
        if (ratings.size() == 0 || ratings.size() == 1)
            System.out.println(ratings.size() + " movie matched");
        else
            System.out.println(ratings.size() + " movies matched");
        for(int i=0; i< ratings.size(); i++) {
            if (i<15)
                System.out.printf("%d %.2f %s\n", i, ratings.get(i).getValue(), MovieDatabase.getTitle(ratings.get(i).getItem()));
        }
    }

    public void printSimilarRatingsByGenre(String rated,String movie) {
        RaterDatabase.initialize(rated);
        MovieDatabase.initialize(movie);
        System.out.println("read data for " + RaterDatabase.size() + " raters");
        System.out.println("read data for " + MovieDatabase.size() + " movies");
        FourthRatings fr = new FourthRatings();
        String raterID = "65";
        int numSimilarRaters = 20;
        int minimalRaters = 5;
        String genre = "Action";
        Filter filterCriteria = new GenreFilter(genre);
        ArrayList<Rating> ratings = fr.getSimilarRatingsByFilter(raterID, numSimilarRaters, minimalRaters, filterCriteria);
        if (ratings.size() == 0 || ratings.size() == 1)
            System.out.println(ratings.size() + " movie matched");
        else
            System.out.println(ratings.size() + " movies matched");
        for(int i=0; i< ratings.size(); i++) {
            if (i<15)
                System.out.printf("%d %.2f %s\n", i, ratings.get(i).getValue(), MovieDatabase.getTitle(ratings.get(i).getItem()));
        }
    }
     /*Run the printSimilarRatingsByDirector method in the MovieRunnerSimilarRatings class using the files
     ratedmoviesfull.csv and ratings.csv and the rater id 120, the directors
     “Clint Eastwood,J.J. Abrams,Alfred Hitchcock,Sydney Pollack,David Cronenberg,Oliver Stone,Mike Leigh”,
      the number of minimal raters to 2 and the number of top similar raters set to 10. What is the movie with
       the top rated average?*/
    public void printSimilarRatingsByDirector(String rated,String movie) {
        RaterDatabase.initialize(rated);
        MovieDatabase.initialize(movie);
        System.out.println("read data for " + RaterDatabase.size() + " raters");
        System.out.println("read data for " + MovieDatabase.size() + " movies");
        FourthRatings fr = new FourthRatings();
        String raterID = "120";
        int numSimilarRaters = 10;
        int minimalRaters = 2;
        String directors = "Clint Eastwood,J.J. Abrams,Alfred Hitchcock,Sydney Pollack,David Cronenberg,Oliver Stone,Mike Leigh";
        Filter filterCriteria = new DirectorsFilter(directors);
        ArrayList<Rating> ratings = fr.getSimilarRatingsByFilter(raterID, numSimilarRaters, minimalRaters, filterCriteria);
        if (ratings.size() == 0 || ratings.size() == 1)
            System.out.println(ratings.size() + " movie matched");
        else
            System.out.println(ratings.size() + " movies matched");
        for(int i=0; i< ratings.size(); i++) {
            if (i<15)
                System.out.printf("%d %.2f %s\n", i, ratings.get(i).getValue(), MovieDatabase.getTitle(ratings.get(i).getItem()));
        }
    }
    /*Run the printSimilarRatingsByGenreAndMinutes method in the MovieRunnerSimilarRatings class using the
    files ratedmoviesfull.csv and ratings.csv and the rater id 168, the genre Drama, the length of the movie
    between 80 and 160 inclusive, the number of minimal raters to 3 and the number of top similar raters set to 10.
     What is the movie with the top rated average?*/
    public void printSimilarRatingsByGenreAndMinutes(String rated,String movie) {
        RaterDatabase.initialize(rated);
        MovieDatabase.initialize(movie);
        System.out.println("read data for " + RaterDatabase.size() + " raters");
        System.out.println("read data for " + MovieDatabase.size() + " movies");
        FourthRatings fr = new FourthRatings();
        String raterID = "168";
        int numSimilarRaters = 10;
        int minimalRaters = 3;
        String genre = "Drama";
        int min = 80;
        int max = 160;
        AllFilters filterCriteria = new AllFilters();
        filterCriteria.addFilter(new GenreFilter(genre));
        filterCriteria.addFilter(new MinutesFilter(min, max));
        ArrayList<Rating> ratings = fr.getSimilarRatingsByFilter(raterID, numSimilarRaters, minimalRaters, filterCriteria);
        if (ratings.size() == 0 || ratings.size() == 1)
            System.out.println(ratings.size() + " movie matched");
        else
            System.out.println(ratings.size() + " movies matched");
        for(int i=0; i< ratings.size(); i++) {
            if (i<15)
                System.out.printf("%d %.2f %s\n", i, ratings.get(i).getValue(), MovieDatabase.getTitle(ratings.get(i).getItem()));
        }
    }
   /*Run the printSimilarRatingsByYearAfterAndMinutes method in the MovieRunnerSimilarRatings class using the files
    ratedmoviesfull.csv and ratings.csv and the rater id 314, the year 1975, the length of the movie between
    70 and 200 inclusive, the number of minimal raters to 5 and the number of top similar raters set to 10.
    What is the movie with the top rated average?*/

    public void printSimilarRatingsByYearAfterAndMinutes(String rated,String movie) {
        RaterDatabase.initialize(rated);
        MovieDatabase.initialize(movie);
        System.out.println("read data for " + RaterDatabase.size() + " raters");
        System.out.println("read data for " + MovieDatabase.size() + " movies");
        FourthRatings fr = new FourthRatings();
        String raterID = "314";
        int numSimilarRaters = 10;
        int minimalRaters = 5;
        int year = 1975;
        int min = 70;
        int max = 200;
        AllFilters filterCriteria = new AllFilters();
        filterCriteria.addFilter(new YearAfterFilter(year));
        filterCriteria.addFilter(new MinutesFilter(min, max));
        ArrayList<Rating> ratings = fr.getSimilarRatingsByFilter(raterID, numSimilarRaters, minimalRaters, filterCriteria);
        if (ratings.size() == 0 || ratings.size() == 1)
            System.out.println(ratings.size() + " movie matched");
        else
            System.out.println(ratings.size() + " movies matched");
        for(int i=0; i< ratings.size(); i++) {
            if (i<15)
                System.out.printf("%d %.2f %s\n", i, ratings.get(i).getValue(), MovieDatabase.getTitle(ratings.get(i).getItem()));
        }
    }
}