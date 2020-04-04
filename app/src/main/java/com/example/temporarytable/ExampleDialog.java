package com.example.temporarytable;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class ExampleDialog extends AppCompatDialogFragment {

    private EditText edittextsno,edittextfirst,edittextnumber;
    private ExampleDialogListener listener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());

        LayoutInflater inflater=getActivity().getLayoutInflater();
        View view=inflater.inflate(R.layout.layout_dialog,null);

        //Dialog box buttons and title
        builder.setView(view)
                .setTitle("Add Details")
                .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String sno=edittextsno.getText().toString();
                        String sfirst=edittextfirst.getText().toString();
                        String snumber=edittextnumber.getText().toString();
                        listener.applyTexts(sno,sfirst,snumber);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        edittextsno=view.findViewById(R.id.edit_sno);
        edittextfirst=view.findViewById(R.id.edit_first);
        edittextnumber=view.findViewById(R.id.edit_number);
        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            listener=(ExampleDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()+"must implement ExampleDialogListener");
        }
    }

    public interface ExampleDialogListener{
        void applyTexts(String sno, String sfirst, String snumber);
    }
}
