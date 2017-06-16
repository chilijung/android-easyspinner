package io.canner.spinnercollection;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import io.canner.spinnercollection.adapter.NothingSelectedSpinnerAdapter;

/**
 * Created by lijung on 6/16/17.
 */

public class LeftRightSpinner extends LinearLayout {
    private String title = "";
    private int entriesResId;

    public LeftRightSpinner(Context context ) {
        this(context, null);
    }

    public LeftRightSpinner(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LeftRightSpinner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray arr = context.obtainStyledAttributes(attrs, R.styleable.LeftRightSpinner);
        CharSequence title = arr.getString(R.styleable.LeftRightSpinner_title);
        int entriesResId = arr.getResourceId(R.styleable.LeftRightSpinner_entries, 0);

        if (title != null) {
            this.title = title.toString();
        }

        if (entriesResId != 0) {
            this.entriesResId = entriesResId;
        }

        arr.recycle();  // Do this when done.
        init();
    }

    private void init() {
        View rootView = LayoutInflater.from(getContext()).inflate(R.layout.spinner_left_right_form, this);
        TextView titleView = (TextView) rootView.findViewById(R.id.spinner_form_title);
        Spinner spinnerView = (Spinner) rootView.findViewById(R.id.spinner_form_choose);

        titleView.setText(title);
        spinnerView.setPrompt(title);
        ArrayAdapter<CharSequence> spinnerArrayAdapter = ArrayAdapter.createFromResource(getContext(), entriesResId, R.layout.spinner_item_selected);
        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        spinnerView.setAdapter(
                new NothingSelectedSpinnerAdapter(
                        spinnerArrayAdapter,
                        R.layout.spinner_row_nothing_selected,
                        getContext()
                )
        );
    }
}
