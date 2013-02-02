package com.googlecode.pongo.tests.model;

import org.googlecode.pongo.runtime.PongoCollection;
import org.googlecode.pongo.runtime.PongoCursorIterable;

import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;

public class PostCollection extends PongoCollection {
	
	public PostCollection(DBCollection dbCollection) {
		super(dbCollection);
		createIndex("title");
	}
	
	public Iterable<Post> getPosts() {
		return new PongoCursorIterable<Post>(dbCollection.find());
	}
	
	public Iterable<Post> findPostsByTitle(String q) {
		return new PongoCursorIterable<Post>(dbCollection.find(new BasicDBObject("title", q + "")));
	}
	
}