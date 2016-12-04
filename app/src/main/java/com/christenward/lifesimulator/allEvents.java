package com.christenward.lifesimulator;

/**
 * Created by pollos on 12/3/2016.
 */

public final class AllEvents {
    public static final NewEvent BIRTHDAY = new NewEvent("Happy Birthday", "Today you turned ");
}

class NewEvent {
    public String title;
    public String description;

    public NewEvent(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
