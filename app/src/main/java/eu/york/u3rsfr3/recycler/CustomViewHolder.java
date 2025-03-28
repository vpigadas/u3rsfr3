package eu.york.u3rsfr3.recycler;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import eu.york.u3rsfr3.R;

public class CustomViewHolder extends BaseCustomView {
    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    @Override
    public void bind(String data) {
        TextView textView = itemView.findViewById(R.id.holder_txt);
        textView.setText(data);
    }
}
