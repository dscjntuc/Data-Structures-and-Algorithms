/**
 *  Time Complexity: O(log(n))
 */

class Fibonacci 
{    
    // find minimum  
    public static int min(int x, int y)  
    { return (x <= y)? x : y; } 
  
    // Returns index of x if present
    public static int search(int arr[], int x, int n) 
    { 
        // Initialize fibonacci numbers
        int fib2 = 0; 
        int fib1 = 1; 
        int fib = fib2 + fib1; 
  
        // store the smallest Fibonacci Number greater than or equal to n
        while (fib < n) 
        { 
            fib2 = fib1; 
            fib1 = fib; 
            fib = fib2 + fib1; 
        } 
  
        int offset = -1; 

        while (fib > 1) 
        { 
            // Check if fib2 is a valid location 
            int i = min(offset+fib2, n-1); 
  
            if (arr[i] < x) 
            { 
                fib = fib1; 
                fib1 = fib2; 
                fib2 = fib - fib1; 
                offset = i; 
            } 
  
            else if (arr[i] > x) 
            { 
                fib = fib2; 
                fib1 = fib1 - fib2; 
                fib2 = fib - fib1; 
            } 
  
            else return i; 
        } 
  
        if(fib1 == 1 && arr[offset+1] == x) 
            return offset+1; 
  
        // element not found
        return -1; 
    } 
      
    // driver code 
    public static void main(String[] args) 
    { 
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; 
        int n = 1; 
        int x = 6; 
        System.out.print ( x + " found at index: "+ 
                   search(arr, x, n)); 
    } 
} 