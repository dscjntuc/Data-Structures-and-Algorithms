# Python3 program to solve N Queen Problem using backtracking 

# N = Number of Queens to be placed (in this case, N = 4)
global N 
N = 4

# a function to print the board with the solution
def printSolution(board): 
	for i in range(N): 
		for j in range(N): 
			print (board[i][j], end = " ") 
		print() 

# A  function to check if a Queen can be placed on board[row][col]. 
def isSafe(board, row, col): 

	# Check this row on left side 
	for i in range(col): 
		if board[row][i] == 1: 
			return False

	# Check upper diagonal on left side 
	for i, j in zip(range(row, -1, -1), 
					range(col, -1, -1)): 
		if board[i][j] == 1: 
			return False

	# Check lower diagonal on left side 
	for i, j in zip(range(row, N, 1), 
					range(col, -1, -1)): 
		if board[i][j] == 1: 
			return False

	return True

def solveNQUtil(board, col): 
	
	# base case: If all Queens are placed then return true 
	if col >= N: 
		return True

	# Consider this column and try placing this Queen in all rows one by one 
	for i in range(N): 

		if isSafe(board, i, col): 
			
			# Place this Queen in board[i][col] 
			board[i][col] = 1

			# recur to place rest of the Queens 
			if solveNQUtil(board, col + 1) == True: 
				return True

			# If placing Queen in board[i][col] doesn't lead to a solution, then remove Queen from board[i][col] 
			board[i][col] = 0

	# if the Queen can not be placed in any row in this column col then return false 
	return False

# This function solves the N Queen problem using Backtracking.
# It returns false if Queens cannot be placed, otherwise return true.
def solveNQ(): 
	board = [ [0, 0, 0, 0], 
			[0, 0, 0, 0], 
			[0, 0, 0, 0], 
			[0, 0, 0, 0] ] 

	if solveNQUtil(board, 0) == False: 
		print ("Solution does not exist") 
		return False

	printSolution(board) 
	return True

# Driver Code 
solveNQ() 


# Output (with N = 4) -

# 0 0 1 0 
# 1 0 0 0 
# 0 0 0 1 
# 0 1 0 0 

# Time Complexity = O(n^n), where N is the number of Queens.
