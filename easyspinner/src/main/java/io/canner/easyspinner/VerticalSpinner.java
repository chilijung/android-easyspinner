package io.canner.easyspinner;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by lijung on 6/16/17.
 */

public class VerticalSpinner extends SpinnerLayout {
    public VerticalSpinner(Context context ) {
        this(context, null);
    }

    public VerticalSpinner(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public VerticalSpinner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    protected void init() {
        TextView titleView = new TextView(getContext());
        Spinner spinnerView = new Spinner(getContext(), spinnerMode);
        this.spinnerView = spinnerView;
        setTextViewTextAppearance(titleView, titleStyleResId);
        // setup title view and add to relativelayout.
        titleView.setText(title);
        titleView.setId(R.id.title);
        RelativeLayout.LayoutParams titleLayoutParams = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT
        );
        titleView.setLayoutParams(titleLayoutParams);
        addView(titleView);

        // setup spinner view and add to view
        spinnerView.setPrompt(promptText);
        RelativeLayout.LayoutParams spinnerLayoutParams = new RelativeLayout.LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT
        );
        spinnerLayoutParams.addRule(RelativeLayout.BELOW, R.id.title);
        spinnerView.setLayoutParams(spinnerLayoutParams);
        spinnerView.setAdapter(this.spinnerViewAdapter);

        addView(spinnerView);
    }

    public void setTitle(String title) {
        titleView.setText(title);
    }
}