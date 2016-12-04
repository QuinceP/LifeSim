package com.christenward.lifesimulator;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class EnergyFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_energy_infant, container,
                false);
        Button sleepButton = (Button) rootView.findViewById(R.id.sleep_button);
        sleepButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getContext(), "Slept for 8 hours.", Toast.LENGTH_SHORT);
                toast.show();
                for (int i = 0; i < 8; i++) {
                    ((MainActivity) getActivity()).getClock().incrementHours();
                }
                ((MainActivity)getActivity()).updateTime();
            }
        });
        return rootView;
    }
}