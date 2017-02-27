package com.company.main;

/**
 * Created by shimul on 2/19/17.
 */
public class GenreFilter implements Filter {
    private String genre;
    public GenreFilter(String genre){
        this.genre=genre.toLowerCase();

    }
    @Override
    public boolean satisfies(String id) {
        return MovieDatabase.getGenres(id).toLowerCase().contains(genre);
    }
}
