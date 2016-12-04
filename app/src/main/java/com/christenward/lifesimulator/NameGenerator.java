package com.christenward.lifesimulator;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by pollos on 5/14/2016.
 */
    public class NameGenerator {
    private final String femaleNameFile = "female-names.txt" ;
    private final String maleNameFile = "male-names.txt" ;
    private final String lastNameFile = "last-names.txt" ;
    private ArrayList<String> contents;
    private BufferedReader reader;
    private String line;

    public NameGenerator(Context context, String type) {
        //type is MALE, FEMALE, LAST
        InputStream in;
        try {
            contents = new ArrayList<String>();
            switch (type) {
                default:
                case "FEMALE":
                    in = context.getAssets().open(femaleNameFile);
                    break;
                case "MALE":
                    in = context.getAssets().open(maleNameFile);
                    break;
                case "LAST":
                    in = context.getAssets().open(lastNameFile);
                    break;
            }
            reader = new BufferedReader(new InputStreamReader(in));
            line = reader.readLine();
            while ((line=reader.readLine()) != null)
            {
                contents.add(line);
            }

        } catch (IOException e) {
            Log.i("TAG", "couldn't read file");
        }
    }

    public String generateName(){
        Random rand = new Random();
        int randomIndex = rand.nextInt(contents.size()+1);
        return contents.get(randomIndex);
    }
}
