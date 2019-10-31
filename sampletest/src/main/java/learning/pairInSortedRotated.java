package learning;

public class pairInSortedRotated {
	public static void main(String[] args) {
		int[] arr = {11, 15, 6, 8, 9, 10};
		System.out.println(pairInSortedRotated(arr, 16));
	}
	//{11, 15, 6, 8, 9, 10}
	public static int pairInSortedRotated(int[] arr, int total) {
		int i;
		int size = arr.length;
		
		for (i =0;i<arr.length;i++) {
			if (arr[i] > arr[i+1])
				break;
		}
		
		int l = (i+1)%size;
		int r = i;
		int count =0;
		
		while (l!=r) {
			if(arr[l]+arr[r] == total) {
				count ++;
				if(l == (r-1+size) % size) {
					return count;
				}
				l = (l+1)%size;
				r = (r-1+size)%size;
			}
			else if (arr[l]+arr[r] < size) {
				l = (l+1)%size;
			} else {
				r = (size+r-1)%size;
			}
		}
		return count;
	}
	
	// This function returns true if arr[0..n-1]  
    // has a pair with sum equals to x. 
    static boolean pairInSortedRotated(int arr[],  
                                    int n, int x) 
    { 
        // Find the pivot element 
        int i; 
        for (i = 0; i < n - 1; i++) 
            if (arr[i] > arr[i+1]) 
                break; 
                  
        int l = (i + 1) % n; // l is now index of                                           
                            // smallest element 
                           
        int r = i;       // r is now index of largest  
                         //element 
       
        // Keep moving either l or r till they meet 
        while (l != r) 
        { 
             // If we find a pair with sum x, we 
             // return true 
             if (arr[l] + arr[r] == x) 
                  return true; 
       
             // If current pair sum is less, move  
             // to the higher sum 
             if (arr[l] + arr[r] < x) 
                  l = (l + 1) % n; 
                    
             else  // Move to the lower sum side 
                  r = (n + r - 1) % n; 
        } 
        return false; 
    } 

}
