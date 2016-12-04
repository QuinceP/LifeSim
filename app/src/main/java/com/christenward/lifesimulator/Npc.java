package com.christenward.lifesimulator;

import android.content.Context;

import java.util.Random;

/**
 * Created by pollos on 5/14/2016.
 */
public class Npc extends Player {
    private int relationshipScore;
    private String relationship;
    private boolean family;
    private NameGenerator firstNameGenerator;
    private NameGenerator lastNameGenerator;

    Npc (Context context){
        lastNameGenerator = new NameGenerator(context, "LAST");
        Random rand = new Random();
        if (rand.nextInt(2) + 1 == 1 ){
            this.gender = "FEMALE";
        }
        else {
            this.gender = "MALE";
        }
        firstNameGenerator = new NameGenerator(context, this.getGender());
        this.firstName = firstNameGenerator.generateName();
        this.money = 0;
        this.age = 0;
        this.energy = 100;
        this.health = 100;
        this.mood = 100;
        this.hunger = 0;
        this.intelligence = rand.nextInt(100) + 1;
        this.strength = rand.nextInt(100) + 1;
        this.charisma = rand.nextInt(100) + 1;
        this.stage = 0;
        this.family = false;
    }

    public int getRelationshipScore() {
        return relationshipScore;
    }

    public void setRelationshipScore(int relationshipScore) {
        this.relationshipScore = relationshipScore;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public boolean isFamily() {
        return family;
    }

    public void setFamily(boolean family) {
        this.family = family;
    }
}
