package com.insa.pi.brainbeats;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.insa.pi.brainbeats.db.InMemoryDB;
import com.insa.pi.brainbeats.domain.Song;

public class NewSong extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_song);
    }

    public void addNewSong(View view) {
        EditText text = (EditText)findViewById(R.id.new_song);
        String name = text.getText().toString();
        Intent intent = getIntent();
        intent.putExtra("SONG", new Song("asdasd", name, null));
        setResult(RESULT_OK, intent);
        finish();
    }
}
