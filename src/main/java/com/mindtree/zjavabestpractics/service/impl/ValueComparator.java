package com.mindtree.zjavabestpractics.service.impl;

import java.util.Comparator;
import java.util.Map;

public class ValueComparator implements Comparator<Integer> {
		    Map<Integer, String> base;

		    public ValueComparator(Map<Integer, String> map) {
		        this.base = map;
		    }

		    // Note: this comparator imposes orderings that are inconsistent with
		    // equals.
//		    public int compare(String a, String b) {
//		        if (base.get(a) >= base.get(b)) {
//		            return -1;
//		        } else {
//		            return 1;
//		        } // returning 0 would merge keys
//		    }

			public int compare(Integer o1, Integer o2) {
				if(base.get(o1).compareTo(base.get(o2))>1) {
					return 1;
				}
				else
				return -1;
			}
}
