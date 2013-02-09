package com.googlecode.pongo.tests.blog.model;

import com.mongodb.DBObject;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBList;

import java.util.List;
import com.googlecode.pongo.runtime.Pongo;
import com.googlecode.pongo.runtime.PongoList;
import com.googlecode.pongo.runtime.PrimitiveList;
import com.googlecode.pongo.runtime.PongoFactory;


public class FeaturedPost extends Post {
	
	
	
	public FeaturedPost() { 
		super();
	}
	
	public FeaturedPost(DBObject dbObject) {
		super(dbObject);
	}
	
	public String getReason() {
		return parseString(dbObject.get("reason")+"", "");
	}
	
	public FeaturedPost setReason(String reason) {
		dbObject.put("reason", reason + "");
		notifyChanged();
		return this;
	}
	
	
	
	
}