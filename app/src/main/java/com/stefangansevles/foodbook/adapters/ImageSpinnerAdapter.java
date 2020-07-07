package com.stefangansevles.foodbook.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.stefangansevles.foodbook.model.SpinnerImage;
import com.stefangansevles.foodbook.R;

import java.util.List;

/**
 * Created by Stefan Gansevles on 7-7-2020
 */

public class ImageSpinnerAdapter extends ArrayAdapter<SpinnerImage>
{
    ImageView img;
    TextView lbl;
    SpinnerImage record;
    LinearLayout layout;
    private int mCustomText = -1;

    public ImageSpinnerAdapter(@NonNull Context context, int resource, @NonNull List<SpinnerImage> objects)
    {
        super(context, resource, objects);
    }

    @Nullable
    @Override
    public SpinnerImage getItem(int position)
    {
        return super.getItem(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.spinner_image_record, parent, false);



        lbl = convertView.findViewById(R.id.spinnerText);
        img = convertView.findViewById(R.id.spinnerImage);

        record = getItem(position);
        lbl.setText(record.getText());

        if(mCustomText != -1)
            lbl.setText(mCustomText);

        img.setImageResource(record.getImg());

        return convertView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.spinner_image_record, parent, false);


        img = convertView.findViewById(R.id.spinnerImage);
        lbl = convertView.findViewById(R.id.spinnerText);
        layout = convertView.findViewById(R.id.spinnerImageLayout);
        layout.setPadding(0,0,0,0); //Reset the padding to 0
        record = getItem(position);

        //Once the user selected something, set the default text "(none)" to -1 so it won't be set.
        mCustomText = -1;

        lbl.setText(record.getText());
        lbl.setSingleLine(false);
        img.setImageResource(record.getImg());

        return convertView;
    }

    public void setCustomText(int customText) {
        // Call to set the text that must be shown in the spinner for the custom option.
        mCustomText = customText;
        notifyDataSetChanged();
    }
}
