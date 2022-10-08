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