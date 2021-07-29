package sg.edu.rp.c346.id20032316.l09_ndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Toast;

public class ModifySongs extends AppCompatActivity {

    EditText etID, etTitle, etSinger, etYear;
//    RadioGroup rgStar;
    RatingBar rbStar;
    Button btnUpdate, btnDelete, btnCancel;
    Song songs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_songs);

        etID = findViewById(R.id.etID);
        etTitle = findViewById(R.id.etSongTitle);
        etSinger = findViewById(R.id.etSinger);
        etYear = findViewById(R.id.etYear);
//        rgStar = findViewById(R.id.rgStar);
        rbStar = findViewById(R.id.rbStar);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        btnCancel = findViewById(R.id.btnCancel);

        Intent intent = getIntent();
        songs = (Song) intent.getSerializableExtra("song");

        etID.setText(songs.get_id() + ""); // to set need to be a String
        etID.setEnabled(false);
        etTitle.setText(songs.getTitle());
        etSinger.setText(songs.getSingers());
        etYear.setText(songs.getYear() + ""); // to set need to be a String

        rbStar.setRating(songs.getStars());

//        if (songs.getStars() == 1) {
//            rgStar.check(R.id.rb1);
//        } else if (songs.getStars() == 2) {
//            rgStar.check(R.id.rb2);
//        } else if (songs.getStars() == 3) {
//            rgStar.check(R.id.rb3);
//        } else if (songs.getStars() == 4) {
//            rgStar.check(R.id.rb4);
//        } else if (songs.getStars() == 5) {
//            rgStar.check(R.id.rb5);
//        }

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(ModifySongs.this);
                songs.setTitle(etTitle.getText().toString());
                songs.setSingers(etSinger.getText().toString());
                songs.setYear(Integer.parseInt(etYear.getText().toString()));

//                int rbSelected = rgStar.getCheckedRadioButtonId();
//                RadioButton rb = findViewById(rbSelected);
                float numStar = rbStar.getRating();
//                songs.setStars(Integer.parseInt(rb.getText().toString()));
                songs.setStars(numStar);
                dbh.updateSong(songs);
                finish();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(ModifySongs.this);
                dbh.deleteSong(songs.get_id());
                finish();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}