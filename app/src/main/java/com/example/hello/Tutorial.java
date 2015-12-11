package com.example.hello;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Tutorial extends AppCompatActivity
        // Since the form has a button, we have to implement
        // onClickListener
        implements View.OnClickListener
{

    TextView textWidget;
    Button   button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        //In activity_tutorial.xml file, you will have add a TextView widget
        // with id=idTutorialText.
        //Get a handle to the widget and set its value as shown below in the code.

        //You can uncomment the lines below and then run the Tutorial activity
        //
        // textWidget = (TextView) findViewById(R.id.idTutorialText);

        // textWidget.setText("My 1st Android Tutorial");

        //Get a handle to the Button widget and set its onClick listener (or
        //callback function.

        // button = (Button) findViewById(R.id.idTutorialButton);
        // button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        //Show a Toast message and set the text.

        //String text = "Great Job on Completing the Tutorial!";

        //Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
        //textWidget.setText(text);

    }
}
