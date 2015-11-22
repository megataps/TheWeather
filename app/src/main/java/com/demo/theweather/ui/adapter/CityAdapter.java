package com.demo.theweather.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.demo.theweather.R;
import com.demo.theweather.model.City;

import java.util.List;

/**
 * Created by Jackie Nguyen <nguyenngoc100@gmail.com> on 11/18/15.
 */
public class CityAdapter extends BaseAdapter {

    private List<City> mCities;

    public void setCities(List<City> cities) {
        this.mCities = cities;
    }

    @Override
    public int getCount() {
        return mCities != null ? mCities.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return mCities.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {

        ViewHolder holder;

        if ((convertView == null) || (!(convertView.getTag() instanceof ViewHolder))) {

            holder = new ViewHolder();

            LayoutInflater inflater = (LayoutInflater) viewGroup.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_city, viewGroup, false);

            holder.mName = (TextView) convertView.findViewById(R.id.name_text_view);
            holder.mCheckBoxButton = (ImageButton) convertView.findViewById(R.id.checkbox_button);

            holder.mCheckBoxButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    City city = (City) v.getTag();
                    city.setSelected(!city.isSelected());
                    notifyDataSetChanged();
                }
            });

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        if (i < mCities.size()) {
            City city = mCities.get(i);

            holder.mName.setText(city.getName());
            holder.mCheckBoxButton.setTag(city);
            holder.mCheckBoxButton.setSelected(city.isSelected());
        }

        return convertView;
    }

    static class ViewHolder {
        TextView mName;
        ImageButton mCheckBoxButton;
    }
}
