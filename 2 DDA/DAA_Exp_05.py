def is_safe(board, row, col, n):
    # Check if there's a Queen in the same column
    for i in range(row):
        if board[i][col] == 1:
            return False

    # Check upper left diagonal
    for i, j in zip(range(row, -1, -1), range(col, -1, -1)):
        if board[i][j] == 1:
            return False

    # Check upper right diagonal
    for i, j in zip(range(row, -1, -1), range(col, n)):
        if board[i][j] == 1:
            return False

    return True

def solve_n_queens_util(board, row, n, solutions):
    # If all queens are placed, add the current solution
    if row == n:
        solutions.append([row[:] for row in board])  # Make a deep copy
        return

    for col in range(n):
        if is_safe(board, row, col, n):
            board[row][col] = 1
            solve_n_queens_util(board, row + 1, n, solutions)
            board[row][col] = 0  # Backtrack

def solve_n_queens(n):
    board = [[0 for _ in range(n)] for _ in range(n)]
    solutions = []
    
    solve_n_queens_util(board, 0, n, solutions)
    
    if not solutions:
        print("No solution exists.")
    else:
        # To track unique solutions
        seen_boards = set()
        unique_solutions = []

        # Store all solutions
        for sol in solutions:
            # Convert the board to a tuple of tuples to hash it and avoid duplicates
            board_tuple = tuple(tuple(row) for row in sol)
            if board_tuple not in seen_boards:
                seen_boards.add(board_tuple)
                unique_solutions.append(sol)
        
       
        
        # Display unique solutions
        print("\nUnique Solutions:")
        for sol in unique_solutions:
            for row in sol:
                print(row)
            print()
    print(f"Total overall solutions: {len(solutions)}")
    print(f"Total unique solutions: {len(unique_solutions)}")

# User input for number of queens
n = int(input("Enter the number of queens (n): "))
solve_n_queens(n)
