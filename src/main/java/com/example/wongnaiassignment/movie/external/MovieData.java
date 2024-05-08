package com.example.wongnaiassignment.movie.external;

import lombok.Data;

import java.util.ArrayList;


@Data
public class MovieData {
    private String title;
    private int year;
    private ArrayList<String> cast;
    private ArrayList<String> genres;
}
