package com.insa.pi.brainbeats;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.insa.pi.brainbeats.db.InMemoryDB;
import com.insa.pi.brainbeats.domain.Song;

public class NewSong extends AppCompatActivity {

    private static final String ARG_DATABASE = "DB";
    private InMemoryDB database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_song);

        Intent intent = getIntent();
        database = (InMemoryDB) intent.getExtras().get(ARG_DATABASE);
        System.out.println(database);
    }

    public void addNewSong(View view) {
        EditText text = (EditText)findViewById(R.id.new_song);
        String name = text.getText().toString();
        database.addSong(new Song("asdasd", name, null));
        finish();
    }
}
