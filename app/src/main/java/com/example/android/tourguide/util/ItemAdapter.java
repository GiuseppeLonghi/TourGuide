/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.tourguide.util;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.tourguide.R;

import java.util.ArrayList;

/**
 * {@link ItemAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Item} objects.
 */
public class ItemAdapter extends ArrayAdapter<Item> {

    /**
     * Create a new {@link ItemAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param items is the list of {@link Item}s to be displayed.
     */
    public ItemAdapter(Context context, ArrayList<Item> items) {
        super(context, 0, items);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Item currentItem = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID name_item_text_view.
        TextView nameHotelTextView = listItemView.findViewById(R.id.name_item_text_view);

        if (currentItem != null) {
            // Get the Item name from the currentItem object and set this text on
            // the Name Item TextView.
            nameHotelTextView.setText(currentItem.getName());

            // Find the TextView in the list_item.xml layout with the ID address_item_text_view.
            TextView addressHotelTextView = listItemView.findViewById(R.id.address_item_text_view);

            // Get the address Item from the currentItem object and set this text on
            // the address Item TextView.
            addressHotelTextView.setText(currentItem.getAddress());

            // Find the ImageView in the list_item.xml layout with the ID image.
            ImageView imageHotel = listItemView.findViewById(R.id.image_hotel);

            // If an image is available, display the provided image based on the resource ID */
            imageHotel.setImageResource(currentItem.getImageResourceId());
        }
        return listItemView;
    }
}