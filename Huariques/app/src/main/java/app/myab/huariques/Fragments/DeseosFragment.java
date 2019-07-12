package app.myab.huariques.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.myab.huariques.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DeseosFragment extends Fragment {


    public DeseosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_deseos, container, false);
    }

}
