package com.christenward.lifesimulator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;


public class StatsFragment extends Fragment {
    Player player;
    TextView nameValue;
    TextView ageValue;
    TextView stageValue;
    TextView moneyValue;
    TextView intelligenceValue;
    TextView strengthValue;
    TextView charismaValue;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_stats, container,
                false);
        player = ((MainActivity)getActivity()).getPlayer();
        nameValue = (TextView) rootView.findViewById(R.id.name_value);
        ageValue = (TextView) rootView.findViewById(R.id.age_value);
        stageValue = (TextView) rootView.findViewById(R.id.stage_value);
        moneyValue = (TextView) rootView.findViewById(R.id.money_value);
        intelligenceValue = (TextView) rootView.findViewById(R.id.intelligence_value);
        strengthValue = (TextView) rootView.findViewById(R.id.strength_value);
        charismaValue = (TextView) rootView.findViewById(R.id.charisma_value);

        updateStats();

        return rootView;
    }

    @Override public void onResume() {
        super.onResume();

    }

    public void updateStats () {
        String name = player.getFirstName() +" " + player.getLastName();
        String age = String.valueOf(player.getAge()) + " - ";
        nameValue.setText(name);
        ageValue.setText(age);
        stageValue.setText(player.getStageName().toLowerCase());
        moneyValue.setText(String.valueOf(player.getMoney()));
        intelligenceValue.setText(String.valueOf(player.getIntelligence()));
        strengthValue.setText(String.valueOf(player.getStrength()));
        charismaValue.setText(String.valueOf(player.getCharisma()));
    }

}