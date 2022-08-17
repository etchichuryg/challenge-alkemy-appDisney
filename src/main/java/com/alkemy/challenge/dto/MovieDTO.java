package com.alkemy.challenge.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.alkemy.challenge.model.Movie;

@Component
public class MovieDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

		
		private String title;
		private byte[] image;
		private Date date;
		
		public MovieDTO() {
			
		}
		
		public MovieDTO(String title, byte[] image, Date date) {
			super();
			this.title = title;
			this.image = image;
			this.date = date;
		}
		
		public MovieDTO(Movie movie) {
			this.title = movie.getTitle();
			this.image = movie.getImage();
			this.date = movie.getDate();
		}
		
		public static List<MovieDTO> mapToDto (List<Movie>movieList){
			List<MovieDTO> list = new ArrayList<>();
			for (Movie m : movieList) {
				list.add(new MovieDTO(m));
			}
			return list; 
		}
			
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public byte[] getImage() {
			return image;
		}
		public void setImage(byte[] image) {
			this.image = image;
		}
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date= date;
		}
		public List<Movie> findAll(Sort sortByCreateDateAsc) {
				return null;
		}
		
	

		

}
