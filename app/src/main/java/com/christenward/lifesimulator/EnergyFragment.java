package com.christenward.lifesimulator;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
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

        //adding dynamic buttons. need to find a way to make this scroll
//        ViewGroup viewGroup = (ViewGroup) rootView;
//        for (int i = 0; i < 10; i++){
//            //Set a linearLayout to add buttons
//            LinearLayout linearLayout = new LinearLayout(getActivity());
//            // Set the layout full width, full height
//            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
//            linearLayout.setLayoutParams(params);
//            linearLayout.setOrientation(LinearLayout.HORIZONTAL); //or VERTICAL
//            Button button = new Button(getActivity());
//            //For buttons visibility, you must set the layout params in order to give some width and height:
//            params = new LinearLayout.LayoutParams(sleepButton.getLayoutParams());
//            int dpToPixels = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
//                    (float) 70*(i+1), getResources().getDisplayMetrics());
//            params.setMargins(0, dpToPixels, 0, 0);
//            button.setLayoutParams(params);
//            button.setText(String.valueOf(i));
//            linearLayout.addView(button);
//
//            viewGroup.addView(linearLayout);
//        }

        return rootView;
    }
}