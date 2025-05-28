package eu.york.u3rsfr3.viewmodel;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;

import eu.york.u3rsfr3.R;

public class ViewModelActivity extends AppCompatActivity {
    private CustomViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_model);

        viewModel = new ViewModelProvider(this).get(CustomViewModel.class);
        viewModel.init(this);

        Button buttonGet = findViewById(R.id.viewmodel_btn_get);
        buttonGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.readData();
                TextView txt = findViewById(R.id.viewmodel_txt);
//                txt.setText(dataList.toString());
            }
        });

        Button buttonSave = findViewById(R.id.viewmodel_btn_save);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.saveData();
            }
        });

        viewModel.liveData.observe(this, new Observer<List<CounterEntity>>() {
            @Override
            public void onChanged(List<CounterEntity> counterEntities) {
                TextView txt = findViewById(R.id.viewmodel_txt);
                txt.setText(counterEntities.toString());
            }
        });
    }
}