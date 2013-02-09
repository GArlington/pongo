package com.googlecode.pongo.tests.blog;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;

@RunWith(Suite.class)
@SuiteClasses({MultiValuedContainmentReferencesTests.class, MultiValuedAttributesTests.class,
	NonContainmentReferencesTests.class, SingleValuedContainmentReferencesTests.class,
	SingleValuedAttributesTests.class, DeleteTests.class, UnsupportedFeaturesTests.class
})
public class BlogTestsSuite {
	
	public static Test suite() {
		return new JUnit4TestAdapter(BlogTestsSuite.class);
	}
}
