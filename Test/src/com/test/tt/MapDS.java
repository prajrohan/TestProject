package com.test.tt;

import java.util.ArrayList;
import java.util.HashSet;

public class MapDS {


	public static void main(String[] args) {
	    HashSet<MultiKeyPair> set = new HashSet<MultiKeyPair>();
	    set.add(new MultiKeyPair("A","a1"));
	    set.add(new MultiKeyPair("A","a2"));
	    set.add(new MultiKeyPair("B","b1"));
	    set.add(new MultiKeyPair("A","a3"));
	    set.add(new MultiKeyPair("A","a3"));
	    set.add(new MultiKeyPair("A","a3"));

	    for (MultiKeyPair pair : set) {
	        System.out.println("Key-->"+pair.key+"   Values-->"+pair.value);
	    }
	}
	
	
}


class MultiKeyPair {
    Object key;
    Object value;

    public MultiKeyPair(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int hashCode() {
        return key.hashCode();
    }
}

class MultiKeyList extends MultiKeyPair {
    ArrayList<MultiKeyPair> list = new ArrayList<MultiKeyPair>();

    public MultiKeyList(Object key) {
        super(key, null);
    }

    @Override
    public boolean equals(Object obj) {
        list.add((MultiKeyPair) obj);
        return false;
    }
}





