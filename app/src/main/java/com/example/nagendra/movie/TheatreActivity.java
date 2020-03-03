package com.example.nagendra.movie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.nagendra.movie.Models.Moviemodel;
import com.example.nagendra.movie.adapters.Customadapter;
import com.example.nagendra.movie.adapters.TheatreAdapter;

import java.util.ArrayList;

public class TheatreActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    SearchView search_theatre;
    ListView theatre_list;
    ArrayList<Moviemodel> theatrearraylist = new ArrayList<Moviemodel>();
    Customadapter customadapter;
    TheatreAdapter theatreAdapter;

    /*Bundle extras = getIntent().getExtras();

    String moviename = extras.getString("movie_name");
*/
    String names[] = {"S2 cinemas","The cinemas","Archana","Siri","Narthaki","Leela mahal"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theatre);

        theatre_list = (ListView)findViewById(R.id.theatre_list);
        search_theatre = (SearchView)findViewById(R.id.search_theatre);

        for (int i=0; i<names.length;i++)
        {
            Moviemodel moviemodel = new Moviemodel(names[i]);
            theatrearraylist.add(moviemodel);
        }

        theatreAdapter = new TheatreAdapter(TheatreActivity.this,theatrearraylist);

        theatre_list.setAdapter(theatreAdapter);

        search_theatre.setOnQueryTextListener(TheatreActivity.this);

    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {

        String text = s;
        theatreAdapter.filter(text);

        return false;
    }
}
