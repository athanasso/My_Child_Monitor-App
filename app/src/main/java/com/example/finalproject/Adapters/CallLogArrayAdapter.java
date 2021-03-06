package com.example.finalproject.Adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.finalproject.Fragments.ShowCallLog;
import com.example.finalproject.Models.CallLogModel;
import com.example.finalproject.R;

import java.util.List;


//we need to extend the ArrayAdapter class as we are building an adapter
public class CallLogArrayAdapter extends ArrayAdapter<CallLogModel> {

    //the list values in the List of type hero
    List<CallLogModel> heroList;

    //activity context
    Context context;

    //the layout resource file for the list items
    int resource;

    //constructor initializing the values
    public CallLogArrayAdapter(Context context, List<CallLogModel> heroList) {
        super(context, R.layout.fragment_show_call_log, heroList);
        this.context = context;
        ///this.resource = resource;
        this.heroList = heroList;
    }



    //this will return the ListView Item as a View
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //we need to get the view of the xml for our list item
        //And for this we need a layoutinflater
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        //getting the view
        View listViewItem = layoutInflater.inflate(R.layout.custom_call_log_view, null, true);

        //getting the view elements of the list from the view
        TextView callName = listViewItem.findViewById(R.id.callName);
        TextView callNumber = listViewItem.findViewById(R.id.callNumber);
        TextView callDuration = listViewItem.findViewById(R.id.callDuration);
        TextView callDate = listViewItem.findViewById(R.id.callDate);
        TextView callType = listViewItem.findViewById(R.id.callType);

        //getting the hero of the specified position
        CallLogModel callLogs = heroList.get(position);


        callName.setText(callLogs.getCallName());
        callNumber.setText(callLogs.getCallNumber());
        callDuration.setText(callLogs.getDuration());
        callDate.setText(callLogs.getCallDate());
        callType.setText(callLogs.getCallType());

        //finally returning the view
        return listViewItem;
    }

}