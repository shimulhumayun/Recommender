package com.company.main;

import java.util.ArrayList;

/**
 * Created by shimul on 2/20/17.
 */
public interface Rater {
    void addRating(String item, double rating);
    boolean hasRating(String item);
    String getID();
    double getRating(String item);
    int numRatings();
     ArrayList<String> getItemsRated();
}
