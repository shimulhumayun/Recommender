package com.company.main;

import java.util.ArrayList;
import java.util.HashMap;

public class Recommender {

    public static void main(String[] args) {
	// write your code here
         testLoadMovies();
        //testLoadRaters();

    }
    //////////////////Week1/////////////assignment part 1
    public static void testLoadMovies(){
        FirstRatings ratings=new FirstRatings();
        ArrayList<Movie>movieArrayList=ratings.loadMovies
                ("/Users/shimul/MEGA/Recommender/src/com/company/data/ratedmovies_short.csv");
        System.out.println(movieArrayList.size());
        //check for the genere
        //getGenreCount(movieArrayList);
        //2)how many movies are greater than 150 minutes in length
         //minutesGreaterThan(movieArrayList);
        //maximum number of movies by any director
         //numberOfDirector(movieArrayList);
    }

    private static void numberOfDirector(ArrayList<Movie> movieArrayList) {
        HashMap<String,Integer> map=new HashMap<>();
        for (Movie m: movieArrayList){
            String[]list=m.getDirector().split(",");
            for (int i = 0; i <list.length ; i++) {
                 if (!map.containsKey(list[i])){
                       map.put(list[i],1);
                 }
                 else {
                     map.put(list[i],map.get(list[i])+1);

                 }
            }
        }
        nameOfDirector(map);
    }

    private static void nameOfDirector(HashMap<String, Integer> map) {
        int max=0;
        String director="";
        for (String k: map.keySet()){
            int current=map.get(k);
            if (current>max){
                max=current;
                director=k;
            }

        }
        System.out.println("Name: "+director);
    }

    private static void minutesGreaterThan(ArrayList<Movie> movieArrayList) {
        int mCount=0;

        for (Movie m: movieArrayList){
            if (m.getMinutes()>150){
                mCount++;
            }
        }
        System.out.println("Minute greater than 150 "+ mCount);
    }

    private static void getGenreCount(ArrayList<Movie> movieArrayList) {
        int gCount=0;
        //1)how many movies include the Comedy genre.
        for (Movie m: movieArrayList){
             if (m.getGenres().contains("Comedy")){
                 gCount++;
             }
        }

        System.out.println("Genre of type count: "+gCount);
    }

    //////////////////Week1-Part2///////////////////////////
    public static void testLoadRaters(){
        FirstRatings ratings=new FirstRatings();
        ArrayList<EfficientRater> raterArrayList=ratings.loadRaters
                ("/Users/shimul/MEGA/Recommender/src/com/company/data/ratings.csv");
        //find the number of ratings for a particular rater
        //ratingByParticularUser(raterArrayList);
        //Add code to find the maximum number of ratings by any rater
         //maxRatingByAnyRater(raterArrayList);
        // find the number of ratings a particular movie has.
        //numberOfRatings(raterArrayList);
        // how many different movies have been rated by all these raters.
        differentMoviesRated(raterArrayList);
        

    }

    private static void differentMoviesRated(ArrayList<EfficientRater> raterArrayList) {
        ArrayList<String>differentMovies=new ArrayList<>();
        for (EfficientRater r:raterArrayList) {
            ArrayList<String> stringArrayList=r.getItemsRated();
            for (int i = 0; i <stringArrayList.size() ; i++) {
                if (!differentMovies.contains(stringArrayList.get(i))){
                    differentMovies.add(stringArrayList.get(i));

                }

            }


        }
        System.out.println("Different Movies: "+differentMovies.size());
    }

    private static void numberOfRatings(ArrayList<PlainRater> raterArrayList) {
        int count=0;
        for (PlainRater rate: raterArrayList) {
               if (rate.hasRating("1798709")){
                   count++;
               }

        }
        System.out.println("Count of rater: "+count);
    }

    //find the maximum number of ratings by any rater
    private static void maxRatingByAnyRater(ArrayList<PlainRater> raterArrayList) {
        int max=0;
        String id="";
        for (PlainRater rate:raterArrayList) {
               if (rate.numRatings()>max){
                   max=rate.numRatings();
                   id=rate.getID();
               }
        }
        System.out.println("Max "+max+" by the id# "+id);
    }
    //find the number of ratings for a particular rater
    private static void ratingByParticularUser(ArrayList<PlainRater> arrayList) {
        for (PlainRater t: arrayList){
            if (t.getID().equalsIgnoreCase("193")){
                System.out.println("Total number of rating by the rater: "+t.numRatings());
            }
        }
    }


}
