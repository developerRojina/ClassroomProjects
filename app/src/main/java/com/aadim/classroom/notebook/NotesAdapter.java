package com.aadim.classroom.notebook;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aadim.classroom.R;

import java.util.ArrayList;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NoteViewHolder> {

    ArrayList<Note> notes;

    public NotesAdapter(ArrayList<Note> notes) {
        this.notes = notes;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        holder.bindView(notes.get(position));
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public void addNote(Note note) {
        notes.add(note);
        notifyItemInserted(notes.size());
    }

    class NoteViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvDescription, tvCategory;

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvDescription = itemView.findViewById(R.id.tv_description);
            tvCategory = itemView.findViewById(R.id.tv_category);
        }

        public void bindView(Note note) {

            tvTitle.setText(note.getTitle());
            tvDescription.setText(note.getDescription());
            tvCategory.setText(note.getCategory());
        }
    }
}
