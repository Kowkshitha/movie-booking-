package com.example.nagendra.movie;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.nagendra.movie.Models.Moviemodel;
import com.example.nagendra.movie.adapters.Customadapter;

import java.util.ArrayList;
import java.util.List;

public class UserHomeFragment extends Fragment implements SearchView.OnQueryTextListener{

    ListView listView;
    SearchView searchView;
    ArrayList<Moviemodel> moviemodels = new ArrayList<Moviemodel>();
    Customadapter customadapter;


    int movieimages[] = {R.drawable.thatis,R.drawable.sira,R.drawable.jersy,R.drawable.days47,R.drawable.killer,R.drawable.majili,R.drawable.voter,R.drawable.devi,R.drawable.suryakantham};
    String names[] = {"that is mahalakshmi","Sye Raa Narasimha Reddy","Jersey","47 days","killer","Magili","Voter","Veera Maha Devi","Suryakantham"};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_user_home,
                container, false);

       listView = (ListView)view.findViewById(R.id.listview);
       searchView = (SearchView)view.findViewById(R.id.search);

       for (int i=0; i<names.length;i++)
       {
           Moviemodel moviemodel = new Moviemodel(names[i],movieimages[i]);
           moviemodels.add(moviemodel);
       }

       customadapter = new Customadapter(getContext(),moviemodels);

       listView.setAdapter(customadapter);

       searchView.setOnQueryTextListener(this);



        return view;
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {

        String text = s;
        customadapter.filter(text);

        return false;
    }
}
