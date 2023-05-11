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
    private String kMap;
    private int[] buttonIds;

    public UnionAdapter(ArrayList<String> unionList, String[] buttonsText, String kMap) {
        this.unionList = unionList;
        this.buttonsText = buttonsText;
        this.kMap = kMap;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            if(kMap.equals("2")){
                Log.v("HERE", kMap);
                buttonIds = new int[]{R.id.button0, R.id.button1, R.id.button2, R.id.button3};
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kmap2_item, parent, false);
                return new ViewHolder(view);
            }else if(kMap.equals("3")){
                buttonIds = new int[]{R.id.button0, R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6, R.id.button7};
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kmap3_item, parent, false);
                return new ViewHolder(view);
            }else if(kMap.equals("4")){
                buttonIds = new int[]{R.id.button0, R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6, R.id.button7,
                        R.id.button8, R.id.button9, R.id.button10, R.id.button11, R.id.button12, R.id.button13, R.id.button14, R.id.button15};
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kmap4_item, parent, false);
                return new ViewHolder(view);
            } else {
                throw new IllegalArgumentException("Invalid kMap value: " + kMap);
            }
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