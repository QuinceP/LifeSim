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
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_stats, container,
                false);
        Player player = ((MainActivity)getActivity()).getPlayer();

        TextView nameValue = (TextView) rootView.findViewById(R.id.name_value);
        TextView ageValue = (TextView) rootView.findViewById(R.id.age_value);
        TextView stageValue = (TextView) rootView.findViewById(R.id.stage_value);
        TextView moneyValue = (TextView) rootView.findViewById(R.id.money_value);
        TextView intelligenceValue = (TextView) rootView.findViewById(R.id.intelligence_value);
        TextView strengthValue = (TextView) rootView.findViewById(R.id.strength_value);
        TextView charismaValue = (TextView) rootView.findViewById(R.id.charisma_value);

        String name = player.getFirstName() +" " + player.getLastName();
        String age = String.valueOf(player.getAge()) + " - ";
        nameValue.setText(name);
        ageValue.setText(age);
        stageValue.setText(player.getStageName().toLowerCase());
        moneyValue.setText(String.valueOf(player.getMoney()));
        intelligenceValue.setText(String.valueOf(player.getIntelligence()));
        strengthValue.setText(String.valueOf(player.getStrength()));
        charismaValue.setText(String.valueOf(player.getCharisma()));

        return rootView;
    }
}