package com.innodroid.mongobrowser;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MongoConnectionDetailFragment extends Fragment {

    public static final String ARG_ITEM_ID = "item_id";

    public MongoConnectionDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
        	//long id = getArguments().getLong(ARG_ITEM_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_mongoconnection_detail, container, false);
        //if (mItem != null) {
            //((TextView) rootView.findViewById(R.id.mongoconnection_detail)).setText(mItem.content);
        //}
        return rootView;
    }
}