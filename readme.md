# Segment Tree

#### Space complexity
O(n) (whole tree fits in array of size 2n-1)

#### Time complexity
O(n) build
O(log n) query
O(log n) update

# Sparse Table

#### Space complexity

A sparse table built with fixed size arrays would have O(n log n) space complexity, but since this one uses lists without any empty spaces I'm not sure how much it is. But it is less.

#### Time complexity

O(n log n) build

O(1) query if queries can overlap
O(log n) query if queries cannot overlap

## Stuff to do

binary search tree
red-black tree
avl tree
k/d tree
persistent data structures/trees

Union find
Tarjan's algorithm for finding Strongly Connected Components
Topological sorting and DAG relaxation
Dijkstra's algorithm
Bellman-ford algorithm
