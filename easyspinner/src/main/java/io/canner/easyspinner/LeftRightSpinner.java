package io.canner.easyspinner;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import io.canner.easyspinner.adapter.NothingSelectedSpinnerAdapter;

/**
 * Created by lijung on 6/16/17.
 */

public class LeftRightSpinner extends SpinnerLayout {
    public LeftRightSpinner(Context context ) {
        this(context, null);
    }

    public LeftRightSpinner(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LeftRightSpinner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    protected void init() {
        TextView titleView = new TextView(getContext());
        Spinner spinnerView = new Spinner(getContext(), spinnerMode);
        this.spinnerView = spinnerView;
        setTextViewTextAppearance(titleView, titleStyleResId);
        // setup title view and add to relativelayout.
        titleView.setText(title);
        RelativeLayout.LayoutParams titleLayoutParams = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT
        );
        titleLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        titleView.setLayoutParams(titleLayoutParams);
        addView(titleView);

        // setup spinner view and add to view
        spinnerView.setPrompt(promptText);
        RelativeLayout.LayoutParams spinnerLayoutParams = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT
        );
        spinnerLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        spinnerView.setLayoutParams(spinnerLayoutParams);
        spinnerView.setAdapter(this.spinnerViewAdapter);

        addView(spinnerView);
    }
}
