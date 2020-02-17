package ru.pavlenty.cityfragment_example.fragments;


import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import ru.pavlenty.cityfragment_example.R;
import ru.pavlenty.cityfragment_example.data.City;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class CityDetail extends Fragment {
    int position = 0;
    TextView tvTitle;
    TextView tvDetails;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(savedInstanceState == null){
            if(getArguments() != null) {
                position = getArguments().getInt("position", 0);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup parent, @Nullable Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_city_detail, parent, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        tvTitle =  view.findViewById(R.id.tvTitle);
        tvDetails = view.findViewById(R.id.tvDetails);


        tvTitle.setText(City.cityMenu[position]);
        tvDetails.setText(City.cityDetails[position]);
    }


    public void updateView(int position){
        tvTitle.setText(City.cityMenu[position]);
        tvDetails.setText(City.cityDetails[position]);
    }
}
