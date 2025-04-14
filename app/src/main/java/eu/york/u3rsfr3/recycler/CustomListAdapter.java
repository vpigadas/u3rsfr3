package eu.york.u3rsfr3.recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;

import eu.york.u3rsfr3.R;

public class CustomListAdapter extends ListAdapter<String, BaseCustomView> {

    public CustomListAdapter() {
        super(new CustomDiffUtils());
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
        holder.bind(getItem(position));
    }

    @Override
    public int getItemViewType(int position) {
        return position % 5 == 0 ? 0 : 1;
    }
}
