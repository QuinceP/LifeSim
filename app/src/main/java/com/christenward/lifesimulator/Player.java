package com.christenward.lifesimulator;

import android.content.Context;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Giraffer on 5/11/2016.
 */
public class Player {
    protected float money;
    protected String firstName;
    protected String lastName;
    protected int age;
    protected String gender;
    protected int energy;
    protected int health;
    protected int mood;
    protected int hunger;
    protected int intelligence;
    protected int strength;
    protected int charisma;
    protected String[] lifeStages = {"INFANT", "TODDLER", "PREK", "CHILD", "TEENAGER", "YOUNGADULT", "ADULT", "ELDERLY"};
    protected int stage;
    private ArrayList<Npc> family;
    private ArrayList<Npc> relationships;
    private boolean stageChanged = false;

    public Player(){
        this.family = new ArrayList<Npc>();
        this.relationships = new ArrayList<Npc>();
        this.firstName = "Jane";
        this.lastName = "Doe";
        this.money = 0;
        this.age = 0;
        this.gender = "FEMALE";
        this.energy = 100;
        this.health = 100;
        this.mood = 100;
        this.hunger = 0;
        this.intelligence = 0;
        this.strength = 0;
        this.charisma = 0;
        this.stage = 0;
    }

    public void randomPlayer(Context context){
        Random rand = new Random();
        this.money = 0;
        this.age = 0;

        NameGenerator lastNameGenerator = new NameGenerator(context, "LAST");
        this.lastName = lastNameGenerator.generateName();
        if (rand.nextInt(2) + 1 == 1 ){
            this.gender = "FEMALE";
        }
        else {
            this.gender = "MALE";
        }
        NameGenerator firstNameGenerator = new NameGenerator(context, this.getGender());
        this.firstName = firstNameGenerator.generateName();
        this.energy = 100;
        this.health = 100;
        this.mood = 100;
        this.hunger = 0;
        this.intelligence = rand.nextInt(100) + 1;
        this.strength = rand.nextInt(100) + 1;
        this.charisma = rand.nextInt(100) + 1;
        this.stage = 0;
    }

    public int getStage() {
        return stage;
    }

    public String getStageName(){
       return lifeStages[getStage()];
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public void incrementStage(){
        this.stage += 1;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void incrementAge(){
        //protected String[] lifeStages = {"INFANT", "TODDLER", "PREK", "CHILD", "TEENAGER", "YOUNGADULT", "ADULT", "ELDERLY"};
        this.age += 1;
        if (this.age == 2){ //toddler
            setStage(1);
            setStageChanged(true);
        }
        else if (this.age == 4) { //prek
            setStage(2);
            setStageChanged(true);
        }
        else if (this.age == 6) { //child
            setStage(3);
            setStageChanged(true);
        }
        else if (this.age == 13) { //teen
            setStage(4);
            setStageChanged(true);
        }
        else if (this.age == 18) { // youngadult
            setStage(5);
            setStageChanged(true);
        }
        else if (this.age == 26) { //adult
            setStage(6);
            setStageChanged(true);
        }
        else if (this.age == 61 ) { //elderly
            setStage(7);
            setStageChanged(true);
        }
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }
    public void changeEnergy(int amount){
        this.energy += amount;
        if (this.energy > 100){
            this.energy = 100;
        }
        if (this.energy < 0){
            this.energy = 0;
        }
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }

    public void changeHealth(int amount){
        this.health += amount;
        if (this.health > 100){
            this.health = 100;
        }
        if (this.health < 0){
            this.health = 0;
        }
    }

    public int getMood() {
        return mood;
    }

    public void setMood(int mood) {
        this.mood = mood;
    }

    public void changeMood(int amount){
        this.mood += amount;
        if (this.mood > 100){
            this.mood = 100;
        }
        if (this.mood < 0){
            this.mood = 0;
        }
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public void changeHunger(int amount){
        this.hunger += amount;
        if (this.hunger > 100){
            this.hunger = 100;
        }
        if (this.hunger < 0){
            this.hunger = 0;
        }
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void incrementIntelligence(){
        this.intelligence++;
        if (this.intelligence > 100){
            this.intelligence = 100;
        }
    }

    public void decrementIntelligence(){
        this.intelligence--;
        if (this.intelligence < 0){
            this.intelligence = 0;
        }
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void incrementStrength(){
        this.strength++;
        if (this.strength > 100){
            this.strength = 100;
        }
    }

    public void decrementStrength(){
        this.strength--;
        if (this.strength < 0){
            this.strength = 0;
        }
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public void incrementCharisma(){
        this.charisma++;
        if (this.charisma > 100){
            this.charisma = 100;
        }
    }

    public void decrementCharisma(){
        this.charisma--;
        if (this.charisma < 0){
            this.charisma = 0;
        }
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public void incrementMoney(float money) {
        this.money += money;
    }

    public ArrayList<Npc> getRelationships() {
        return relationships;
    }

    public void setRelationships(ArrayList<Npc> relationships) {
        this.relationships = relationships;
    }

    public ArrayList<Npc> getFamily() {
        return family;
    }

    public void setFamily(ArrayList<Npc> family) {
        this.family = family;
    }

    public void generateFamily(Context context){
        Random rand = new Random();
        int siblings = rand.nextInt(4);
        Npc mother = generateMom(context);
        mother.setRelationship("mother");
        this.family.add(mother);

        if (rand.nextInt(100) > 34){
            Npc father = generateDad(context, mother);
            father.setRelationship("father");
            this.family.add(father);
        }
        if (siblings > 0){
            for (int i = 0; i < siblings; i++){
                Npc sibling = generateSibling(context, mother);
                switch (sibling.getGender()){
                    default:
                    case "MALE":
                        sibling.setRelationship("brother");
                        break;
                    case "FEMALE":
                        sibling.setRelationship("sister");
                        break;
                }
                this.family.add(sibling);
            }
        }
        for (Npc member : this.family){
            member.setFamily(true);
            member.setRelationshipScore(100);
            member.setLastName(this.lastName);
        }
    }

    public Npc generateMom(Context context){
        Random rand = new Random();
        Npc mother = new Npc(context);
        mother.setAge(rand.nextInt(40-18) + 18);
        mother.setGender("FEMALE");
        return mother;
    }

    public Npc generateDad(Context context, Npc mother){
        Random rand = new Random();
        int minAge = (int) Math.round(Math.ceil((mother.getAge()/2) + 7));
        Npc father = new Npc(context);
        father.setAge(rand.nextInt(mother.getAge() - minAge) + minAge);
        father.setGender("MALE");
        return father;
    }

    public Npc generateSibling(Context context, Npc mother){
        Random rand = new Random();
        Npc sibling = new Npc(context);
        sibling.setAge(rand.nextInt(mother.getAge() - 16) +1);
        return sibling;
    }

    public boolean isStageChanged() {
        return stageChanged;
    }

    public void setStageChanged(boolean stageChanged) {
        this.stageChanged = stageChanged;
    }
}
