package com.ligen.drillingfomula;


import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.Properties;
import java.util.Set;

public class OrderProperties extends Properties {

	private static final long serialVersionUID = 4112578634029874840L;
	
	private final LinkedHashSet<Object> keys = new LinkedHashSet<Object>();
	
	@Override
	public synchronized Enumeration<Object> keys() {
		
		return Collections.enumeration(keys);
	}
	@Override
	public synchronized Object put(Object key, Object value) {
		keys.add(key);
		return super.put(key, value);
	}
	
	@Override
	public Set<Object> keySet() {
		
		return keys;
	}
	
	@Override
	public Set<String> stringPropertyNames() {
		Set<String> set = new LinkedHashSet<String>();
		for(Object key : this.keys) {
			set.add((String) key);
		}
		return set;
	}
}
