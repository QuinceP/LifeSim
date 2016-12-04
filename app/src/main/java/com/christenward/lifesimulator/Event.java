package com.christenward.lifesimulator;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;

/**
 * Created by Giraffer on 5/12/2016.
 */
public class Event extends DialogFragment {
    public Event() {
        // Empty constructor required for DialogFragment
    }

    public static Event newInstance(String title, String description) {
        Event event = new Event();
        Bundle args = new Bundle();
        args.putString("title", title);
        args.putString("description", description);
        event.setArguments(args);
        return event;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String title = getArguments().getString("title");
        String description = getArguments().getString("description");
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setTitle(title);
        alertDialogBuilder.setMessage(description);
        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // on success
            }
        });

        return alertDialogBuilder.create();
    }
}