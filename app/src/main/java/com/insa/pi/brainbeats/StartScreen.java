package com.insa.pi.brainbeats;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.PorterDuff;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;


import com.insa.pi.brainbeats.db.InMemoryDB;
import com.insa.pi.brainbeats.domain.Song;


public class StartScreen extends AppCompatActivity implements SongFragment.OnListFragmentInteractionListener {
    private InMemoryDB database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        database = new InMemoryDB();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_start_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onListFragmentInteraction(Song song) {

    }

    private void deployFragment(Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }

    public void startMaMusique(View view) {
        setSelected(R.id.ma_musique);
        setUnSelected(R.id.ecoute);
        setUnSelected(R.id.aprentissage);
        deployFragment(SongFragment.newInstance(database));
        Button addNewSong = new Button(this);
        addNewSong.setText("Ajoute nouveau chanson");
        addNewSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("JJJEEEEE");
            }
        });
        FrameLayout root = (FrameLayout)findViewById(R.id.button_area);
        root.addView(addNewSong);
    }

    public void startEcoute(View view) {
        setUnSelected(R.id.ma_musique);
        setSelected(R.id.ecoute);
        setUnSelected(R.id.aprentissage);
    }

    public void startAprentissage(View view) {
        setUnSelected(R.id.ma_musique);
        setUnSelected(R.id.ecoute);
        setSelected(R.id.aprentissage);
    }

    private void setSelected(int buttonid) {
        Button current = (Button)findViewById(buttonid);
        int color = ContextCompat.getColor(this, R.color.buttons);
        current.getBackground().setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
        current.invalidate();
    }

    private void setUnSelected(int buttonid) {
        Button current = (Button)findViewById(buttonid);
        current.getBackground().clearColorFilter();
        current.invalidate();
    }
}
