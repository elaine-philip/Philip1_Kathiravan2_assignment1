Elaine Philip - emp49872@uga.edu
    Contribution:
    Created and inplemented functions for ItemType class and NodeType class.
    Implemented insert, delete, search, length, getNextItem, resetList, delete alternate,
    and print functions in SortedLinkedList and Driver class

    DeleteAlt = O(n)

 Kavya - krk08454@uga.edu
    Contribution:
    Created and implemented print, mergeList, intersectionList, getHead, sortedMergeNoDupe, removeDuplicates
    in SortedLinkedList and Driver Class

    MergeList Pseudo Code:
    In order to to implement mergeList I went through a series of steps. First I needed to check if head
    was null, and if it means that the list is empty, and I would then return the other list. Next I chose
    the first head depending on which value was smaller. Afterwards, if the first head was less than the
    second head, I would then set the temp to the first head. This occurs in the while loop, which iterates
    in a constant rate for both lists, which is why the time complexity is O(n). Next, I set the mergedTail
    value to temp, and then traversed to the next node for comparison.

    MergeList = O(n + m) [n is list1, m is list 2]

    IntersectionList Pseudo Code:
    In order to implement intersectionList, I first had to create a new buffer to store the new values.
    Aftwards I checked if the the list was empty, if true, then printed "Empty list", else I created a while
    loop that searches for the index of a given value and if it matched, then I appended that value to a new
    stringbuffer called buffer. The complexity of the while loop iterates in a constant rate for the first list,
    and simply calls the searchItem function, which is why the time complexity is O(n). I then traverse to check
    the next node value and loop again.

    IntersectonList = O(n) [n is list1]


    How to Complie:
        javac -cp bin/ -d bin/ src/datastr/a1/SortedLinkedList.java
        javac -cp bin/ -d bin/ src/datastr/a1/LinkedListDriver.java
    How to Run:
        java -cp bin/ src/datastr/a1/LinkedListDriver.java input.txt