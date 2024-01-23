package com.example.movieapp;

public class Movie {
    private String title;
    private String year;
    private String plot;
    private String rated;
    private String imdbID;
    private String genre;
    private String runTime;
    private String imdbRating;
    private String poster;

    Movie(String title, String year, String plot, String rated, String imdbID, String genre, String runTime, String imdbRating, String poster){
        this.title = title;
        this.year = year;
        this.plot = plot;
        this.rated = rated;
        this.imdbID = imdbID;
        this.genre = genre;
        this.runTime = runTime;
        this.imdbRating = imdbRating;
        this.poster = poster;
    }

    public String getTitle() {
        return title;
    }
    public String getYear() {
        return year;
    }
    public String getPlot() {
        return plot;
    }
    public String getRated() {
        return rated;
    }
    public String getImdbID() {
        return imdbID;
    }
    public String getGenre() {
        return genre;
    }
    public String getRunTime() {
        return runTime;
    }
    public String getImdbRating() {
        return imdbRating;
    }
    public String getPoster() {
        return poster;
    }

}

