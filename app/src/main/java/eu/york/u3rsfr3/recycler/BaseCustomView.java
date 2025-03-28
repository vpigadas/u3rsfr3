package eu.york.u3rsfr3.recycler;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import eu.york.u3rsfr3.R;

public abstract class BaseCustomView extends RecyclerView.ViewHolder {
    public BaseCustomView(@NonNull View itemView) {
        super(itemView);
    }

    public abstract void bind(String data);
}
