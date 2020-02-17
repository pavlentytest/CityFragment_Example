package ru.pavlenty.cityfragment_example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import ru.pavlenty.cityfragment_example.fragments.CityDetail;
import ru.pavlenty.cityfragment_example.fragments.MenuDetail;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MenuDetail.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("DEBUG", getResources().getConfiguration().orientation + "");

        if (savedInstanceState == null) {
            // Instance of first fragment
            MenuDetail firstFragment = new MenuDetail();

            // Add Fragment to FrameLayout (flContainer), using FragmentManager
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();// begin  FragmentTransaction
            ft.add(R.id.flContainer, firstFragment);                                // add    Fragment
            ft.commit();                                                            // commit FragmentTransaction
        }

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            CityDetail secondFragment = new CityDetail();
            Bundle args = new Bundle();
            args.putInt("position", 0);
            secondFragment.setArguments(args);          // (1) Communicate with Fragment using Bundle
            FragmentTransaction ft2 = getSupportFragmentManager().beginTransaction();// begin  FragmentTransaction
            ft2.add(R.id.flContainer2, secondFragment);                               // add    Fragment
            ft2.commit();                                                            // commit FragmentTransaction
        }
    }

    @Override
    public void onCityItemSelected(int position) {
        Toast.makeText(this, "Called By Fragment A: position - " + position, Toast.LENGTH_SHORT).show();

        // Load Pizza Detail Fragment
        CityDetail secondFragment = new CityDetail();

        Bundle args = new Bundle();
        args.putInt("position", position);
        secondFragment.setArguments(args);          // (1) Communicate with Fragment using Bundle


        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flContainer2, secondFragment) // replace flContainer
                    //.addToBackStack(null)
                    .commit();
        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flContainer, secondFragment) // replace flContainer
                    .addToBackStack(null)
                    .commit();
        }
    }
}