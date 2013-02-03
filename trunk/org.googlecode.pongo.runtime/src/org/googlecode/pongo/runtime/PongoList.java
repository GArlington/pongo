package org.googlecode.pongo.runtime;

import java.util.Iterator;

import com.mongodb.BasicDBList;
import com.mongodb.DBObject;

public class PongoList<T extends Pongo> extends BasicDBListWrapper<T> {
	
	protected Pongo container;
	protected String containingFeature;
	protected boolean containment = false;
	
	public PongoList(Pongo container, String feature, boolean containment) {
		super((BasicDBList) container.dbObject.get(feature));
		this.container = container;
		this.containingFeature = feature;
		this.containment = containment;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new PongoListIterator<T>(dbList);
	}
	
	protected void added(T t) {
		t.setContainer(container);
		t.setContainingFeature(containingFeature);
	};
	
	@Override
	protected T wrap(Object o) {
		return (T) PongoFactory.getInstance().createPongo((DBObject) o);
	}
	
	@Override
	protected Object unwrap(Object o) {
		return ((Pongo) o).getDbObject();
	}

}
