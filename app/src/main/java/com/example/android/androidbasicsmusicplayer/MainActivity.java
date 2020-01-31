package com.example.android.androidbasicsmusicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> listOfGenre = new ArrayList(Arrays.asList("Pop", "Blues", "Rock",
            "Salsa", "Bachata", "Techno", "Jazz", "Swing", "Classic", "Ska",
            "RocknRoll", "Electronic"));


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SongGenerator songGenerator = new SongGenerator();



        final GridView gridView = findViewById(R.id.categoryGridView);

        GenreAdapter adapter = new GenreAdapter(this, listOfGenre);
        gridView.setAdapter(adapter);


//        gridView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                switch(v.getId()) {
//                    case(1):
//                        Intent intent = new Intent(MainActivity.this, PopActivity.class);
//                        startActivity(intent);
//
//                        Toast.makeText(gridView.getContext(), "ID = 1", Toast.LENGTH_LONG).show();
//                }
//            }
//        });

    }
}
