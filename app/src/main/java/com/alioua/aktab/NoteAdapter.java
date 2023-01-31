package com.alioua.aktab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NoteAdapter extends RecyclerView.Adapter<NoteViewHolder> {
    Context context;
   // ArrayList<NoteModel>data;
    ArrayList aktab_id,aktab_title,aktab_thenote,aktab_dates;

    NoteAdapter(Context context,
                ArrayList aktab_id,
                ArrayList aktab_dates,
                ArrayList aktab_title,
                ArrayList aktab_thenote){
        this.context = context;
        this.aktab_id = aktab_id;
        this.aktab_dates = aktab_dates;
        this.aktab_title = aktab_title;
        this.aktab_thenote = aktab_thenote;

    }

   /* public NoteAdapter(Context context, ArrayList<NoteModel> data){
        this.context = context;
        this.data = data;
    }*/

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_note,parent,false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        holder.aktab_title_txt.setText(String.valueOf(aktab_title.get(position)));
        holder.aktab_thenote_txt.setText(String.valueOf(aktab_thenote.get(position)));
        holder.aktab_dates_txt.setText(String.valueOf(aktab_dates.get(position)));
        /*holder.titleNote.setText(data.get(position).getTitleNote());
        holder.theNote.setText(data.get(position).getTheNote());*/

    }

    @Override
    public int getItemCount() {
        return aktab_id.size();
    }

}
