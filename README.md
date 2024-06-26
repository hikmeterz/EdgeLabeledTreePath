﻿# EdgeLabeledTreePath
## Project Description
This repository contains a Java program that processes edge-labeled trees and paths from input files. The program calculates the values of given paths in the trees, considering whether the tree represents a heap, and outputs the mean values for each path.

## Files
- `Node.java`: Defines the node structure used in the tree.
- `Tree.java`: Implements the tree structure and its operations such as building the tree from input, finding the value of a path, and checking if the tree is a heap.
- `Main.java`: Main class to handle the input parsing, tree construction, path value calculation, and output of the mean values.
- `Treefile.txt`: Contains the string representation of edge-labeled trees.
- `Pathfile.txt`: Contains the paths to be evaluated in the trees.

## Algorithm Explanation

### Node Class
The `Node` class defines the basic unit of the tree. Each node contains:
- A label (`char label`): The label of the node (either a capital letter or a number).
- References to the children nodes (`Node[] children`): Points to the children of the node.
- Reference to the parent node (`Node parent`): Points to the parent of the node.

### Tree Class
The `Tree` class manages the nodes and provides methods to manipulate the tree:
- `buildTree(String input)`: Constructs the tree from the given input string in the specified format.
- `findPathValue(String path)`: Finds the value of a given path in the tree.
- `isHeap()`: Checks if the tree represents a heap.

### Main Class
The `Main` class contains the main method to run the tree path evaluation application:
- Parses the input files to extract the trees and paths.
- Uses the `Tree` class to construct the trees and evaluate the paths.
- Calculates and outputs the mean values of the paths, considering heap structures.

### Example Workflow
1. The user inputs the tree file and path file as command line arguments:
2.  The program constructs the trees from the input strings in `treefile.txt`.
3. The program evaluates each path in `pathfile.txt` to find their values in the trees.
4. The program calculates the mean values of the paths and prints the results.
