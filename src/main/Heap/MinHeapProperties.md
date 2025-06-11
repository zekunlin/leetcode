# heap properties

1. heap has to be a complete binary tree, and the last level all nodes are closest to left.
1. every node value is smaller or equal to its children nodes' value
   (MaxHeap is on the contrary, every node value is greater or equal to its children nodes value).
   root is always the smallest value for the entire minHeap. (for maxHeap, the root is always the greatest for the entire maxHeap).

1. a heap is not sorted
1. a heap can represented in array, and then each node in the heap follows the property:
if i is the index for the curNode, then the child node of the cur node can be accessed by:

- child node1: 2i + 1
- child node2: 2i + 2

1. if the index of a node is j, the parent node index of this node is then:
floor((i - 1)/2), just round it down.
