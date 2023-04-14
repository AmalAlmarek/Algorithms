import java.lang.Math;
import java.util.Random;
public class mergesort{ 
    public static void main (String[] args) { 
       
        //generating unsorted array randomly
        Random rand = new Random();
        int [] numbers = new int[9];
        for(int i = 0 ; i < numbers.length ; i++){
            numbers[i] = rand.nextInt(10000);
        }
        System.out.println("Array Before:");
        printarray(numbers);

        // sorting 
        numbers = mergesortt(numbers);  

        System.out.println("Array After:");
        printarray(numbers);

    }
    public static int[] mergesortt(int[] A) { 
        // length of the array 
        int n = A.length;
        int mid = n/2;

        int [] mergedArray = new int[n];
        if(n > 1){
        // creating 2 sub-arrays from big array
        int[] l1 = new int[mid];
        int[] l2 = new int[n-mid];
        
        // copy content of A[0 .... floor[n/2]-1] , A[floor[n/2] ... n-1]
        for(int i = 0 ; i < mid ; i++){
            l1[i] = A[i];
        }
        // 1 -> 2 -> 3 -> 4->5->6
        for(int i = mid ; i<n ;i++){
            l2[i - mid]= A[i];
        }
        // sort the left sub-array
        mergesortt(l1);
        // sort the right sub-array
        mergesortt(l2);
        // merge both arrays
        mergedArray = merge(l1, l2 , A);
    }
    else {
        System.out.println("sorted List");}
    
        return mergedArray;
    }
    public static int[] merge(int[] left , int[] right , int[] A){
       
       int leftSize = left.length;
       int rightSize = right.length; 
       
       int i = 0 , j = 0 , k = 0;
       while(i < leftSize && j< rightSize)
        {
            if(left[i]<= right[j]){
                A[k] = left[i];
                i++;
            }
            else {
                A[k] = right[j];
                j++;
            }
            k++;
        }

        while(i<leftSize)
        {
            A[k]= left[i];
            i++;
            k++;
        }
        while(j < rightSize)
        {
            A[k] = right[j];
            j++;
            k++;
        }
       return A;
    }
    public static void printarray(int[] array) { 
        for(int num : array) { 
            System.out.print(num+" ");
        }
        System.out.println(); 
    }
}