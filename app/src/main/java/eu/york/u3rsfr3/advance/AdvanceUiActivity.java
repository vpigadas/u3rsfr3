package eu.york.u3rsfr3.advance;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import eu.york.u3rsfr3.databinding.ActivityAdvanceUiBinding;

public class AdvanceUiActivity extends AppCompatActivity {

    private ActivityAdvanceUiBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAdvanceUiBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(binding.advanceUiFragmentContainer.getId(), new AdvanceUiFragment());
        transaction.commit();
    }
}