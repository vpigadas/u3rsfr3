package eu.york.u3rsfr3.recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import eu.york.u3rsfr3.R;

public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<BaseCustomView> {
    private List<String> items;

    public CustomRecyclerViewAdapter(@NonNull List<String> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public BaseCustomView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 1) {
            View viewS = LayoutInflater.from(parent.getContext()).inflate(R.layout.holder_item_second, parent, false);
            return new SecondCustomViewHolder(viewS);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.holder_item, parent, false);
            return new CustomViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull BaseCustomView holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position % 5 == 0 ? 0 : 1;
    }
}
