package eu.york.u3rsfr3.advance;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import eu.york.u3rsfr3.databinding.HolderAdvanceUiBinding;

public class AdvanceUiViewHolder extends RecyclerView.ViewHolder {

    private HolderAdvanceUiBinding binding;

    public AdvanceUiViewHolder(@NonNull HolderAdvanceUiBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(String data) {
        binding.advanceUiTxt.setText(data);
    }
}
