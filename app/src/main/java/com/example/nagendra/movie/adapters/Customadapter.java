package com.example.nagendra.movie.adapters;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nagendra.movie.Models.Moviemodel;
import com.example.nagendra.movie.R;
import com.example.nagendra.movie.TheatreActivity;
import com.example.nagendra.movie.UserFirstActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static com.example.nagendra.movie.LoginActivity.mypreference;

public class Customadapter extends BaseAdapter{

    Context context;
    private ArrayList<Moviemodel> moviemodels;
    private List<Moviemodel> moviemodelList = null;
    LayoutInflater inflater;
    SharedPreferences sharedpreferences;

    /*public static final String mypreference = "mypref";*/
    public static final String mypreference = "mypref";
    public static final String moviename = "moviename";

   // int movieimages[] = {R.drawable.bahubali,R.drawable.anthriksham,R.drawable.fun,R.drawable.kgf,R.drawable.majnu};

    public Customadapter(Context context, List<Moviemodel> moviemodelList) {
        this.context = context;
        this.moviemodelList = moviemodelList;
        inflater = LayoutInflater.from(context);
        this.moviemodels = new ArrayList<Moviemodel>();
        this.moviemodels.addAll(moviemodelList);
    }

    public class ViewHolder {
        TextView name;
        ImageView nameLabel;
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
            view = inflater.inflate(R.layout.listview_item, null);

            // Locate the TextViews in listview_item.xml

            holder.name = (TextView) view.findViewById(R.id.name);
            holder.nameLabel = (ImageView)view.findViewById(R.id.nameLabel);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Set the results into TextViews
        holder.name.setText(moviemodelList.get(i).getMovieName());
        holder.nameLabel.setImageResource(moviemodelList.get(i).getMovieImage());

        final String movie_name = moviemodelList.get(i).getMovieName();

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context,TheatreActivity.class);

                sharedpreferences = context.getSharedPreferences(mypreference,
                        Context.MODE_PRIVATE);

                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(moviename, movie_name);
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
