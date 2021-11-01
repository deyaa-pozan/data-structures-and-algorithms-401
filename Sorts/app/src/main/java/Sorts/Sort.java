package Sorts;

import java.util.Arrays;

public class Sort {
    public int[] insertionSort(int[] arr){
        if(arr.length <=1){
            return arr;
        }
        int j;
        for(int i = 1 ; i< arr.length; i++){
            int temp = arr[i];
            for ( j = i-1; j>=0 && temp < arr[j]; j--){
                arr[j+1] = arr[j];
            }
            arr[j+1] = temp;
        }
        return arr;
    }

    public int[] mergeSort(int[] arr){
        int n = arr.length;
        if(n>1){
         int mid = n/2;
         int[] left = Arrays.copyOfRange(arr,0,mid);
         int[] right = Arrays.copyOfRange(arr, mid,n);
         left  = mergeSort(left);
         right = mergeSort(right);
         arr = merge(left, right, arr);
        }
        return arr;
    }

    private static int[] merge(int[] left, int[] right, int[] arr) {

        int i=0;
        int j=0;
        int k=0;
        while(i < left.length && j < right.length){
            if( left[i] <= right[j] ){
                arr[k] = left[i];
                i++;
            }
            else{
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        if(i == left.length ){
            while( j < right.length){
                arr[k] = right[j];
                j++;
                k++;
            }
        }
        else{
            while( i < left.length){
                arr[k] = left[i];
                i++;
                k++;
            }
        }
        return arr;
    }
}