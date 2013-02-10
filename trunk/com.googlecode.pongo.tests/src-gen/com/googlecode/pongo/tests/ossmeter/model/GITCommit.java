package com.googlecode.pongo.tests.ossmeter.model;

import com.mongodb.*;
import java.util.*;
import com.googlecode.pongo.runtime.*;


public class GITCommit extends Pongo {
	
	protected List<GITCommit> parents = null;
	protected GITUser author = null;
	
	
	public GITCommit() { 
		super();
		dbObject.put("parents", new BasicDBList());
	}
	
	public String getUrl() {
		return parseString(dbObject.get("url")+"", "");
	}
	
	public GITCommit setUrl(String url) {
		dbObject.put("url", url + "");
		notifyChanged();
		return this;
	}
	public String getSha() {
		return parseString(dbObject.get("sha")+"", "");
	}
	
	public GITCommit setSha(String sha) {
		dbObject.put("sha", sha + "");
		notifyChanged();
		return this;
	}
	public String getMessage() {
		return parseString(dbObject.get("message")+"", "");
	}
	
	public GITCommit setMessage(String message) {
		dbObject.put("message", message + "");
		notifyChanged();
		return this;
	}
	
	
	public List<GITCommit> getParents() {
		if (parents == null) {
			parents = new PongoList<GITCommit>(this, "parents", true);
		}
		return parents;
	}
	
	
	public GITUser getAuthor() {
		if (author == null && dbObject.containsField("author")) {
			author = (GITUser) PongoFactory.getInstance().createPongo((DBObject) dbObject.get("author"));
		}
		return author;
	}
	
	public GITCommit setAuthor(GITUser author) {
		if (this.author != author) {
			if (author == null) {
				dbObject.removeField("author");
			}
			else {
				dbObject.put("author", author.getDbObject());
			}
			this.author = author;
			notifyChanged();
		}
		return this;
	}
}