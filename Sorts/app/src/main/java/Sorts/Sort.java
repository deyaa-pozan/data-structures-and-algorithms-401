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
        public int[] quickSort(int[] arr){
            int left = 0;
            int right = arr.length -1;
            return quickSort(left, right, arr);
        }
        private int[] quickSort(int left, int right, int[] arr){
    
            if(left < right ){
                int position = partition(arr, left,right);
                quickSort(left, position -1,arr );
                quickSort(position +1, right ,arr);
    
            }
            return arr;
        }
        private int partition(int[] arr, int left, int right) {
            int p = arr[right];
            int low = left-1 ;
            int i;
            for( i = left; i< right; i++){
                if(arr[i] <= p){
                    low++;
                    swap(arr, low, i);
                }
            }
            swap(arr, low+1, right);
            return low+1;
        }
        private void swap(int[] arr, int idx1, int idx2) {
            int temp = arr[idx1];
            arr[idx1]  = arr[idx2];
            arr[idx2] = temp;
        }
}