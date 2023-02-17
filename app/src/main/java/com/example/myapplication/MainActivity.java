package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Random random;
    private List<Note> notes;
    private LinearLayoutCompat linearLayoutCompat;
    private LayoutInflater layoutInflater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayoutCompat=findViewById(R.id.LinearLayout);
        layoutInflater=getLayoutInflater();
        random=new Random();
        notes=new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            notes.add(new Note(random.nextInt(3),"Simple text"));
        }
        for (int i = 0; i < notes.size(); i++) {
            TextView note=(TextView) layoutInflater.inflate(R.layout.note,null);
            linearLayoutCompat.addView(note);
            note.setText(notes.get(i).text);
            switch (notes.get(i).priority) {
                case 0:
                    note.setBackgroundColor(getResources().getColor(R.color.green));
                    break;
                case 1:
                    note.setBackgroundColor(getResources().getColor(R.color.yellow));
                    break;
                case 2:
                    note.setBackgroundColor(getResources().getColor(R.color.red));
                    break;
            }
        }
    }
}