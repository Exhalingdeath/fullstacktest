package com.blogspot.itengineer;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.blogspot.sqlboy.DatabaseHandler;

import lyme.domain.MovieMaker;
import lyme.logic.DataTreater;
import lyme.logic.Middleman;

@Path("")
public class MyClass {
 private Middleman middleMan = new DataTreater();

 @GET
 @Path("/1/{sortby}")
 @Produces("application/json")
 public Response print1(@PathParam("sortby") String sortby) {
  String result = middleMan.fetchMovies(sortby);
  return Response.status(200).entity(result).build();
 }
 @GET
 @Path("/2")
 @Produces("text/plain")
 public Response print2() {
	  MovieMaker.makeMovie();
	  return Response.status(200).entity("2").build();
	 }
 @GET
 @Path("/3")
 @Produces("text/plain")
 public Response print3() {
	  String result = "3";
	  return Response.status(200).entity(result).build();
	 }
}