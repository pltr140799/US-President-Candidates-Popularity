1. READEME:
   Name: PhuongLinh Tran
   How to compile:
   How to run:
   Known Bugs and Limitations:
   Discussion: For the remove() method, I created a helper method removeRec()
   as a recursive decomposition of the remove() method and another helper
   method min() . The removeRec() helper method takes a tree node as the root
   of the current subtree that the method is operating on and an element to be
   removed. It then compares the element with the element that the root refers
   to. If the element to be removed if "less" than one that the root points to
   then the method recurses on the left subtree of the root and if the element
   to be removed is considered the "greater" one than the method recurses on
   the right subtree. If the method finds the node that has an "equal" element,
   it will consider 3 cases where the node has zero child, if it has one child
   and if it has two children. If it has only zero child, the method will
   simply remove the node and if it has one child the method will replace it
   with its successor. Whereas if the node has two children the method will
   find the right-most minimum element among the node's successors by calling
   min() helper method and replace the node with it. Finally, remove() calls
   removeRec() on the root of the binary tree and the element to be removed.

   Extra: if two candidates have same last name than they will be compared
   using their first names as well.

2. Source files: all .java files
3. Data files used: all .csv files

   
