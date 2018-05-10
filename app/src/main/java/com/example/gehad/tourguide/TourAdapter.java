/*
 * PROJECT LICENSE
 *
 * This project was submitted by Gehad Ahmed as part of the Nanodegree At Udacity.
 *
 * As part of Udacity Honor code, your submissions must be your own work, hence
 * submitting this project as yours will cause you to break the Udacity Honor Code and the suspension of your account.
 *
 * Me, the author of the project, allow you to check the code as a reference, but if you submit it, it's your own responsibility if you get expelled.
 *
 * Copyright (c) 2018 Gehad Ahmed
 *
 * Besides the above notice, the following license applies and this license notice must be included in all works derived from this project.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.example.gehad.tourguide;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class TourAdapter extends ArrayAdapter<Tour> {

    /**
     * Resource ID for the background color for this list of words
     */
    private int mColorResourceId;

    TourAdapter(Activity context, ArrayList<Tour> allTours, int colorResourceId) {
        super(context, 0, allTours);
        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Tour currentTour = getItem(position);

        //Find the ImageView in the list_item.xml layout with the ID itemImage
        ImageView tourImageView = listItemView.findViewById(R.id.itemImage);

        //Get the image resource ID from the current Tour object and set the image to tourImageView
        tourImageView.setImageResource(currentTour.getImageResourceId());

        //Find the TextView in the list_item.xml layout with the ID itemTitle
        TextView titleTextView = listItemView.findViewById(R.id.itemTitle);

        //Get the tour title from the current Tour object and set this text to titleTextView
        titleTextView.setText(currentTour.getTourTitle());

        //Find the TextView in the list_item.xml layout with the ID itemDescription
        TextView descrpTextView = listItemView.findViewById(R.id.itemDescription);

        //Get the tour description from the current Tour object and set this text to descrpTextView
        descrpTextView.setText(currentTour.getTourDescription());

        //Find the TextView in the list_item.xml layout with the ID address
        TextView addressTextView = listItemView.findViewById(R.id.address);

        //Get the tour address from the current Tour object and set this text to addressTextView
        addressTextView.setText(currentTour.getTourLocation());

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.horzListItem);

        // Find the color that the resource ID maps to it
        int color = ContextCompat.getColor(getContext(), mColorResourceId);

        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout, so that it can be shown in the ListView.
        return listItemView;
    }
}
