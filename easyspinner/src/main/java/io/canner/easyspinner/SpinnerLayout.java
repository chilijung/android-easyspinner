package io.canner.easyspinner;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import io.canner.easyspinner.adapter.NothingSelectedSpinnerAdapter;

/**
 * Created by lijung on 6/16/17.
 */

abstract public class SpinnerLayout extends RelativeLayout {
    protected Spinner spinnerView;
    protected NothingSelectedSpinnerAdapter spinnerViewAdapter;
    protected String title = "";
    protected List<String> entries;
    protected int titleStyleResId;
    protected int spinnerMode;
    protected int nothingSelectedLayout;
    protected int itemLayout;
    protected int itemSelectedLayout;
    protected String promptText;
    protected TextView titleView = new TextView(getContext());

    public SpinnerLayout(Context context, AttributeSet attrs, int defStyleArr) {
        super(context, attrs, defStyleArr);
        TypedArray arr = context.obtainStyledAttributes(attrs, io.canner.easyspinner.R.styleable.EasySpinner);
        CharSequence title = arr.getString(io.canner.easyspinner.R.styleable.EasySpinner_title);
        int entriesResId = arr.getResourceId(io.canner.easyspinner.R.styleable.EasySpinner_entries, 0);
        this.titleStyleResId = arr.getResourceId(io.canner.easyspinner.R.styleable.EasySpinner_titleTextStyle, io.canner.easyspinner.R.style.innerText);
        this.spinnerMode = arr.getInt(io.canner.easyspinner.R.styleable.EasySpinner_spinnerMode, 0);
        this.nothingSelectedLayout = arr.getResourceId(io.canner.easyspinner.R.styleable.EasySpinner_nothingSelectedLayout, io.canner.easyspinner.R.layout.spinner_row_nothing_selected);
        this.itemLayout = arr.getResourceId(io.canner.easyspinner.R.styleable.EasySpinner_itemLayout, io.canner.easyspinner.R.layout.spinner_item);
        this.itemSelectedLayout = arr.getResourceId(io.canner.easyspinner.R.styleable.EasySpinner_itemSelectedLayout, io.canner.easyspinner.R.layout.spinner_item_selected);
        CharSequence promptText = arr.getString(io.canner.easyspinner.R.styleable.EasySpinner_prompt);

        if (title != null) {
            this.title = title.toString();
        }

        if (promptText != null) {
            this.promptText = promptText.toString();
        } else {
            this.promptText = this.title;
        }

        if (entriesResId != 0) {
            this.entries = Arrays.asList(getResources().getStringArray(entriesResId));
        }

        arr.recycle();  // Do this when done.
        setupSpinnerAdapter();
        init();
    }

    private void setupSpinnerAdapter() {
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter(getContext(), this.itemSelectedLayout);
        spinnerArrayAdapter.setDropDownViewResource(this.itemLayout);
        spinnerArrayAdapter.addAll(entries);
        this.spinnerViewAdapter = new NothingSelectedSpinnerAdapter(spinnerArrayAdapter, nothingSelectedLayout, getContext());
    }

    // have to do init methods (initial views)
    abstract protected void init();
    abstract public void setTitle(String title);

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

    public ArrayAdapter getAdapter() {
        return spinnerViewAdapter.getAdapter();
    }

    public void clear() {
        getAdapter().clear();
    }

    public void add(String datum) {
        getAdapter().add(datum);
    }

    public void addAll(Collection data) {
        getAdapter().addAll(data);
    }

    public void resetData(String datum) {
        clear();
        add(datum);
    }

    public void resetData(Collection data) {
        clear();
        addAll(data);
    }

    public void setPrompt(String prompt) {
        spinnerView.setPrompt(prompt);
    }

    public void setEnabled(boolean enabled) {
        spinnerView.setEnabled(enabled);

        if (enabled) {
            spinnerView.setAlpha(1);
        } else {
            spinnerView.setAlpha(0.5f);
        }
    }
}
