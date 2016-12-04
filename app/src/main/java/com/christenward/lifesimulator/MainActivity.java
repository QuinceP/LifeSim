package com.christenward.lifesimulator;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Main Activity, handles time and events and swiping between stat fragments
 */

public class MainActivity extends FragmentActivity {
    private ViewPager mViewPager;
    private MoodFragment moodFragment;
    private HealthFragment healthFragment;
    private EnergyFragment energyFragment;
    private HungerFragment hungerFragment;
    private Clock clock;
    private Player player;

    /**
     * Initializes the layout
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        player = new Player();
        player.randomPlayer(this);
        player.generateFamily(this);
        clock = new Clock();
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(new SamplePagerAdapter(
                getSupportFragmentManager()));
        String hours = String.valueOf(clock.getHours());
        String minutes = String.valueOf(clock.getMinutes());
        if (hours.length() == 1){
            hours = "0" + hours;
        }
        if (minutes.length() == 1){
            minutes = "0" + minutes;
        }
        String time = hours + ":" + minutes;
        String day = "Day " + String.valueOf(clock.getDays());
        TextView dayText = (TextView) findViewById(R.id.dayText);
        TextView timeText = (TextView) findViewById(R.id.timeText);
        dayText.setText(day);
        timeText.setText(time);
        NameGenerator firstName = new NameGenerator(this, "MALE");
        NameGenerator lastName = new NameGenerator(this, "LAST");
        showEvent("Welcome", getFamilyBlurb());
    }

    /** Defining a FragmentPagerAdapter class for controlling the fragments to be shown when user swipes on the screen. */
    public class SamplePagerAdapter extends FragmentPagerAdapter {

        public SamplePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            /** Show a Fragment based on the position of the current screen */
            switch (position){
                case 0:
                    return new EnergyFragment();
                case 1:
                    return new HealthFragment();
                case 2:
                    return new HungerFragment();
                case 3:
                    return new MoodFragment();
                case 4:
                    return new StatsFragment();
                default:
                    return new EnergyFragment();
            }
        }

        @Override
        public int getCount() {
            return 5;
        }
    }

    /**
     * Changes the time on the clock and displays it
     */
    public void updateTime(){
        String hours = String.valueOf(clock.getHours());
        String minutes = String.valueOf(clock.getMinutes());
        if (hours.length() == 1){
            hours = "0" + hours;
        }
        if (minutes.length() == 1){
            minutes = "0" + minutes;
        }
        String time = hours + ":" + minutes;
        String day = "Day " + String.valueOf(clock.getDays());
        TextView dayText = (TextView) findViewById(R.id.dayText);
        TextView timeText = (TextView) findViewById(R.id.timeText);
        dayText.setText(day);
        timeText.setText(time);
    }

    /**
     *
     * @return clock
     */
    public Clock getClock(){
        return clock;
    }

    /**
     *
     * @param c = a Clock
     */
    public void setClock(Clock c){
        clock = c;
    }

    public Player getPlayer(){
        return player;
    }

    /**
     * Shows an Event given a title and an event description
     * @param title
     * @param description
     */
    public void showEvent(String title, String description){
        FragmentManager fm = getSupportFragmentManager();
        Event event = new Event();
        event = event.newInstance(title, description);
        event.show(fm, "new event");
    }

    public String getFamilyBlurb(){
        String blurb = "Your name is " + getPlayer().getFirstName() + " " + player.getLastName() + ". ";
        for (Npc member : player.getFamily()){
            blurb = blurb + "You have a " + member.getRelationship() + " named " + member.getFirstName() + ". ";
            if (member.getGender() == "MALE"){
                blurb = blurb + "He is " + member.getAge() + " years old. ";
            }
            else{
                blurb = blurb + "She is " + member.getAge() + " years old. ";
            }
        }
        return blurb;
    }
}

