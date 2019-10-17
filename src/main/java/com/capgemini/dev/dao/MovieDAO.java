package com.capgemini.dev.dao;

import com.capgemini.dev.beans.Movie;

public interface MovieDAO 
{
	
	public boolean createMovie(Movie m);
	public boolean deleteMovie(int movieId);
	public boolean updateRatings(int movieId, int rating);
	public Movie searchById(int id);
	
}