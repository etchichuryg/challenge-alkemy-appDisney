package com.alkemy.challenge.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Sort;

import com.alkemy.challenge.model.Movies;

public class MoviesDto implements Serializable{
	
	private static final long serialVersionUID = 1L;

		
		private String title;
		private String image;
		private Date createDate;
		
		public MoviesDto() {
			
		}
		
		public MoviesDto(String title, String image, Date createDate) {
			super();
			this.title = title;
			this.image = image;
			this.createDate = createDate;
		}
		public MoviesDto(Movies movies) {
			this.title = movies.getTitle();
			this.image = movies.getImage();
			this.createDate = movies.getCreateDate();
		}
		
		public static List<MoviesDto> mapToDto (List<Movies>moviesList){
			List<MoviesDto> list = new ArrayList<>();
			for (Movies m : moviesList) {
				list.add(new MoviesDto(m));
			}
			return list; 
		}
			
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getImage() {
			return image;
		}
		public void setImage(String image) {
			this.image = image;
		}
		public Date getCreateDate() {
			return createDate;
		}
		public void setCreateDate(Date createDate) {
			this.createDate = createDate;
		}
		public List<Movies> findAll(Sort sortByCreateDateAsc) {
				return null;
		}
		
	

		

}
