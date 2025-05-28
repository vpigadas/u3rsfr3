package eu.york.u3rsfr3.advance;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import eu.york.u3rsfr3.databinding.HolderAdvanceUiBinding;

public class AdvanceUIAdapter extends RecyclerView.Adapter<AdvanceUiViewHolder> {

    private List<String> dataList;

    public AdvanceUIAdapter(List<String> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public AdvanceUiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        HolderAdvanceUiBinding binding = HolderAdvanceUiBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new AdvanceUiViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull AdvanceUiViewHolder holder, int position) {
        holder.bind(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
