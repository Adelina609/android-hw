package com.example.andrapp;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.andrapp.adapter.FilmsAdapter;
import static com.example.andrapp.RecyclerFragment.adapter;

public class RecyclerFragment extends Fragment {

    public final String NAME_TEXT = "text";
    public final String NAME_VALUE = "value";


    ImageView image;
    TextView name;
    TextView rating;
    RecyclerView rv;
    static FilmsAdapter adapter;
    List<Films> list = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recyclerview_fragment, container, false);
        rv = view.findViewById(R.id.rv_main);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter = new FilmsAdapter(FilmUtils.getFilms());
        rv.setAdapter(adapter);

        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {
            case R.id.action_rating_filter:
                RecyclerFragment.getAdapter().updateList(FilmUtils.sortByRating());
                return true;
            case R.id.action_symbols_filter:
                RecyclerFragment.getAdapter().updateList(FilmUtils.sortByNames());
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public static FilmsAdapter getAdapter() {
        return adapter;
    }
}
