package com.insa.pi.brainbeats;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.insa.pi.brainbeats.db.InMemoryDB;
import com.insa.pi.brainbeats.domain.FileUtils;
import com.insa.pi.brainbeats.domain.Song;

public class NewSong extends AppCompatActivity {

    private static int FILE_SELECT_CODE = 321;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_song);
    }

    private void showFileChooser() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("audio/*");
        startActivityForResult(intent,FILE_SELECT_CODE);

    }
    public void addNewSong(View view) {
        showFileChooser();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == FILE_SELECT_CODE) {
            if (resultCode == RESULT_OK) {
                try {
                    Uri uri = data.getData();
                    Intent intent = getIntent();
                    String path = FileUtils.getPath(this, uri);
                    String[] files = path.split("/");
                    String name = files[files.length-1];
                    if (path == null) {
                        Toast.makeText(this, "Wrong filetype",Toast.LENGTH_LONG);
                    } else {
                        intent.putExtra("SONG", new Song("id", name, path));
                        setResult(RESULT_OK, intent);
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }
                finish();
            }
        }
    }
}
