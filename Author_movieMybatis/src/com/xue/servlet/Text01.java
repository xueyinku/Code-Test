package com.xue.servlet;

import java.util.List;

import com.xue.model.Actor;
import com.xue.model.Movie;
import com.xue.model.ProjectByPage;
import com.xue.service.Impl.ActorServiceImpl;
import com.xue.service.Impl.MovieServiceImpl;
import com.xue.service.Impl.ProjectServiceImpl;
import com.xue.service1.ActorService;
import com.xue.service1.MovieService;
import com.xue.service1.ProjectService;

public class Text01 {
	public static void main(String[] args) {
//		ProjectService ps = new ProjectServiceImpl();
//		ProjectByPage selectByNameAndPage = ps.selectByNameAndPage(1, "");
//		
//		System.out.println(selectByNameAndPage.getProject().get(0).getName());
		
//		ActorService as = new ActorServiceImpl();
//		List<Actor> selectActorByname = as.selectActorByname("");
//		for (Actor actor : selectActorByname) {
//			System.out.print(actor.getName());
//			System.out.print(actor.getMoviemes().getName());
//			System.out.println(actor.getMoviemes().getMoney());
//		}
		MovieService ms = new MovieServiceImpl();
		List<Movie> movies = ms.selectByName("");
		for (Movie movie : movies) {
			System.out.print(movie.getName() + "Æ±·¿" + movie.getMoney() + "Ôª" + "\n");
			List<Actor> allActors = movie.getAllActors();
			int i = 1;
			for (Actor actor : allActors) {
				System.out.println(i + "ºÅ" + actor.getSex() +"ÑÝÔ±" + actor.getName());
				i++;
			}
		}
		
	}

}
