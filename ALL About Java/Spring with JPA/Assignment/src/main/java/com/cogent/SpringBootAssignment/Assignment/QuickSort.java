package com.cogent.SpringBootAssignment.Assignment;

import java.util.ArrayList;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
@Lazy
public class QuickSort implements SortingAlgorithm {
	@PostConstruct
	public void postConstruct() {
		System.out.println("Quick Sort Bean Created");
	}
	
	public void swap(ArrayList<Integer> arr, int i, int j)
    {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    public int partition(ArrayList<Integer> arr, int low, int high)
    {
        // Choosing the pivot
        int pivot = arr.get(high);
 
        // Index of smaller element and indicates
        // the right position of pivot found so far
        int i = (low - 1);
 
        for (int j = low; j <= high - 1; j++) {
 
            // If current element is smaller than the pivot
            if (arr.get(j) < pivot) {
 
                // Increment index of smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }
 

    public void quickSort(ArrayList<Integer> arr, int low, int high)
    {
        if (low < high) {
 
            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);
 
            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
	
	@Override
	public ArrayList<Integer> sort(ArrayList<Integer> arrayList) {
		quickSort(arrayList,0,arrayList.size()-1);
		return arrayList;
	}

}
