package com.cogent.SpringBootAssignment.Assignment;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SortController {
	
	@Autowired
	SortingService Sorting;
	
	ArrayList<Integer> arrayList  = new ArrayList<>();
	
	@GetMapping("/addToArray")
	public ArrayList<Integer> fillArray() {
		arrayList.add(3);
		arrayList.add(7);
		arrayList.add(5);
		arrayList.add(6);
		arrayList.add(8);
		return arrayList;
	}
	@GetMapping("/addOneElement/{number}")
	public ArrayList<Integer> addOne(@PathVariable int number){
		arrayList.add(number);
		return arrayList;
	}
	@GetMapping("/sortArray")
	public ArrayList<Integer> sortArray()
	{
		Sorting.sort(arrayList);
		return  arrayList;
	}
}
