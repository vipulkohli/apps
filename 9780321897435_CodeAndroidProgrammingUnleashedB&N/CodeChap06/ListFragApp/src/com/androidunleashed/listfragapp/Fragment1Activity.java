package com.androidunleashed.listfragapp;

import android.app.ListFragment;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class Fragment1Activity extends ListFragment {
    final String[] fruits={"Apple", "Mango", "Orange", "Grapes", "Banana"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayAdapter<String> arrayAdpt = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, fruits);
        setListAdapter(arrayAdpt);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        TextView selectedOpt = (TextView) getActivity().findViewById(R.id.selectedopt);
        selectedOpt.setText("You have selected "+((TextView) v).getText().toString());
    }
}
