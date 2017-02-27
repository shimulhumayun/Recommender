package com.company.main;
/**
 * Write a description of class Rater here.
 *
 * @author Humayun Shimul
 * @version 1.0 2/13/2017
 */

import java.util.*;

public class EfficientRater implements Rater {
    private String myID;
    private HashMap<String,Rating> myRatings;
    public EfficientRater(String id) {
        myID = id;
        myRatings = new HashMap<>();
    }

    public void addRating(String item, double rating) {
        //myRatings.add(new Rating(item, rating));
        myRatings.put(item,new Rating(item,rating));
    }

    public boolean hasRating(String item) {
       /* for (int k = 0; k < myRatings.size(); k++) {
            if (myRatings.get(k).getItem().equals(item)) {
                return true;
            }
        }
*/
        return myRatings.containsKey(item);
    }

    public String getID() {
        return myID;
    }

    public double getRating(String item) {
            if (myRatings.containsKey(item)){
                return myRatings.get(item).getValue();
            }

        return -1;
    }

    public int numRatings() {
        return myRatings.size();
    }

    public ArrayList<String> getItemsRated() {
        ArrayList<String> list = new ArrayList<String>();
        for (String set:myRatings.keySet()) {
            list.add(myRatings.get(set).getItem());

        }
        return list;
    }


}
