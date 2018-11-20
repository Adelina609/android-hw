package com.example.andrapp;

import java.util.Comparator;

public class RatingComparator implements Comparator<Films> {
    @Override
    public int compare(Films film1, Films film2) {
        return Integer.compare(film1.getRating(), film2.getRating());
    }
}
