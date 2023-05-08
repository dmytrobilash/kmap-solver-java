package com.hfad.karnaughmap_java.views.unions;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hfad.karnaughmap_java.R;

import java.util.ArrayList;

public class UnionAdapter extends RecyclerView.Adapter<UnionAdapter.ViewHolder> {

    private ArrayList<String> unionList;

    public UnionAdapter(ArrayList<String> unionList) {
        this.unionList = unionList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kmap2_item, parent, false);

        // Create and return a new ViewHolder
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String union = unionList.get(position);

        //holder.textView.setText(union);
    }

    @Override
    public int getItemCount() {
        return unionList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);

            // Initialize the views from the kmap_item.xml layout
            textView = itemView.findViewById(R.id.textView);
        }
    }
}