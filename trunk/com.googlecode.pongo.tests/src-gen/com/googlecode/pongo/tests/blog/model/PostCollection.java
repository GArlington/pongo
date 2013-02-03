package com.googlecode.pongo.tests.blog.model;


import com.googlecode.pongo.runtime.PongoCollection;
import com.googlecode.pongo.runtime.PongoCursorIterable;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;

public class PostCollection extends PongoCollection {
	
	public PostCollection(DBCollection dbCollection) {
		super(dbCollection);
		createIndex("title");
	}
	
	public Iterable<Post> getPosts() {
		return new PongoCursorIterable<Post>(this, dbCollection.find());
	}
	
	public Iterable<Post> findPostsById(String id) {
		return new PongoCursorIterable<Post>(this, dbCollection.find(new BasicDBObject("_id", id)));
	}
	
	public Iterable<Post> findPostsByTitle(String q) {
		return new PongoCursorIterable<Post>(this, dbCollection.find(new BasicDBObject("title", q + "")));
	}
	
}