package eu.york.u3rsfr3.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import eu.york.u3rsfr3.R;

public class FirstFragment extends Fragment {

    private FragmentViewModel viewModel;

    public FirstFragment() {
        // Required empty public constructor
    }

    public static FirstFragment newInstance(String name, int age) {
        FirstFragment fragment = new FirstFragment();
        Bundle parameters = new Bundle();
        parameters.putString("name", name);
        parameters.putInt("age", age);
        fragment.setArguments(parameters);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(getActivity()).get(FragmentViewModel.class);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        if (getArguments() != null) {
//            String name = getArguments().getString("name");
//            int age = getArguments().getInt("age");
//
//            TextView textView = view.findViewById(R.id.fragment_first_txt);
//            textView.setText(name + " " + age);
//        }

        viewModel.counter.observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                TextView textView = view.findViewById(R.id.fragment_first_txt);
                textView.setText(String.valueOf(integer));
            }
        });

        if (getArguments() == null) {
            return;
        }

//        String name = getArguments().getString("name");
//        int age = getArguments().getInt("age");
//
//        TextView textView = view.findViewById(R.id.fragment_first_txt);
//        textView.setText(name + " " + age);

    }

    @Override
    public void onResume() {
        super.onResume();
    }


    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}