package eu.york.u3rsfr3.viewmodel;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import eu.york.u3rsfr3.R;

public class ViewModelActivity extends AppCompatActivity {

    private List<String> dataList = new ArrayList<>();
    private Executor executor = new ThreadPoolExecutor(
            1,
            5,
            5,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>());

    private MutableLiveData<List<CounterEntity>> liveData = new MutableLiveData<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_model);

        CounterDBINstance dbInstance = Room
                .databaseBuilder(this, CounterDBINstance.class, "CounterDB")
                .build();

        Button buttonGet = findViewById(R.id.viewmodel_btn_get);
        buttonGet.setEnabled(false);
        buttonGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView txt = findViewById(R.id.viewmodel_txt);
//                txt.setText(dataList.toString());

                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        List<CounterEntity> databaseList = dbInstance.getCounterDAO().read();
                        liveData.postValue(databaseList);
                    }
                });
            }
        });

        Button buttonSave = findViewById(R.id.viewmodel_btn_save);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int counter = dataList.size();
                dataList.add("Item " + counter);

                CounterEntity counterEntity = new CounterEntity();
                counterEntity.setName("Item " + counter);


                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        dbInstance.getCounterDAO().save(counterEntity);
                    }
                });
            }
        });

        liveData.observe(this, new Observer<List<CounterEntity>>() {
            @Override
            public void onChanged(List<CounterEntity> counterEntities) {
                TextView txt = findViewById(R.id.viewmodel_txt);
                txt.setText(counterEntities.toString());
            }
        });

        dbInstance.getCounterDAO().readAsync().observe(this, new Observer<List<CounterEntity>>() {
            @Override
            public void onChanged(List<CounterEntity> counterEntities) {
                TextView txt = findViewById(R.id.viewmodel_txt);
                txt.setText(counterEntities.toString());
            }
        });
    }
}