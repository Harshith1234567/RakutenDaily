package com.tata.streams;
import java.util.*;
import java.util.stream.Stream;
public class streamsDemo {
	public static void main(String[] args)
	{
		List<Integer> list= new ArrayList<>();
		list.add(1);
		list.add(-1);
		list.add(10);
		Stream<Integer> s1=list.stream();
		Stream<Integer> filtered=s1.filter((Integer arg0)->{ arg0>0;
		});
		Optional<Integer> reduced =filtered.reduce((Integer previous,Integer current)->
		System.out.println(previous+","+current);
		return previous+current;
		
		});
		
		System.out.println(reduced.get());
		
		
		
		
		
		
		
	}

}
