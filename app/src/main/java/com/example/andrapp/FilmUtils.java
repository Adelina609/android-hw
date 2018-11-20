package com.example.andrapp;


import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.schedulers.Schedulers;

public class FilmUtils {

    public static List<Films> list = new ArrayList<>();

    public static List<Films> getFilms(){
        list.add(new Films("WERTYU", 3, R.drawable.butterfly));
        list.add(new Films("DFGVHBJNKM", 1, R.drawable.butterfly));
        list.add(new Films("VBNMV ", 2, R.drawable.butterfly));
        list.add(new Films("ame", 5, R.drawable.butterfly));
        list.add(new Films("ame", 4, R.drawable.butterfly));
        list.add(new Films("ame", 6, R.drawable.butterfly));
        list.add(new Films("ame", 7, R.drawable.butterfly));
        list.add(new Films("ame", 8, R.drawable.butterfly));
        list.add(new Films("ame", 9, R.drawable.butterfly));
        list.add(new Films("ame", 10, R.drawable.butterfly));
        list.add(new Films("ame", 11, R.drawable.butterfly));
        list.add(new Films("ame", 12, R.drawable.butterfly));
        list.add(new Films("ame", 13, R.drawable.butterfly));
        list.add(new Films("ame", 14, R.drawable.butterfly));
        list.add(new Films("ame", 15, R.drawable.butterfly));
        list.add(new Films("ame", 16, R.drawable.butterfly));
        list.add(new Films("ame", 17, R.drawable.butterfly));
        list.add(new Films("ame", 18, R.drawable.butterfly));
        return list;
    }



    public static List<Films> sortByRating(){
        Observable<Films> filmsObservable = Observable.from(list);
        filmsObservable
                .take(12)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
                .toSortedList(new Func2<Films, Films, Integer>() {
                    @Override
                    public Integer call(Films film1, Films film2) {
                        return new RatingComparator().compare(film1, film2);
                    }
                }).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<Films>>() {
                    @Override
                    public void call(List<Films> films) {
                        list = films;
                    }
                });
        return list;
    }

    public static List<Films> sortByNames(){
        Observable<Films> filmsObservable = Observable.from(list);
        filmsObservable.subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
                .toSortedList(new Func2<Films, Films, Integer>() {
                    @Override
                    public Integer call(Films films, Films films2) {
                        return new RatingComparator().compare(films, films2);
                    }
                }).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<Films>>() {
                    @Override
                    public void call(List<Films> films) {
                        list = films;
                    }
                });
        return list;
    }



}
