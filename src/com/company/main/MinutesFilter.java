package com.company.main;

/**
 * Created by shimul on 2/20/17.
 */
public class MinutesFilter implements Filter {
    private int minimum;
    private int maximum;
    public MinutesFilter(int min,int max){
        this.minimum=min;
        this.maximum=max;

    }
    @Override
    public boolean satisfies(String id) {
        return MovieDatabase.getMinutes(id)>=minimum && MovieDatabase.getMinutes(id)<=maximum ;
    }
}
