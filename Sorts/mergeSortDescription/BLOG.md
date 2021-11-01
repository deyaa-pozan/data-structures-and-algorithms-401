# Merge Sort Blog

## In this article will trace and explain how Merge sort works:

## Merge Sort: 

Merge Sort is a `Divide and Conquer` algorithm. It divides the input array into two halves, calls itself for the two halves, and then merges the two sorted halves. The `merge()` function is used for merging two halves. The `merge(leftArray, rightArray, array)` is a key process that assumes that `leftArray` and `rightArray` are **sorted** and merges the two sorted sub-arrays into one.

## Pseudocode:

```
ALGORITHM Mergesort(arr)
    DECLARE n <-- arr.length
           
    if n > 1
      DECLARE mid <-- n/2
      DECLARE left <-- arr[0...mid]
      DECLARE right <-- arr[mid...n]
      // sort the left side
      Mergesort(left)
      // sort the right side
      Mergesort(right)
      // merge the sorted left and right sides together
      Merge(left, right, arr)

ALGORITHM Merge(left, right, arr)
    DECLARE i <-- 0
    DECLARE j <-- 0
    DECLARE k <-- 0

    while i < left.length && j < right.length
        if left[i] <= right[j]
            arr[k] <-- left[i]
            i <-- i + 1
        else
            arr[k] <-- right[j]
            j <-- j + 1
            
        k <-- k + 1

    if i = left.length
       set remaining entries in arr to remaining values in right
    else
       set remaining entries in arr to remaining values in left
```

## Trace:

Sample Array: `[8,4,23,42,16,15]`

starting by pass the array to the method => `mergeSort([8,4,23,42,16,15])`

### step 1:

![step1](step1.jpg)

### step 2:

![step1](step2.jpg)

### step 3:

![step1](step3.jpg)

### step 4:

![step1](step4.jpg)

### step 5:

![step1](step5.jpg)

### step 6:

![step1](step6.jpg)
