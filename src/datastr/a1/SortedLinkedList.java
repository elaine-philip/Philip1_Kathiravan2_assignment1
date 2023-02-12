package datastr.a1;

public class SortedLinkedList {
    private NodeType head;
    private NodeType currentPos;


    public SortedLinkedList() {
        head = null;
        currentPos = head;
    } // constructor

    public NodeType getHead() {
        return head;
    } //getHead

    public int getLength() {
        int length = 1;
        if (head == null) {
            length = 0;
        } else {
            NodeType tempCount = new NodeType();
            tempCount = head;
        // temp node to search through list

        while (tempCount.next != null) {
            tempCount = tempCount.next;
            length++;
        } // while
        // finds length
        }
        return length;
    } // getLength

    public void insertItem(ItemType item) {
        NodeType node = new NodeType();
        node.info = item;

        if (head != null && searchItem(item) > 0) {
            System.out.println("Item already exists");
        } else if (head == null || item.compareTo(head.info) == -1) { // special case
            node.next = head;
            head = node;
        } else { // general case
            currentPos = head;
            while (currentPos.next != null && (node.info.compareTo(currentPos.next.info) == 1)) {
                currentPos = currentPos.next;
            } // while
            // finds where to insert new node

            node.next = currentPos.next;
            currentPos.next = node;
            // inserts the new node
        } // if
        currentPos = head;
    } // insertItem

    public void deleteItem(ItemType item){
        currentPos = head;
        if (head == null) { // empty check
            System.out.println("You cannot delete from an empty list");
        } else if (this.getLength() == 1) { // one item check
            if (currentPos.info.compareTo(item) == 0) {
                head = null;
            } // if
            // makes list empty
        } else if (this.searchItem(item) <= 0) {
            System.out.println("The item is not present in the list");
        } else if (currentPos.info.compareTo(item) == 0) { // first item check
            head = currentPos.next;
        } else { // general case
            while (currentPos.next != null) {
                if (currentPos.next.info.compareTo(item) == 0) {
                    currentPos.next = currentPos.next.next;
                    break;
                } else {
                    currentPos = currentPos.next;
                } // if
            } // while
        } // if
    } // deleteItem

    public int searchItem(ItemType item) {
        if (this.head == null) { // empty check
            return 0;
        } else {
            int index = 1;
            NodeType temp = new NodeType();
            temp = head;
            while (temp.next != null) {
                if (temp.info.compareTo(item) == 0) {
                    break;
                } else {
                    temp = temp.next;
                    index++;
                } // if
            } // while
            // finds index of item

            if (index == this.getLength()) { // if at end or not present
                if (temp.info.compareTo(item) ==  0) { // at end
                    return index;
                } else { // not present
                    return -1;
                } // if
            } else { // if present
                return index;
            } // if
        } // if
        // returns index of item if present

    } // searchItem
    // ADD CHECK FOR EMPTY LIST



    public ItemType getNextItem() {
        ItemType gni = new ItemType();
        if (head == null) { // empty check
            System.out.println("The list is empty");
            return null;
        } else {
            if (currentPos == null) {
                currentPos = head;
            } // if
            gni.initialize(currentPos.info.getValue());
            currentPos = currentPos.next;
            System.out.println(gni.getValue());
        } // if
        return gni;
    } // getNextItem
    //NEED TO TEST EMPTY CHECK AFTER DELETE IS MADE

    public void resetList() {
        System.out.println("Iterator is reset");
        currentPos = null;
    } // resetList

    public static NodeType mergeList(NodeType head1, NodeType head2) {
        // if head1 is null, that list is empty, so return the other and vice versa
        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        }
        // choose the first head based on which head is the smallest
        NodeType mergedHead = null;
        if (head1.info.compareTo(head2.info) == -1) {
            mergedHead = head1;
            head1 = head1.next;
        } else {
            mergedHead = head2;
            head2 = head2.next;
        }

        NodeType mergedTail = mergedHead;

        // if head1 is less than head2, then set temp to head1
        while (head1 != null && head2 != null) {
            NodeType temp = null;
            if (head1.info.compareTo(head2.info) == -1) {
                temp = head1;
                head1 = head1.next;
            } else {
                temp = head2;
                head2 = head2.next;
            }

            // set mergedTail to temp
            mergedTail.next = temp;
            mergedTail = temp;
        }

        // Move to next node of comparison
        if (head1 != null) {
            mergedTail.next = head1;
        } else if (head2 != null) {
            mergedTail.next = head2;
        }
        return mergedHead;
    } // mergeList




    public void deleteAlt() {

        if (head == null) { // empty check
            System.out.println("The list is empty");
        } else if (head.next == null) { // one item check
            System.out.print("");
        } else { // general case
            currentPos = head;
            while (currentPos.next != null) {
                currentPos.next = currentPos.next.next;
                if (currentPos.next != null) { // if last element deleted
                    currentPos = currentPos.next;
                } // if
            } // while
        } // if
    } // deleteAlt

    public String intersectionList(SortedLinkedList other) {
        StringBuffer buffer = new StringBuffer();
        NodeType current = head;
        if (head == null) {
            return "Empty List";
        }
        while (current != null) {
            ItemType item = current.info;

            if (other.searchItem(item) >= 0) {
                buffer.append(item.getValue()).append(" ");
            }
            current = current.next;
        }
        return buffer.toString();
} // intersectionList


    public static NodeType sortedMergeNoDupe(NodeType head1, NodeType head2) {
        // Merge list
        NodeType head = mergeList(head1, head2);
        // remove duplicates
        removeDuplicates(head);
        return head;
    } // sortedMergeNoDupe

    static void removeDuplicates(NodeType head) {
        // pointer to traverse
        NodeType curr = head;
        // do nothing if list is empty
        if (curr == null) {
            return;
        }

        while (curr.next != null) {
            // if current node is equal to next, skip over next node, else advance
            if (curr.info.compareTo(curr.next.info) == 0) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

    } // removeDuplicates

    public void print() {
        NodeType temp = new NodeType();
        temp = head;

        if (head == null) { // empty
            System.out.println("");
        } else {
            while (temp.next != null) {
                System.out.print(temp.info.getValue() + " ");
                temp = temp.next;
            } // while
            System.out.println(temp.info.getValue() + " ");
        } // if
        currentPos = head;
    } // print


} // SortedLinkedList
