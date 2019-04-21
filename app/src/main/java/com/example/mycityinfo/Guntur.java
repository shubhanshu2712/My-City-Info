package com.example.mycityinfo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Guntur extends AppCompatActivity {
    private ExpandableListView expandableListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guntur);

        expandableListView = findViewById(R.id.expandablelistview);

        final List<String> Headings = new ArrayList<String>();
        List<String> L1 = new ArrayList<String>();
        List<String> L2 = new ArrayList<String>();
        List<String> L3 = new ArrayList<String>();
        List<String> L4 = new ArrayList<String>();
        List<String> L5 = new ArrayList<String>();
        List<String> L6 = new ArrayList<String>();


        final HashMap<String,List<String>> Childlist = new HashMap<String, List<String>>();
        String heading_items[] = getResources().getStringArray(R.array.header_titles);
        String l1[] = getResources().getStringArray(R.array.guntur_hospital);
        String l2[] = getResources().getStringArray(R.array.guntur_schools);
        String l3[] = getResources().getStringArray(R.array.guntur_police);
        String l4[] = getResources().getStringArray(R.array.guntur_fire);
        String l5[] = getResources().getStringArray(R.array.guntur_gas);
        String l6[] = getResources().getStringArray(R.array.guntur_entertainment);

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
        for(String title: l3)
        {
            L3.add(title);
        }
        for(String title: l4)
        {
            L4.add(title);
        }
        for(String title: l5)
        {
            L5.add(title);
        }
        for(String title: l6)
        {
            L6.add(title);
        }

        Childlist.put(Headings.get(0),L1);
        Childlist.put(Headings.get(1),L2);
        Childlist.put(Headings.get(2),L3);
        Childlist.put(Headings.get(3),L4);
        Childlist.put(Headings.get(4),L5);
        Childlist.put(Headings.get(5),L6);

        ListAdapter listAdapter = new ListAdapter(this,Headings,Childlist);
        expandableListView.setAdapter(listAdapter);
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                String loc = Childlist.get(Headings.get(groupPosition)).get(childPosition).toLowerCase().replaceAll("\\s+","");
                final int location = getResources().getIdentifier(loc,"string",getPackageName());
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(getString(location)));
                startActivity(i);


                return false;
            }
        });
    }
}