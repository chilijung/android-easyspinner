package io.canner.easyspinner;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import io.canner.easyspinner.adapter.NothingSelectedSpinnerAdapter;

/**
 * Created by lijung on 6/16/17.
 */

public class SpinnerLayout extends RelativeLayout {
    protected Spinner spinnerView;
    protected NothingSelectedSpinnerAdapter spinnerViewAdapter;

    public SpinnerLayout(Context context, AttributeSet attrs, int defStyleArr) {
        super(context, attrs, defStyleArr);
    }

    protected void setTextViewTextAppearance(TextView titleView, int titleStyleResId) {
        if (Build.VERSION.SDK_INT < 23) {
            titleView.setTextAppearance(getContext(), titleStyleResId);
        } else {
            titleView.setTextAppearance(titleStyleResId);
        }
    }

    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener listener) {
        spinnerView.setOnItemSelectedListener(listener);
    }

    public void resetData(ArrayList<String> data) {
    }

    public void clear() {
    }
}
