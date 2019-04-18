package com.example.mycityinfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Agartala extends AppCompatActivity {
    private ExpandableListView expandableListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agartala);

        expandableListView = findViewById(R.id.expandablelistview);

        final List<String> Headings = new ArrayList<String>();
        List<String> L1 = new ArrayList<String>();
        List<String> L2 = new ArrayList<String>();

        HashMap<String,List<String>> Childlist = new HashMap<String, List<String>>();
        String heading_items[] = getResources().getStringArray(R.array.header_titles);
        String l1[] = getResources().getStringArray(R.array.child_hospital);
        String l2[] = getResources().getStringArray(R.array.child_schools);

        for(String title: heading_items)
        {
            Headings.add(title);
        }
        for(String title: l1)
        {
            L1.add(title);
        }
        for(String title: l2)
        {
            L2.add(title);
        }

        Childlist.put(Headings.get(0),L1);
        Childlist.put(Headings.get(1),L2);
        ListAdapter listAdapter = new ListAdapter(this,Headings,Childlist);
        expandableListView.setAdapter(listAdapter);
    }
}
