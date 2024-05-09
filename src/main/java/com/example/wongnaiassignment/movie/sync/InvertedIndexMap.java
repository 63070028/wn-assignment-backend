package com.example.wongnaiassignment.movie.sync;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
public class InvertedIndexMap {

    @Getter
    private static final Map<String, Set<Long>> termIds = new HashMap<>();;

    private InvertedIndexMap(){}

}
