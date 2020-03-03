package com.example.nagendra.movie.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.nagendra.movie.Models.User;
import com.example.nagendra.movie.R;

import java.util.List;


public class UserAdapter extends BaseAdapter {

    Context context;
    List<User> users;

    public UserAdapter() {
    }

    public UserAdapter(Context context, List<User> users) {
        this.context = context;
        this.users = users;
    }

    @Override
    public int getCount() {
        return users.size();
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
        View view1 = View.inflate(context, R.layout.userslistitem,null);

        TextView username_item = (TextView)view1.findViewById(R.id.username_item);
        TextView userphone_item = (TextView)view1.findViewById(R.id.userphone_item);
        TextView usermailid_item = (TextView)view1.findViewById(R.id.usermailid_item);

        User user = users.get(i);

        username_item.setText(user.getUsername());
        userphone_item.setText(user.getUserphonenumber());
        usermailid_item.setText(user.getUseremailid());

        return view1;
    }
}
