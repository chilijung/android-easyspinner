package io.canner.spinnerapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;

import io.canner.easyspinner.HorizontalSpinner;

public class MainActivity extends AppCompatActivity {
    private HorizontalSpinner spinnerTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.spinnerTest = (HorizontalSpinner) findViewById(R.id.spinner1);
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

    public void clear(View view) {
        spinnerTest.clear();
    }

    public void addData(View view) {
        spinnerTest.add("test data");
    }

    public void addCollection(View view) {
        ArrayList<String> testData = new ArrayList();
        testData.add("test 1");
        testData.add("test 2");
        testData.add("test 3");
        testData.add("test 4");

        spinnerTest.addAll(testData);
    }
}
