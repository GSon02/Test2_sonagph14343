package com.example.test2_sonagph14343.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEventSource;
import android.widget.Button;

import com.example.test2_sonagph14343.Adapter.NotesAdapter;
import com.example.test2_sonagph14343.DataBase.NotesHelper;
import com.example.test2_sonagph14343.Model.Notes;
import com.example.test2_sonagph14343.R;

import java.util.List;

public class DanhSachFragment extends Fragment {
    private RecyclerView rcvDanhsach;
    private List<Notes> notesList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_danh_sach, container, false);
        
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rcvDanhsach= view.findViewById(R.id.rcvDanhsach);
        NotesHelper notesHelper = new NotesHelper(getContext());
        notesList = notesHelper.getAllNOTES();
        NotesAdapter sachAdapter = new NotesAdapter(notesList);

        rcvDanhsach.setAdapter(sachAdapter);
        rcvDanhsach.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(getContext());
        rcvDanhsach.setLayoutManager(linearLayoutManager);
    }
}