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
import java.util.Arrays;

public class UnionAdapter extends RecyclerView.Adapter<UnionAdapter.ViewHolder> {

    private ArrayList<String> unionList;
    private String[] buttonsText;
    private final int[] buttonIds = {R.id.button0, R.id.button1, R.id.button2, R.id.button3};

    public UnionAdapter(ArrayList<String> unionList, String[] buttonsText) {
        this.unionList = unionList;
        this.buttonsText = buttonsText;
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
        int count = 0;
        for (Button button : holder.buttonViews) {
            button.setBackgroundColor(Color.TRANSPARENT);
            button.setText(buttonsText[count]);
            count++;
        }

        // Apply the yellow background to the appropriate buttons
        for (int i = 0; i < unionArray.length; i++) {
            if (unionArray[i] >= 0 && unionArray[i] < buttonIds.length) {
                Button button = holder.buttonViews[unionArray[i]];
                button.setBackgroundColor(Color.YELLOW);
            }
        }
    }

    @Override
    public int getItemCount() {
        return unionList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Button[] buttonViews;
        public ViewHolder(View itemView) {
            super(itemView);
            buttonViews = new Button[buttonIds.length];
            for (int i = 0; i < buttonIds.length; i++) {
                buttonViews[i] = itemView.findViewById(buttonIds[i]);
            }
        }
    }
}