package com.example.test2_sonagph14343.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.test2_sonagph14343.DataBase.NotesHelper;
import com.example.test2_sonagph14343.Model.Notes;
import com.example.test2_sonagph14343.R;
import com.google.android.material.textfield.TextInputLayout;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ThemGhiChuFragment extends Fragment {

    private TextView textView;
    private TextInputLayout tilContent;
    private TextView textView3;
    private TextInputLayout tilDate;
    private Button btnAdd;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_them_ghi_chu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView = (TextView) view.findViewById(R.id.textView);
        tilContent = (TextInputLayout) view.findViewById(R.id.tilContent);
        textView3 = (TextView) view.findViewById(R.id.textView3);
        tilDate = (TextInputLayout) view.findViewById(R.id.tilDate);
        btnAdd = (Button) view.findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Content = tilContent.getEditText().getText().toString();
                String Date = tilDate.getEditText().getText().toString();
                if(Content.trim().isEmpty()){
                    tilContent.setError("Bạn Chưa Nhập Nội Dung");
                    return;
                }else{
                    tilContent.setError(null);
                }
                if(Date.trim().isEmpty()){
                    tilDate.setError("Bạn Chưa Nhập Thời Gian");
                    return;
                }else{
                    tilDate.setError(null);
                }
                Notes notes = new Notes(Content,Date);
                NotesHelper notesHelper = new NotesHelper(getContext());
                long check = notesHelper.insertNOTES(notes);
                if(check < 0){
                    Toast.makeText(getContext(), "Lỗi Thêm !!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getContext(), "Thêm Thành Công !!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}