package eu.york.u3rsfr3.viewmodel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CustomViewModel extends ViewModel {

    private List<String> dataList = new ArrayList<>();

    private Executor executor = new ThreadPoolExecutor(
            1,
            5,
            5,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>());

    private MutableLiveData<List<CounterEntity>> _liveData = new MutableLiveData<>();
    public LiveData<List<CounterEntity>>  liveData= _liveData;

    private CounterDBINstance dbInstance;

    public void init(Context context){
        dbInstance = Room
                .databaseBuilder(context, CounterDBINstance.class, "CounterDB")
                .build();
    }

    public void saveData(){
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

    public void readData(){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                List<CounterEntity> databaseList = dbInstance.getCounterDAO().read();
                _liveData.postValue(databaseList);
            }
        });
    }
}
