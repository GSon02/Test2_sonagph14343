package com.example.test2_sonagph14343.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test2_sonagph14343.DataBase.NotesHelper;
import com.example.test2_sonagph14343.Model.Notes;
import com.example.test2_sonagph14343.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesHolder> {
    private List<Notes> notesList;
    private TextView textView;
    private TextInputLayout tilContent;
    private TextView textView3;
    private TextInputLayout tilDate;
    private Button btnAdd;
    private NotesHelper notesHelper;
    private NotesHolder notesHolder;
    private NotesAdapter notesAdapter;

    public NotesAdapter(List<Notes> notesList){
        this.notesList = notesList;
    }

    @NonNull
    @Override
    public NotesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);

        return new NotesHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull NotesHolder holder, int position) {
        final Notes notes = notesList.get(position);
        holder.tvRow.setText(notes.toString());
        holder.imgClose.setClickable(true);
        holder.imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notesHelper = new NotesHelper(view.getContext());
                notesHelper.deleteNOTES(notes);
                notesList.remove(holder.getAdapterPosition());
                notifyItemRemoved(holder.getAdapterPosition());
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class NotesHolder extends RecyclerView.ViewHolder {
        private TextView tvRow;
        private ImageView imgClose;
        public NotesHolder(@NonNull View itemView) {
            super(itemView);
            tvRow = (TextView) itemView.findViewById(R.id.tvRow);
            imgClose = (ImageView) itemView.findViewById(R.id.imgClose);
        }
    }
}
