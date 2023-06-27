package com.cogent.SpringBootAssignment.Assignment;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class SortingService {
	@Autowired
	@Qualifier("bubbleSort") //BubbleSort
	SortingAlgorithm sorting; //interface type

	public ArrayList<Integer> sort(ArrayList<Integer> arrayList) {
		sorting.sort(arrayList);
		return arrayList;
	}
	
}
