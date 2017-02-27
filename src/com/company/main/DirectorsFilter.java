package com.company.main;

/**
 * Created by shimul on 2/20/17.
 */
/*Create a new class named DirectorsFilter that implements Filter. The constructor should have one parameter named
directors representing a list of directors separated by commas (Example: "Charles Chaplin,Michael Mann,Spike Jonze",
 and its satisfies method should return true if a movie has at least one of these directors as one of its directors.
 Note that each movie may have several directors.*/
public class DirectorsFilter implements Filter {
    private String director[];
    public DirectorsFilter(String dir){
        director=dir.split(",");

    }
    @Override
    public boolean satisfies(String id) {
        for (String d:director) {
            if (MovieDatabase.getDirector(id).toLowerCase().contains(d.toLowerCase())){
                return true;
            }

        }

        return false;
    }
}
