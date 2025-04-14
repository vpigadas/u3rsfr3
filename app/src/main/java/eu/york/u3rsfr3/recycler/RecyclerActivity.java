package eu.york.u3rsfr3.recycler;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import eu.york.u3rsfr3.R;

public class RecyclerActivity extends AppCompatActivity {

    private CustomListAdapter adapter;
    private int retries = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        adapter = new CustomListAdapter();

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setAdapter(adapter);
//        recyclerView.setAdapter(new CustomRecyclerViewAdapter(generateData()));

        Button button = findViewById(R.id.recycler_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.submitList(generateData(++retries));
            }
        });
    }

    private List<String> generateData(int retries) {
        List<String> data = new ArrayList<String>();

        for (int i = 0; i < (10 * retries); i++) {
            data.add("Item " + i);
        }

        return data;
    }
}