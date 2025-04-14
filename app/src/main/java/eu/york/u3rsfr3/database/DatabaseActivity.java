package eu.york.u3rsfr3.database;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import eu.york.u3rsfr3.R;

public class DatabaseActivity extends AppCompatActivity {

    private Executor executor = new ThreadPoolExecutor(1, 1, 5, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        CustomInstance instance = Room.
                databaseBuilder(this, CustomInstance.class, "MyDatabase")
                //.allowMainThreadQueries()
                .build();

        executor.execute(new Runnable() {
            @Override
            public void run() {
                List<UserEntity> array = instance.getUserDAO().read();
                if (array.isEmpty()) {

                }
            }
        });
    }
}