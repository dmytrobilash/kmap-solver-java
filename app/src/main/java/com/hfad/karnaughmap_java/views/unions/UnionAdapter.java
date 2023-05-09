package com.hfad.karnaughmap_java.views.unions;

import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hfad.karnaughmap_java.R;

import java.util.ArrayList;

public class UnionAdapter extends RecyclerView.Adapter<UnionAdapter.ViewHolder> {

    private ArrayList<String> unionList;
    private final int[] buttonIds = {R.id.button0, R.id.button1, R.id.button2, R.id.button3};

    public UnionAdapter(ArrayList<String> unionList) {
        this.unionList = unionList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kmap2_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String union = unionList.get(position);
        String[] numberTokens = union.replaceAll("[\\[\\]]", "").split("[,\\s]+");

        int[] unionArray = new int[numberTokens.length];
        for (int i = 0; i < numberTokens.length; i++) {
            unionArray[i] = Integer.parseInt(numberTokens[i]);
        }

        for (int i = 0; i < unionArray.length; i++) {
            if (unionArray[i] >= 0 && unionArray[i] < buttonIds.length) {
                Button button = holder.buttonViews[i];
                button.setBackgroundColor(Color.YELLOW);
            }
        }
    }

    @Override
    public int getItemCount() {
        return unionList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv = itemView.findViewById(R.id.textView0);
        Button[] buttonViews;
        public ViewHolder(View itemView) {
            super(itemView);
            Log.v("Tag", String.valueOf(tv.getForeground()));
            buttonViews = new Button[buttonIds.length];
            for (int i = 0; i < buttonIds.length; i++) {
                buttonViews[i] = itemView.findViewById(buttonIds[i]);
            }
        }
    }
}