package io.canner.spinnerapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import io.canner.easyspinner.LeftRightSpinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LeftRightSpinner spinnerTest = (LeftRightSpinner) findViewById(R.id.spinner1);
        spinnerTest.setOnItemSelectedListener((new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // your code here
                Log.v("SpinnerTest1 position", String.valueOf(position));
                Log.v("SpinnerTest1 id", String.valueOf(id));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
                Log.v("SpinnerTest1", "nothing selected");
            }
        }));
    }
}
