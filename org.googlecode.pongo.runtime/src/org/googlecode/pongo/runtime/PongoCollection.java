package org.googlecode.pongo.runtime;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;

public class PongoCollection {
	
	protected DBCollection dbCollection;
	
	public DBCollection getDbCollection() {
		return dbCollection;
	}
	
	public PongoCollection(DBCollection dbCollection) {
		this.dbCollection = dbCollection;
	}
	
	public void save(Pongo pongo) {
		dbCollection.save(pongo.dbObject);
	}
	
	public void createIndex(String field) {
		dbCollection.ensureIndex(new BasicDBObject(field, 1), new BasicDBObject("background", true));
	}
	
}