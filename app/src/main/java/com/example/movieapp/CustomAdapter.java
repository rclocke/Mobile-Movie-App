package com.example.movieapp;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private ArrayList<Movie> localDataSet;
    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public CustomAdapter(ArrayList<Movie> dataSet, OnItemClickListener listener) {
        localDataSet = dataSet;
        onItemClickListener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView title;
        private final TextView year;
        private ImageView poster;

        public ViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            year = (TextView) view.findViewById(R.id.year);
            poster = (ImageView) view.findViewById(R.id.poster);
        }

        public TextView getTitleTextView() {
            return title;
        }
        public TextView getDescriptionTextView() {
            return year;
        }
        public ImageView getPosterTextView() {
            return poster;
        }
    }

    public CustomAdapter(ArrayList<Movie> dataSet) {
        localDataSet = dataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_item, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        Movie currentMovie = localDataSet.get(position);
        viewHolder.title.setText(currentMovie.getTitle());
        viewHolder.year.setText(currentMovie.getYear());

        String imageUrl = currentMovie.getPoster();
        Picasso.get().load(imageUrl).into(viewHolder.poster);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClickListener != null) {
                    int adapterPosition = viewHolder.getAdapterPosition();
                    System.out.println(localDataSet.get(adapterPosition).getTitle());
                    Movie selectedMovie = localDataSet.get(adapterPosition);
                    onItemClickListener.onItemClick(adapterPosition);

                    Intent intent = new Intent(view.getContext(), MovieDetailActivity.class);

                    intent.putExtra("movieTitle", selectedMovie.getTitle());
                    intent.putExtra("movieYear", selectedMovie.getYear());
                    intent.putExtra("moviePoster", selectedMovie.getPoster());
                    intent.putExtra("movieRated", selectedMovie.getRated());
                    intent.putExtra("movieGenre", selectedMovie.getGenre());
                    intent.putExtra("movieRuntime", selectedMovie.getRunTime());
                    intent.putExtra("moviePlot", selectedMovie.getPlot());
                    intent.putExtra("movieImdbID", selectedMovie.getImdbID());
                    intent.putExtra("movieImdbRating", selectedMovie.getImdbRating());

                    view.getContext().startActivity(intent);
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }

}


