package com.googlecode.pongo.tests.blog.model;

import com.mongodb.DBObject;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBList;

import java.util.List;
import org.googlecode.pongo.runtime.Pongo;
import org.googlecode.pongo.runtime.PongoList;

public class Post extends Pongo {
	
	protected List<Comment> comments = null;
	protected Author author = null;
	
	public Post() { 
		super();
		dbObject.put("author", new BasicDBObject());
		dbObject.put("comments", new BasicDBList());
	}
	
	public Post(DBObject dbObject) {
		super(dbObject);
	}
	
	public String getTitle() {
		return parseString(dbObject.get("title")+"", "");
	}
	
	public Post setTitle(String title) {
		dbObject.put("title", title + "");
		return this;
	}
	
	public List<Comment> getComments() {
		if (comments == null) {
			comments = new PongoList<Comment>(this, "comments", true);
		}
		return comments;
	}
	
	public Post setAuthor(Author author) {
		if (author != null) {
			createReference("author", author);
			this.author = author;
		}
		return this;
	}
	
	public Author getAuthor() {
		if (author == null) {
			author = (Author) resolveReference("author");
		}
		return author;
	}
	
}