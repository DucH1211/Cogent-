package com.cogent.SpringBootAssignment.Assignment;

import java.util.ArrayList;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
@Lazy
public class BubbleSort implements SortingAlgorithm {
	@PostConstruct
	public void postConstruct()
	{
		System.out.println("BubbleSort Bean Created");
	}
	
	@Override
	public ArrayList<Integer> sort(ArrayList<Integer> arrayList) {
		bubbleSort(arrayList,arrayList.size());
		return null;
	}
	
	static void bubbleSort(ArrayList<Integer> arr, int n)
    {
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr.get(j) > arr.get(j + 1)) {
                      
                    // Swap arr[j] and arr[j+1]
                    temp = arr.get(j);
                    arr.set(j, arr.get(j+1));
                    arr.set(j+1, temp);
                    swapped = true;
                }
            }
  
            // If no two elements were
            // swapped by inner loop, then break
            if (swapped == false)
                break;
        }
    }

}
