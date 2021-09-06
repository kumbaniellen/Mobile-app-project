package com.example.eventplannerapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class SupItemAdapter extends RecyclerView.Adapter<SupItemAdapter.Item>{

    List<String> items;

    public SupItemAdapter(List<String> items) {
    }

    @NonNull
    @Override
    public Item onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.items, parent, false);
        return new Item(view).LinkAdapter(this);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onBindViewHolder(@NonNull Item holder, int position) {
        holder.textView.setText(items.get(position));
    }

    class Item extends RecyclerView.ViewHolder{
        TextView textView;
        private SupItemAdapter adapter;

        public Item(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.sup_recycleView);
            itemView.findViewById(R.id.sup_delete_btn).setOnClickListener(view ->{
                adapter.items.remove(getAdapterPosition());
                adapter.notifyItemRemoved(getAdapterPosition());
            });
        }
        public Item LinkAdapter(SupItemAdapter adapter){
            this.adapter = adapter;
            return this;
        }
    }
}
