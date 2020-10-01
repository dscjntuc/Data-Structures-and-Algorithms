def bubble_sort(arr):
	for i in range(len(arr)):
		for j in range(len(arr) - 1):
			if arr[j] > arr[j+1]:
				arr[j], arr[j+1] = arr[j+1], arr[j]
				
n = int(input("Enter number of elements: "))
print("Enter the elements with spaces:", end=" ")
array = [int(i) for i in input().split()][:n]
bubble_sort(array)
print("Sorted output = ", array)