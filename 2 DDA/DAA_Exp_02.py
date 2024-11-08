import heapq

class node:
    def __init__(self, freq, symbol, left=None, right=None):
        self.freq = freq
        self.symbol = symbol
        self.left = left
        self.right = right
        self.huff = ""
    
    def __lt__(self, other):
        return self.freq < other.freq
    
def printNodes(node, val=""):
    newval = val + node.huff
    if node.left:
        printNodes(node.left, newval)
    if node.right:
        printNodes(node.right, newval)
    else:
        print(f"{node.symbol} -> {newval}")

# Taking input from the user for characters and frequencies
chars = input("Enter characters separated by space: ").split()  # E.g., "a b c d e f"
freqs = list(map(int, input("Enter frequencies separated by space: ").split()))  # E.g., "5 9 12 13 16 45"

# Creating initial nodes
nodes = []
for i in range(len(chars)):
    heapq.heappush(nodes, node(freqs[i], chars[i]))

# Building the Huffman Tree
while len(nodes) > 1:
    left = heapq.heappop(nodes)
    right = heapq.heappop(nodes)
    left.huff = "0"
    right.huff = "1"
    newnode = node(left.freq + right.freq, left.symbol + right.symbol, left, right)
    heapq.heappush(nodes, newnode)

# Printing the Huffman codes
printNodes(nodes[0])
