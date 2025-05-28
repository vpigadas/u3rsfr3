package eu.york.u3rsfr3.fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import eu.york.u3rsfr3.R;

public class CustomFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_fragment);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container_view, FirstFragment.newInstance("Vassilis", 100));
        transaction.replace(R.id.fragment_container_second_view, SecondFragment.newInstance());
        transaction.commit();
    }
}