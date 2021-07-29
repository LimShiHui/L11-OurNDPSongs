package sg.edu.rp.c346.id20032316.l09_ndpsongs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    Context context;
    int id;
    ArrayList<Song> songList;


    public CustomAdapter(Context context, int resource, ArrayList<Song> object) {
        super(context, resource, object);

        this.context = context;
        this.id = resource;
        this.songList = object;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(id, parent, false);

        TextView tvTitle = rowView.findViewById(R.id.tvTitle);
        TextView tvYear = rowView.findViewById(R.id.tvYear);
//        TextView tvStar = rowView.findViewById(R.id.tvStar);
        RatingBar rbStar = rowView.findViewById(R.id.rbStar);
        TextView tvSinger = rowView.findViewById(R.id.tvSinger);
        ImageView ivNew = rowView.findViewById(R.id.ivNew);

        Song currentSong = songList.get(position);

        tvTitle.setText(currentSong.getTitle());
        String year = String.valueOf(currentSong.getYear());
        tvYear.setText(year);

        ivNew.setImageResource(R.drawable.new1);

        if (currentSong.getYear() < 2019) {
            ivNew.setVisibility(View.INVISIBLE);
        }

        float stars = currentSong.getStars();
        rbStar.setRating(stars);

//        if (stars == 1) {
////            tvStar.setText("*");
//        } else if (stars == 2) {
////            tvStar.setText("* *");
//        } else if (stars == 3) {
////            tvStar.setText("* * *");
//    } else if (stars == 4) {
////            tvStar.setText("* * * *");
//        } else if (stars == 5) {
////            tvStar.setText("* * * * *");
//        }

        tvSinger.setText(currentSong.getSingers());

        return rowView;
    }
}
