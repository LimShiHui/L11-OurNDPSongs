package sg.edu.rp.c346.id20032316.l09_ndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etTitle, etSinger, etYear;
//    RadioGroup rgStar;
    RatingBar rbStar;
    Button btnInsert, btnShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTitle = findViewById(R.id.etSongTitle);
        etSinger = findViewById(R.id.etSongSinger);
        etYear = findViewById(R.id.etYear);
//        rgStar = findViewById(R.id.rgStar);
        rbStar = findViewById(R.id.rbStar);
        btnInsert = findViewById(R.id.btnAdd);
        btnShow = findViewById(R.id.btnShowList);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = etTitle.getText().toString();
                String singer = etSinger.getText().toString();
                int year = Integer.parseInt(etYear.getText().toString());
//                int stars = 0;
//                if (rgStar.getCheckedRadioButtonId() == R.id.rb1) {
//                    stars = 1;
//                } else if (rgStar.getCheckedRadioButtonId() == R.id.rb2) {
//                    stars = 2;
//                } else if (rgStar.getCheckedRadioButtonId() == R.id.rb3) {
//                    stars = 3;
//                }else if (rgStar.getCheckedRadioButtonId() == R.id.rb4) {
//                    stars = 4;
//                }else if (rgStar.getCheckedRadioButtonId() == R.id.rb5) {
//                    stars = 5;
//                }

                float stars = rbStar.getRating();

                DBHelper dbh = new DBHelper(MainActivity.this);
                long inserted_id = dbh.insertSong(title, singer,year, stars);

                if (inserted_id != -1){
                    Toast.makeText(MainActivity.this, "Insert successful",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowSongActivity.class);
                startActivity(intent);
            }
        });

    }
}