package com.company.main;

/**
 * Created by shimul on 2/15/17.
 */

import com.company.duke.*;

import java.util.*;

import com.company.commons.*;

public class FirstRatings {

    public ArrayList<Movie> loadMovies(String fileName) {
        ArrayList<Movie> movieList = new ArrayList<>();
        FileResource resource = new FileResource(fileName);
        CSVParser parser = resource.getCSVParser(true);
        for (CSVRecord record : parser) {
            Movie movie = new Movie(record.get("id"), record.get("title"), record.get("year"),
                    record.get("genre"), record.get("director"),
                    record.get("country"), record.get("poster"),
                    Integer.parseInt(record.get("minutes")));
            movieList.add(movie);
        }

        return movieList;

    }

    public ArrayList<EfficientRater> loadRaters(String fileName) {
        ArrayList<EfficientRater> ratingList = new ArrayList<>();
        FileResource resource = new FileResource(fileName);
        CSVParser parser = resource.getCSVParser(true);
        for (CSVRecord record : parser) {
            //for every record get the rater id
            //PlainRater rate = new PlainRater(record.get("rater_id"));
            EfficientRater rate=new EfficientRater(record.get("rater_id"));
            if (!contains(rate, ratingList)) {
                rate.addRating(record.get("movie_id"), Integer.parseInt(record.get(("rating"))));
                ratingList.add(rate);
            } else {
                //if it's there then use a for loop top modify
                modifyRating(rate, record, ratingList);

            }
        }
        return ratingList;

    }

    private void modifyRating(EfficientRater rate, CSVRecord record, ArrayList<EfficientRater> ratingList) {
        for (int i = 0; i < ratingList.size(); i++) {
            if (ratingList.get(i).getID().equalsIgnoreCase(rate.getID())) {
                ratingList.get(i).addRating(record.get("movie_id"), Integer.parseInt(record.get("rating")));
            }
        }

    }

    //helper method to check if list contains the id
    private boolean contains(EfficientRater find, ArrayList<EfficientRater> raters) {
        for (int i = 0; i < raters.size(); i++) {
            if (raters.get(i).getID().equalsIgnoreCase(find.getID())) {
                return true;
            }
        }
        return false;

    }


}
