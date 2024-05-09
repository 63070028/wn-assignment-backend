package com.example.wongnaiassignment.movie.sync;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieDatabaseInitializer implements InitializingBean {

    @Autowired
    private MovieDataSynchronizer movieDataSynchronizer;

    @Override
    public void afterPropertiesSet() throws Exception {
        movieDataSynchronizer.forceSync();
    }
}
