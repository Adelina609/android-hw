package com.example.andrapp;

import java.util.Comparator;

public class NameComparator implements Comparator<Films> {
    @Override
    public int compare(Films film1, Films film2) {
        return film1.getName().compareTo(film2.getName());
    }
}
