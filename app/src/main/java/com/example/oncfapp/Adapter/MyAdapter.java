package com.example.oncfapp.Adapter;


import android.animation.ObjectAnimator;
import android.content.ClipData;
import android.content.Context;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.oncfapp.model.item;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.oncfapp.R;
import com.github.aakira.expandablelayout.ExpandableLayout;
import com.github.aakira.expandablelayout.ExpandableLayoutListener;
import com.github.aakira.expandablelayout.ExpandableLayoutListenerAdapter;
import com.github.aakira.expandablelayout.ExpandableLinearLayout;
import com.github.aakira.expandablelayout.Utils;

import java.util.List;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.regex.MatchResult;



class MyViewHolderWithDetails extends RecyclerView.ViewHolder {

    public TextView textView1, textView2 , textViewChild1, textViewChild2, textViewChild3  ;
    public RelativeLayout button ;
    public ExpandableLinearLayout expandableLayout;

    public MyViewHolderWithDetails(View itemView){
        super (itemView);
        textView1 = (TextView) itemView.findViewById(R.id.textView1);
        textView2 = (TextView) itemView.findViewById(R.id.textView2);
        textViewChild1 = (TextView) itemView.findViewById(R.id.textViewDetails1);
        textViewChild2 = (TextView) itemView.findViewById(R.id.textViewDetails2);
        textViewChild3 = (TextView) itemView.findViewById(R.id.textViewDetails3);
        button = (RelativeLayout) itemView.findViewById(R.id.Button);
        expandableLayout = (ExpandableLinearLayout)itemView.findViewById(R.id.expandableLayout);

    }}
public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<item> items ;
    Context context ;
    SparseBooleanArray expandState = new SparseBooleanArray() ;


    public MyAdapter(List<item> items) {
        this.items = items;
        for (int i=0 ; i<items.size(); i++)
            expandState.append(i,false);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.context = parent.getContext() ;
        LayoutInflater Inflater = LayoutInflater.from(context);
        View view = Inflater.inflate(R.layout.layout_with_details,parent,false);
        return new MyViewHolderWithDetails(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        final MyViewHolderWithDetails  viewHolder = (MyViewHolderWithDetails) holder ;
        item item = items.get(position);
        int itemPosition = holder.getAdapterPosition();
        viewHolder.setIsRecyclable(false);
        viewHolder.textView1.setText(item.getDetails());
        viewHolder.textView2.setText(item.getDate());
        viewHolder.expandableLayout.setInRecyclerView(true);
        viewHolder.expandableLayout.setExpanded(expandState.get(position));
        viewHolder.expandableLayout.setListener(new ExpandableLayoutListenerAdapter() {

            public void onPreOpen() {
                changeRotate(viewHolder.button,0f,180f).start();
                expandState.put(position,true);
            }

            @Override
            public void onPreClose() {
                changeRotate(viewHolder.button,180f,0f).start();
                expandState.put(position,false);
            }


        });

        viewHolder.button.setRotation(expandState.get(position)?180f:0f);
        viewHolder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewHolder.expandableLayout.toggle();
            }
        });
        viewHolder.textViewChild1.setText(items.get(position).getVoiture());
        viewHolder.textViewChild2.setText(items.get(position).getEquipement());
        viewHolder.textViewChild3.setText(items.get(position).getCode());

        // remove item if State is null

        /* String Code = items.get(position).getCode();
        if (Code.equals("MAMA")){
            removeItem(holder.getAdapterPosition());
            notifyDataSetChanged();
        } */
    }







    private ObjectAnimator changeRotate(RelativeLayout button, float to , float from) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(button,"rotation",from,to);
        animator.setDuration(300);
        animator.setInterpolator(Utils.createInterpolator(Utils.LINEAR_INTERPOLATOR));
        return animator;
    }




    @Override



    public int getItemCount() {
        return items.size();
    }
    public void removeItem ( int position){
        items.remove(position);
        notifyItemRemoved(position);

    }




}
