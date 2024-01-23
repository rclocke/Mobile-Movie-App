package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MovieDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Intent intent = getIntent();
        String movieTitle = intent.getStringExtra("movieTitle");
        String movieYear = intent.getStringExtra("movieYear");
        String movieRated = intent.getStringExtra("movieRated");
        String movieGenre = intent.getStringExtra("movieGenre");
        String movieRuntime = intent.getStringExtra("movieRuntime");
        String movieID = intent.getStringExtra("movieImdbID");
        String movieRating = intent.getStringExtra("movieImdbRating");
        String moviePlot = intent.getStringExtra("moviePlot");

        String imageUrl = intent.getStringExtra("moviePoster");// Extracted URL
        ImageView poster = findViewById(R.id.poster);
        Picasso.get().load(imageUrl).into(poster);

        TextView movieTextView = findViewById(R.id.title);
        TextView yearTextView = findViewById(R.id.year);
        TextView ratedTextView = findViewById(R.id.rated);
        TextView genreTextView = findViewById(R.id.genre);
        TextView runTimeTextView = findViewById(R.id.runtime);
        TextView imdbIDTextView = findViewById(R.id.imdbID);
        TextView ratingTextView = findViewById(R.id.rating);
        TextView plotTextView = findViewById(R.id.plot);

        movieTextView.setText(movieTitle);
        yearTextView.setText(movieYear);
        ratedTextView.setText(movieRated);
        genreTextView.setText(movieGenre);
        runTimeTextView.setText(movieRuntime);
        imdbIDTextView.setText(movieID);
        ratingTextView.setText(movieRating);
        plotTextView.setText(moviePlot);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}