package io.canner.easyspinner;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.Spinner;

/**
 * Created by lijung on 6/16/17.
 */

public class SimpleSpinner extends SpinnerLayout {
    public SimpleSpinner(Context context ) {
        this(context, null);
    }

    public SimpleSpinner(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SimpleSpinner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    protected void init() {
        spinnerView = new Spinner(getContext(), spinnerMode);

        // setup spinner view and add to view
        spinnerView.setPrompt(promptText);
        RelativeLayout.LayoutParams spinnerLayoutParams = new RelativeLayout.LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT
        );
        spinnerView.setLayoutParams(spinnerLayoutParams);
        spinnerView.setAdapter(this.spinnerViewAdapter);

        addView(spinnerView);
    }

    // simple spinner don't have title
    public void setTitle(String title) {}
}
