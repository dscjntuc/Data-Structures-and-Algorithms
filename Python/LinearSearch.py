arr = [ 2, 3, 4, 10, 40 ]; 
x = 11; 
n = len(arr); 
for i in range (0, n): 
    if (arr[i] == x): 
        print("Element is present at index", i);
        break 
else:
    print("Element is not present in array") 

# Python code for Linear search
# Working is given below:
# Traverse through the loop and if the element is present in the array then break the loop and print the statement. 
# If not then else statement gets executed which prints that element not found.
# Time complexity is O(n)
# The code is contibuted by Manan Chawla