package com.example.movieapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Movie> movies = new ArrayList<>(Arrays.asList(
            new Movie("The Avengers", "2012", "Earth's mightiest heroes must come together and learn to fight as a team if they are going to stop the mischievous Loki and his alien army from enslaving humanity.",
                              "PG-13", "tt0848228", "Action, Sci-Fi", "143 min", "8.0", "https://m.media-amazon.com/images/M/MV5BNDYxNjQyMjAtNTdiOS00NGYwLWFmNTAtNThmYjU5ZGI2YTI1XkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_SX300.jpg"),
            new Movie("Barbie", "2023", "Barbie suffers a crisis that leads her to question her world and her existence.",
                              "PG-13", "tt1517268", "Adventure, Comedy, Fantasy", "114 min", "7.1", "https://m.media-amazon.com/images/M/MV5BNjU3N2QxNzYtMjk1NC00MTc4LTk1NTQtMmUxNTljM2I0NDA5XkEyXkFqcGdeQXVyODE5NzE3OTE@._V1_SX300.jpg"),
            new Movie("Interstellar", "2014", "When Earth becomes uninhabitable in the future, a farmer and ex-NASA pilot, Joseph Cooper, is tasked to pilot a spacecraft, along with a team of researchers, to find a new planet for humans.",
                              "PG-13", "tt0816692", "Adventure, Drama, Sci-Fi", "169 min", "8.7", "https://m.media-amazon.com/images/M/MV5BZjdkOTU3MDktN2IxOS00OGEyLWFmMjktY2FiMmZkNWIyODZiXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_SX300.jpg"),
            new Movie("Ratatouille", "2007", "A rat who can cook makes an unusual alliance with a young kitchen worker at a famous Paris restaurant.",
                              "G", "tt0382932", "Animation, Adventure, Comedy", "111 min", "8.1", "https://m.media-amazon.com/images/M/MV5BMTMzODU0NTkxMF5BMl5BanBnXkFtZTcwMjQ4MzMzMw@@._V1_SX300.jpg"),
            new Movie("Superbad", "2007", "Two co-dependent high school seniors are forced to deal with separation anxiety after their plan to stage a booze-soaked party goes awry.",
                              "R", "tt0829482", "Comedy", "113 min", "7.6", "https://m.media-amazon.com/images/M/MV5BY2VkMDg4ZTYtN2M3Yy00NWZiLWE2ODEtZjU5MjZkYWNkNGIzXkEyXkFqcGdeQXVyODY5Njk4Njc@._V1_SX300.jpg"),
            new Movie("Pulp Fiction", "1994", "The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption.",
                              "R", "tt0110912", "Crime, Drama", "154 min", "8.9", "https://m.media-amazon.com/images/M/MV5BNGNhMDIzZTUtNTBlZi00MTRlLWFjM2ItYzViMjE3YzI5MjljXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SX300.jpg"),
            new Movie("The Lord of the Rings: The Fellowship of the Ring", "2001", "A meek Hobbit from the Shire and eight companions set out on a journey to destroy the powerful One Ring and save Middle-earth from the Dark Lord Sauron.",
                              "PG-13", "tt0120737", "Action, Adventure, Drama", "178 min", "8.8", "https://m.media-amazon.com/images/M/MV5BN2EyZjM3NzUtNWUzMi00MTgxLWI0NTctMzY4M2VlOTdjZWRiXkEyXkFqcGdeQXVyNDUzOTQ5MjY@._V1_SX300.jpg"),
            new Movie("The Godfather", "1972", "Don Vito Corleone, head of a mafia family, decides to hand over his empire to his youngest son Michael. However, his decision unintentionally puts the lives of his loved ones in grave danger.",
                              "R", "tt0068646", "Crime, Drama", "175 min", "9.2", "https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SX300.jpg"),
            new Movie("The Super Mario Bros. Movie", "2023", "A plumber named Mario travels through an underground labyrinth with his brother, Luigi, trying to save a captured princess.",
                              "PG", "tt6718170", "Animation, Adventure, Comedy", "92 min", "7.1", "https://m.media-amazon.com/images/M/MV5BOTJhNzlmNzctNTU5Yy00N2YwLThhMjQtZDM0YjEzN2Y0ZjNhXkEyXkFqcGdeQXVyMTEwMTQ4MzU5._V1_SX300.jpg"),
            new Movie("Parasite", "2019", "Greed and class discrimination threaten the newly formed symbiotic relationship between the wealthy Park family and the destitute Kim clan.",
                              "R", "tt6751668", "Drama, Thriller", "132 min", "8.5", "https://m.media-amazon.com/images/M/MV5BYWZjMjk3ZTItODQ2ZC00NTY5LWE0ZDYtZTI3MjcwN2Q5NTVkXkEyXkFqcGdeQXVyODk4OTc3MTY@._V1_SX300.jpg"),
            new Movie("Oppenheimer", "2023", "The story of American scientist, J. Robert Oppenheimer, and his role in the development of the atomic bomb.",
                              "R", "tt15398776", "Biography, Drama, History", "180 min", "8.5", "https://m.media-amazon.com/images/M/MV5BMDBmYTZjNjUtN2M1MS00MTQ2LTk2ODgtNzc2M2QyZGE5NTVjXkEyXkFqcGdeQXVyNzAwMjU2MTY@._V1_SX300.jpg"),
            new Movie("Sonic the Hedgehog", "2020", "After discovering a small, blue, fast hedgehog, a small-town police officer must help him defeat an evil genius who wants to do experiments on him.",
                              "PG", "tt3794354", "Action, Adventure, Comedy", "99 min", "6.5", "https://m.media-amazon.com/images/M/MV5BNTdmNmI4MzQtZTAzNS00MjhjLWEzOGQtZjI1NDNjZjk4N2JjXkEyXkFqcGdeQXVyMTM0NTUzNDIy._V1_SX300.jpg"),
            new Movie("The Wolf of Wall Street", "2013", "Based on the true story of Jordan Belfort, from his rise to a wealthy stock-broker living the high life to his fall involving crime, corruption and the federal government.",
                              "R", "tt0993846", "Biography, Comedy, Crime", "180 min", "8.2", "https://m.media-amazon.com/images/M/MV5BMjIxMjgxNTk0MF5BMl5BanBnXkFtZTgwNjIyOTg2MDE@._V1_SX300.jpg"),
            new Movie("The Dark Knight", "2008", "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.",
                              "PG-13", "tt0468569", "Action, Crime, Drama", "152 min", "9.0", "https://m.media-amazon.com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@._V1_SX300.jpg")));

    RecyclerView recyclerView;
    CustomAdapter adapter = new CustomAdapter(movies, new CustomAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(int position) {
        }
    });


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                Movie deletedMovie = movies.get(viewHolder.getAdapterPosition());

                int position = viewHolder.getAdapterPosition();
                movies.remove(viewHolder.getAdapterPosition());
                adapter.notifyItemRemoved(viewHolder.getAdapterPosition());

                Snackbar.make(recyclerView, "DELETED " + deletedMovie.getTitle(), Snackbar.LENGTH_LONG).setAction("Undo", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        movies.add(position, deletedMovie);
                        adapter.notifyItemInserted(position);
                    }
                }).show();
            }
        }).attachToRecyclerView(recyclerView);


        FloatingActionButton fab = findViewById(R.id.add_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAddMovieDialog();
            }
        });
    }

    private void showAddMovieDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Add a new movie");

        final EditText inputTitle = new EditText(this);
        inputTitle.setHint("Title");
        final EditText inputYear = new EditText(this);
        inputYear.setHint("Year");
        final EditText inputPlot = new EditText(this);
        inputPlot.setHint("Plot");
        final EditText inputRated = new EditText(this);
        inputRated.setHint("Rated");
        final EditText inputID = new EditText(this);
        inputID.setHint("ImdbID");
        final EditText inputGenre = new EditText(this);
        inputGenre.setHint("Genre");
        final EditText inputRuntime = new EditText(this);
        inputRuntime.setHint("Runtime");
        final EditText inputRating = new EditText(this);
        inputRating.setHint("Imdb Rating");
        final EditText inputPoster = new EditText(this);
        inputPoster.setHint("Poster");

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(20, 10, 20, 10);
        layout.addView(inputTitle);
        layout.addView(inputYear);
        layout.addView(inputRated);
        layout.addView(inputPlot);
        layout.addView(inputID);
        layout.addView(inputGenre);
        layout.addView(inputRuntime);
        layout.addView(inputRating);
        layout.addView(inputPoster);

        builder.setView(layout);

        builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String title = inputTitle.getText().toString().trim();
                String year = inputYear.getText().toString().trim();
                String rated = inputRated.getText().toString().trim();
                String plot = inputPlot.getText().toString().trim();
                String id = inputID.getText().toString().trim();
                String genre = inputGenre.getText().toString().trim();
                String runtime = inputRuntime.getText().toString().trim();
                String rating = inputRating.getText().toString().trim();
                String poster = inputPoster.getText().toString().trim();
                if (!title.isEmpty() && !year.isEmpty() && !rated.isEmpty() && !plot.isEmpty() && !id.isEmpty() && !genre.isEmpty() && !runtime.isEmpty() && !rating.isEmpty() && !poster.isEmpty()) {
                    Movie newMovie = new Movie(title, year, plot, rated, id, genre, runtime, rating, poster);
                    movies.add(newMovie);
                    adapter.notifyItemInserted(movies.size() - 1);
                    recyclerView.scrollToPosition(movies.size() - 1);
                }
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}