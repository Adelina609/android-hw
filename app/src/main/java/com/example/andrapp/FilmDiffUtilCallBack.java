package com.example.andrapp;

import android.support.v7.util.DiffUtil;

import java.util.List;

public class FilmDiffUtilCallBack extends DiffUtil.Callback {

    private final List<Films> oldList;
    private final List<Films> newList;

    public FilmDiffUtilCallBack(List<Films> oldList, List<Films> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).getRating() == newList.get(newItemPosition).getRating();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).getName().equals(newList.get(newItemPosition).getName());
    }
}
