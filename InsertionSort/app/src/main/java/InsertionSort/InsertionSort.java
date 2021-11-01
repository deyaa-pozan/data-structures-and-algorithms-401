package InsertionSort;

public class InsertionSort {
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
}