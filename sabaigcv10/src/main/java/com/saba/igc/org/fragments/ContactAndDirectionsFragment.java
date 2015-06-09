package com.saba.igc.org.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.saba.igc.org.R;

public class ContactAndDirectionsFragment extends Fragment {

    public ContactAndDirectionsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);
        getActivity().setTitle("Contact and Directions");
//        View view = inflater.inflate(R.layout.fragment_pray_times, container, false);
//
//        View header = inflater.inflate(R.layout.header, null);
//        View footer = inflater.inflate(R.layout.footer, null);
//        ListView listView = getListView();
//        listView.addHeaderView(header);
//
//
//        setupUI(view);


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact_and_directions, container, false);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
