package com.example.myapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {

    public NotesAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    private List<ListItem> listItems;
    private Context context;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListItem listItem = listItems.get(position);
        holder.editText.setText(listItem.getTask());
        holder.checkBox.setChecked(toBool(listItem.getStatus()));
        holder.noteContainer.setCardBackgroundColor(listItem.getColor());
        holder.linearLayout.setOnClickListener(v -> {
            PopupMenu p = new PopupMenu(context, holder.linearLayout);
            p.getMenuInflater().inflate(R.menu.popup, p.getMenu());
            p.setOnMenuItemClickListener(item -> {
                MyDialogFragment fragment = new MyDialogFragment();
                fragment.show(((AppCompatActivity)context).getSupportFragmentManager(),"Dialog Fragment");
                return true;
            });
            p.show();
        });
    }

    private boolean toBool(int n) {
        return n != 0;
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public CheckBox checkBox;
        public LinearLayout linearLayout;
        public EditText editText;
        public CardView noteContainer;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.cb1);
            linearLayout = itemView.findViewById(R.id.linear);
            editText = itemView.findViewById(R.id.et1);
            noteContainer = itemView.findViewById(R.id.card_note_container);
        }
    }
}
