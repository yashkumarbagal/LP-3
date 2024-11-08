class Item:
    def __init__(self, weight, value):
        self.weight = weight
        self.value = value

def fractional_knapsack(items, capacity):
    # Calculate the value-to-weight ratio for each item
    value_weight_ratio = [(item.value / item.weight, item) for item in items]

    # Sort items in decreasing order of value-to-weight ratio
    value_weight_ratio.sort(reverse=True)

    total_value = 0.0
    knapsack = []

    for ratio, item in value_weight_ratio:
        if capacity == 0:
            break

        weight = min(item.weight, capacity)
        total_value += weight * ratio
        capacity -= weight

        knapsack.append((item, weight))

    return total_value, knapsack

# Take user input for the number of items and their weights/values
if __name__ == "__main__":
    n = int(input("Enter the number of items: "))

    items = []
    for i in range(n):
        weight = float(input(f"Enter the weight of item {i + 1}: "))
        value = float(input(f"Enter the value of item {i + 1}: "))
        items.append(Item(weight, value))

    max_capacity = float(input("Enter the maximum capacity of the knapsack: "))

    # Call the fractional knapsack function
    max_value, selected_items = fractional_knapsack(items, max_capacity)

    print("\nSelected Items (with fractional amount taken):")
    for item, weight in selected_items:
        print(f"Item with weight {item.weight} and value {item.value} (fraction taken: {weight / item.weight:.2f})")

    print(f"\nMaximum value achievable: {max_value:.2f}")



