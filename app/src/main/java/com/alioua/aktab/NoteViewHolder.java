package com.alioua.aktab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class NoteViewHolder  extends RecyclerView.ViewHolder {
    TextView aktab_dates_txt, aktab_title_txt, aktab_thenote_txt;
    public NoteViewHolder(@NonNull View itemView) {
        super(itemView);
        aktab_dates_txt = itemView.findViewById(R.id.aktebb_dates);
        aktab_title_txt=itemView.findViewById(R.id.title_note);
        aktab_thenote_txt=itemView.findViewById(R.id.the_note);

    }
}
