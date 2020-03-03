package com.example.nagendra.movie.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.nagendra.movie.Models.TheatreModel;
import com.example.nagendra.movie.R;

import java.util.List;

public class UserBookingAdapter extends BaseAdapter {

    Context context;
    List<TheatreModel> theatreModelList;

    public UserBookingAdapter() {
    }

    public UserBookingAdapter(Context context, List<TheatreModel> theatreModelList) {
        this.context = context;
        this.theatreModelList = theatreModelList;
    }

    @Override
    public int getCount() {
        return theatreModelList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View view1 = View.inflate(context, R.layout.adminusersbooking,null);

        TextView admin_user_mailid_item = (TextView)view1.findViewById(R.id.admin_user_mailid_item);
        TextView admin_user_moviename_item = (TextView)view1.findViewById(R.id.admin_user_moviename_item);
        TextView admin_user_theatrename_item = (TextView)view1.findViewById(R.id.admin_user_theatrename_item);
        TextView admin_user_noofseats_item = (TextView)view1.findViewById(R.id.admin_user_noofseats_item);


        TheatreModel theatreModel = theatreModelList.get(i);

        admin_user_mailid_item.setText(theatreModel.getUsermailid());
        admin_user_moviename_item.setText(theatreModel.getMoviename());
        admin_user_theatrename_item.setText(theatreModel.getTheatrename());
        admin_user_noofseats_item.setText(theatreModel.getNoofseats());

        return view1;
    }
}
