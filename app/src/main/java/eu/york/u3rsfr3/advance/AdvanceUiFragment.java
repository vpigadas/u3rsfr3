package eu.york.u3rsfr3.advance;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import eu.york.u3rsfr3.databinding.FragmentAdvanceUiBinding;

public class AdvanceUiFragment extends Fragment {

    private FragmentAdvanceUiBinding binding;

    public AdvanceUiFragment() {
        // Required empty public constructor
    }

    public static AdvanceUiFragment newInstance() {
        AdvanceUiFragment fragment = new AdvanceUiFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAdvanceUiBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.fragmentAdvanceUiRecyclerview.setAdapter(new AdvanceUIAdapter(getGenerateData()));
    }

    private List<String> getGenerateData() {
        List<String> dataList = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            dataList.add("Item at position:" + String.valueOf(i));
        }

        return dataList;
    }
}