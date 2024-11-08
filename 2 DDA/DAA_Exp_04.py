def knapsack_01(values, weights, capacity):
    n = len(values)
    
    # Ensure capacity is an integer
    capacity = int(capacity)
    
    # Create a table to store the maximum values for different subproblems
    dp = [[0 for _ in range(capacity + 1)] for _ in range(n + 1)]

    # Fill the dp table based on the conditions outlined
    for i in range(n + 1):
        for w in range(capacity + 1):
            if i == 0 or w == 0:
                dp[i][w] = 0  # Base condition: no items or zero capacity
            elif weights[i - 1] <= w:
                # If the item can be included
                dp[i][w] = max(dp[i - 1][w], values[i - 1] + dp[i - 1][w - weights[i - 1]])
            else:
                # If the item cannot be included
                dp[i][w] = dp[i - 1][w]

    # Printing the DP matrix for visualization
    print("\nDP Matrix:")
    for row in dp:
        print(row)

    # Backtrack to find the selected items
    selected_items = []
    i, w = n, capacity
    while i > 0 and w > 0:
        if dp[i][w] != dp[i - 1][w]:  # Item was selected
            selected_items.append(i - 1)
            w -= weights[i - 1]
        i -= 1

    selected_items.reverse()

    return dp[n][capacity], selected_items

# Example usage:
if __name__ == "__main__":
    n = int(input("Enter the number of items: "))  # e.g., 3
    values = []
    weights = []
    
    for i in range(n):
        value = int(input(f"Enter the value of item {i + 1}: "))  # e.g., 60, 100, 120
        weight = int(input(f"Enter the weight of item {i + 1}: "))  # e.g., 10, 20, 30
        values.append(value)
        weights.append(weight)

    max_capacity = int(input("Enter the maximum capacity of the knapsack: "))  # e.g., 50

    # Call the knapsack_01 function
    max_value, selected_items = knapsack_01(values, weights, max_capacity)

    # Display the selected items and the maximum value
    print("\nSelected Items:")
    for item in selected_items:
        print(f"Item {item + 1} with weight {weights[item]} and value {values[item]}")

    print(f"\nMaximum value achievable: {max_value}")
