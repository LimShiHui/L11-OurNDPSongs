package sg.edu.rp.c346.id20032316.l09_ndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class ShowSongActivity extends AppCompatActivity {

    Button btn5Stars;
    ListView lv;
    ArrayList<Song> al;
    CustomAdapter ca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_song);

        btn5Stars = findViewById(R.id.btnStars);
        lv = findViewById(R.id.lv);

        al = new ArrayList<Song>();
        ca = new CustomAdapter(ShowSongActivity.this, R.layout.row, al);
        lv.setAdapter(ca);

        btn5Stars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(ShowSongActivity.this);
                al.clear();
                al.addAll(dbh.getAllSongsByStar(5));
                ca.notifyDataSetChanged();
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Song song = al.get(position);
                Intent intent = new Intent(ShowSongActivity.this, ModifySongs.class);
                intent.putExtra("song", song);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        DBHelper dbh = new DBHelper(ShowSongActivity.this);
        al.clear();
        al.addAll(dbh.getAllSongs());
        ca.notifyDataSetChanged();
    }


}