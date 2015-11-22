package com.demo.theweather.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.demo.theweather.R;
import com.demo.theweather.model.Weather;
import com.demo.theweather.util.DateUtils;
import com.demo.theweather.util.LogUtils;
import com.demo.theweather.util.TemperatureUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by Jackie Nguyen <nguyenngoc100@gmail.com> on 11/18/15.
 */
public class WeatherOfDateAdapter extends BaseAdapter {

    private List<Weather> mWeathers;

    public void setWeathers(List<Weather> weathers) {
        this.mWeathers = weathers;
    }

    @Override
    public int getCount() {
        return mWeathers != null ? mWeathers.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return mWeathers.get(i);
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
            convertView = inflater.inflate(R.layout.item_weather_of_date, viewGroup, false);

            holder.mDate = (TextView) convertView.findViewById(R.id.txtDate);
            holder.mMaxMinTemperature = (TextView) convertView.findViewById(R.id.txtMaxMinTemperature);


            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        if (i < mWeathers.size()) {
            Weather weather = mWeathers.get(i);

            try {
                Date date = DateUtils.convertDateFromString(weather.getDate(), "yyyy-MM-dd");

                holder.mDate.setText(new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date));

            } catch (ParseException ex) {
                LogUtils.printStackTrace(ex);
            }

            String maxMin = String.format("%sC/%sC", TemperatureUtils.format(weather.getTempMaxC()),
                    TemperatureUtils.format(weather.getTempMinC()));
            holder.mMaxMinTemperature.setText(maxMin);

        }

        return convertView;
    }

    static class ViewHolder {
        TextView mDate;
        TextView mMaxMinTemperature;
    }
}
