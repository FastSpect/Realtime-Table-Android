package com.example.temporarytable;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.ViewGroup.LayoutParams;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.TableLayout;


public class MainActivity extends AppCompatActivity implements ExampleDialog.ExampleDialogListener {
    TableLayout table;
    TableRow.LayoutParams params1;
    private TextView s1,s2,s3;
    private Button adddetails;
    LayoutParams params2, params3;
    TableRow row;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        table = (TableLayout) findViewById(R.id.table1);

        TextView t1, t2, t3;
        row = new TableRow(this);
        t1 = new TextView(this);
        t2 = new TextView(this);
        t3 = new TextView(this);

        //Change the titles of the table
        params1 = new TableRow.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, 1);
        params2 = new TableRow.LayoutParams(0, LayoutParams.WRAP_CONTENT, 0.3f);
        params3 = new TableRow.LayoutParams(0, LayoutParams.WRAP_CONTENT, 1);
        t1.setLayoutParams(params2);
        t2.setLayoutParams(params3);
        t3.setLayoutParams(params3);
        row.setLayoutParams(params1);
        t1.setBackgroundColor(Color.YELLOW);
        t3.setBackgroundColor(Color.YELLOW);
        t1.setTypeface(Typeface.DEFAULT_BOLD);
        t2.setTypeface(Typeface.DEFAULT_BOLD);
        t3.setTypeface(Typeface.DEFAULT_BOLD);
        t1.setTextColor(Color.BLACK);
        t2.setTextColor(Color.BLACK);
        t3.setTextColor(Color.BLACK);
        t1.setGravity(1);
        t2.setGravity(1);
        t3.setGravity(1);
        t1.setText("S.No.");
        row.addView(t1);
        t2.setText("First");
        row.addView(t2);
        t3.setText("1st");
        row.addView(t3);
        table.addView(row, new TableLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

        //Add details button
        adddetails = (Button) findViewById(R.id.adddetails);
        adddetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
    }

    //Function to open add details dialog box
    public void openDialog(){
        ExampleDialog exampleDialog=new ExampleDialog();
        exampleDialog.show(getSupportFragmentManager(),"example dialog");
    }

    @Override
    public void applyTexts(String sno, String sfirst, String snumber) {
        createrow(sno, sfirst, snumber);
    }

    //Separate function to create rows
    public void createrow(String sno, String sfirst, String snumber){
        s1 = new TextView(this);
        s2 = new TextView(this);
        s3 = new TextView(this);
        row = new TableRow(this);
        int c=table.getChildCount();
        s1.setLayoutParams(params2);
        s2.setLayoutParams(params3);
        s3.setLayoutParams(params3);
        row.setLayoutParams(params1);
        s1.setBackgroundColor(Color.YELLOW);
        s3.setBackgroundColor(Color.YELLOW);
        s1.setTextColor(Color.BLACK);
        s2.setTextColor(Color.BLACK);
        s3.setTextColor(Color.BLACK);
        s1.setGravity(1);
        s2.setGravity(1);
        s3.setGravity(1);
        s1.setText(sno);
        row.addView(s1);
        s2.setText(sfirst);
        row.addView(s2);
        s3.setText(snumber);
        row.addView(s3);
        table.addView(row, new TableLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
    }
}
