package com.example.nagendra.movie.adapters;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.nagendra.movie.Models.Moviemodel;
import com.example.nagendra.movie.R;
import com.example.nagendra.movie.SeatsActivity;
import com.example.nagendra.movie.TheatreActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static com.example.nagendra.movie.LoginActivity.mypreference;

public class TheatreAdapter extends BaseAdapter {

    Context context;
    private ArrayList<Moviemodel> moviemodels;
    private List<Moviemodel> moviemodelList = null;
    LayoutInflater inflater;
    String moviename;

    SharedPreferences sharedpreferences;

    public static final String mypreference = "mypref";
    public static final String theatrename = "theatrename";


    public TheatreAdapter(Context context, List<Moviemodel> moviemodelList) {
        this.context = context;
        this.moviemodelList = moviemodelList;
        inflater = LayoutInflater.from(context);
        this.moviemodels = new ArrayList<Moviemodel>();
        this.moviemodels.addAll(moviemodelList);
    }

    public class ViewHolder {
        TextView name;
    }

    @Override
    public int getCount() {
        return moviemodelList.size();
    }

    @Override
    public Moviemodel getItem(int i) {
        return moviemodelList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.listtheatre_item, null);
            // Locate the TextViews in listview_item.xml
            holder.name = (TextView)view.findViewById(R.id.name_theatre);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Set the results into TextViews
        holder.name.setText(moviemodelList.get(i).getMovieName());

        final String theatre_name = moviemodelList.get(i).getMovieName();

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context,SeatsActivity.class);
                /*intent.putExtra("moviename",moviename);
                intent.putExtra("theatrename",theatrename);*/

                sharedpreferences = context.getSharedPreferences(mypreference,
                        Context.MODE_PRIVATE);

                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(theatrename, theatre_name);
                editor.commit();
                context.startActivity(intent);
            }
        });


        return view;
    }

   /* private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null)
        {
            this.getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }*/

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        moviemodelList.clear();
        if (charText.length() == 0) {
            moviemodelList.addAll(moviemodels);
        } else {
            for (Moviemodel wp : moviemodels) {
                if (wp.getMovieName().toLowerCase(Locale.getDefault()).contains(charText)) {
                    moviemodelList.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }
}
