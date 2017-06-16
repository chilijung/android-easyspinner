package io.canner.easyspinner;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by lijung on 6/16/17.
 */

public class SpinnerLayout extends RelativeLayout {
    protected Spinner spinnerView;

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
}
