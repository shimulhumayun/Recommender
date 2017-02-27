package com.company.main;

import java.util.ArrayList;

/**
 * Created by shimul on 2/19/17.
 */
public class MovieRunnerWithFilters {
    public static void main(String[]args){
        //String ratedFile = "/Users/shimul/MEGA/Recommender/src/com/company/data/ratings_short.csv";
        //ratings_short.csv
        String ratedFile = "/Users/shimul/MEGA/Recommender/src/com/company/data/ratings.csv";
       /* String ratedFile = "/Users/shimul/MEGA/Recommender/src/com/company/data/ratings_short.csv";
        ThirdRatings thirdRatingsrating=new ThirdRatings(ratedFile);
        ArrayList<Rating>list=thirdRatingsrating.getAverageRatings(35);
        System.out.println("Size: "+thirdRatingsrating.getRaterSize());
        System.out.println("Movie database: "+MovieDatabase.size());
        System.out.println("Minimal raters: "+list.size());
        for (Rating r:list) {
            System.out.println(r.getValue()+" "+MovieDatabase.getTitle(r.getItem()));

        }*/
        //printAverageRatingsByYear(ratedFile);
         //printAverageRatingsByGenre(ratedFile);
         //printAverageRatingsByMinutes(ratedFile);
         //printAverageRatingsByDirectors(ratedFile);
         //printAverageRatingsByYearAfterAndGenre(ratedFile);
         printAverageRatingsByDirectorsAndMinutes(ratedFile);

    }
     /* In the MovieRunnerWithFilters class, create a void method named printAverageRatingsByYear that should be
          similar to printAverageRatings, but should also create a YearAfterFilter and call getAverageRatingsByFilter
          to get an ArrayList of type Rating of all the movies that have a specified number of minimal ratings and
          came out in a specified year or later. Print the number of movies found, and for each movie found, print
          its rating, its year, and its title. For example, if you run the printAverageRatingsByYear method on the
          files ratings_short.csv and ratedmovies_short.csv with a minimal rater of 1 and the year 2000, you should see
*/
     public static void printAverageRatingsByYear(String ratedFile){

         Filter f=new YearAfterFilter(2000);
         ThirdRatings thirdRatings=new ThirdRatings(ratedFile);
         ArrayList<Rating> ratedByFilter=thirdRatings.getAverageRatingsByFilter(20,f);
         System.out.println("read data for "+thirdRatings.getRaterSize()+" raters");
         System.out.println("Filter size "+ratedByFilter.size());
         for (Rating rating:ratedByFilter){
             System.out.println(rating.getValue()+" "
                     +MovieDatabase.getYear(rating.getItem())+" "
                     +MovieDatabase.getTitle(rating.getItem()));
         }

     }


    /*- In the MovieRunnerWithFilters class, create a void method named printAverageRatingsByGenre that should create a
     GenreFilter and call getAverageRatingsByFilter to get an ArrayList of type Rating of all the movies that have a
      specified number of minimal ratings and include a specified genre. Print the number of movies found, and for
      each movie, print its rating and its title on one line, and its genres on the next line. For example, if you run
       the printAverageRatingsByGenre method on the files ratings_short.csv and ratedmovies_short.csv with a minimal
        rater of 1 and the genre “Crime”, you should see*/
    public static void printAverageRatingsByGenre(String rFile){
        ThirdRatings thirdRatings=new ThirdRatings(rFile);
        ArrayList<Rating> ratedByFilter=thirdRatings
                .getAverageRatingsByFilter(20,new GenreFilter("Comedy"));
        System.out.println("read data for "+thirdRatings.getRaterSize()+" raters");
        System.out.println("Filter size: "+ratedByFilter.size());
        for (Rating rating:ratedByFilter){
            System.out.println(rating.getValue()+" "
                    +MovieDatabase.getTitle(rating.getItem()));
            System.out.println(MovieDatabase.getGenres(rating.getItem()));
        }
    }
    /*In the MovieRunnerWithFilters class, create a void method named printAverageRatingsByMinutes that should create
     a MinutesFilter and call getAverageRatingsByFilter to get an ArrayList of type Rating of all the movies that have
     a specified number of minimal ratings and their running time is at least a minimum number of minutes and no more
     than a maximum number of minutes. Print the number of movies found, and for each movie print its rating, its
     running time, and its title on one line. For example, if you run the printAverageRatingsByMinutes method on the
    files ratings_short.csv and ratedmovies_short.csv with a minimal rater of 1, minimum minutes of 110, and maximum
     minutes of 170, then you should see*/
    public static void printAverageRatingsByMinutes(String file){
        System.out.println("MinutesFilter");
        ThirdRatings thirdRatings=new ThirdRatings(file);
        ArrayList<Rating> ratedByFilter=thirdRatings
                .getAverageRatingsByFilter(5,new MinutesFilter(105,115));
        System.out.println("read data for "+thirdRatings.getRaterSize()+" raters");
        System.out.println("Filter size: "+ratedByFilter.size());
        for (Rating rating:ratedByFilter){
            System.out.println(rating.getValue()+" Time:"+
                    MovieDatabase.getMinutes(rating.getItem())+" "
                    +MovieDatabase.getTitle(rating.getItem()));
        }

    }
    /*In the MovieRunnerWithFilters class, create a void method named printAverageRatingsByDirectors that should
    create a DirectorsFilter and call getAverageRatingsByFilter to get an ArrayList of type Rating of all the movies
     that have a specified number of minimal ratings and include at least one of the directors specified. Print the
     number of movies found, and for each movie print its rating and its title on one line, and all its directors on
     the next line. For example, if you run the printAverageRatingsByDirectors method on the files ratings_short.csv
     and ratedmovies_short.csv with a minimal rater of 1 and the directors set to "Charles Chaplin,Michael Mann,Spike
     Jonze"*/
    public static void printAverageRatingsByDirectors(String file){
        System.out.println("By Director");
        ThirdRatings thirdRatings=new ThirdRatings(file);
        ArrayList<Rating> ratedByFilter=thirdRatings
                .getAverageRatingsByFilter(4,
                        new DirectorsFilter("Clint Eastwood,Joel Coen,Martin Scorsese,Roman Polanski,Nora Ephron,Ridley Scott,Sydney Pollack"));
        System.out.println("read data for "+thirdRatings.getRaterSize()+" raters");
        System.out.println("Filter size: "+ratedByFilter.size());
        for (Rating rating:ratedByFilter){
            System.out.println(rating.getValue()+" "
                    +MovieDatabase.getTitle(rating.getItem())
                    +MovieDatabase.getDirector(rating.getItem()));
        }

    }
    /*- In the MovieRunnerWithFilters class, create a void method named printAverageRatingsByYearAfterAndGenre
     that should create an AllFilters object that includes criteria based on movies that came out in a specified
     year or later and have a specified genre as one of its genres. This method should call getAverageRatingsByFilter
     to get an ArrayList of type Rating of all the movies that have a specified number of minimal ratings and the two
      criteria based on year and genre. Print the number of movies found, and for each movie, print its rating,
      its year, and its title on one line, and all its genres on the next line.*/
    public static void printAverageRatingsByYearAfterAndGenre(String file){
        System.out.println("Ratings By Year After And Genre");
        ThirdRatings thirdRatings=new ThirdRatings(file);
        AllFilters filter=new AllFilters();
        filter.addFilter(new YearAfterFilter(1990));
        filter.addFilter(new GenreFilter("Drama"));
        ArrayList<Rating>ratingsByFilter=thirdRatings.getAverageRatingsByFilter(8,filter);
        System.out.println("Filter size: "+ratingsByFilter.size());
        for (Rating rating:ratingsByFilter){
            System.out.println(rating.getValue()+" "
                    +MovieDatabase.getTitle(rating.getItem())+"\n"
                    +MovieDatabase.getGenres(rating.getItem()));
        }



    }
    public static void printAverageRatingsByDirectorsAndMinutes(String file){
        System.out.println("Ratings By Directors And Minutes");
        ThirdRatings thirdRatings=new ThirdRatings(file);
        AllFilters filter=new AllFilters();
        filter.addFilter(new DirectorsFilter("Clint Eastwood,Joel Coen,Tim Burton,Ron Howard,Nora Ephron,Sydney Pollack"));
        filter.addFilter(new MinutesFilter(90,180));
        ArrayList<Rating>ratingsByFilter=thirdRatings.getAverageRatingsByFilter(3,filter);
        System.out.println("Filter size: "+ratingsByFilter.size());
        for (Rating rating:ratingsByFilter){
            System.out.println(rating.getValue()+" "
                    +MovieDatabase.getTitle(rating.getItem())+"\n"
                    +MovieDatabase.getDirector(rating.getItem())
                    +MovieDatabase.getMinutes(rating.getItem()));
        }



    }

}
