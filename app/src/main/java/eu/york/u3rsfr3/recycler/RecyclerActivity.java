package eu.york.u3rsfr3.recycler;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import eu.york.u3rsfr3.R;

public class RecyclerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setAdapter(new CustomRecyclerViewAdapter(generateData()));
    }

    private List<String> generateData() {
        List<String> data = new ArrayList<String>();

        for (int i = 0; i < 10000; i++) {
            data.add("Item " + i);
        }

        return data;
    }
}