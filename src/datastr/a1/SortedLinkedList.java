package datastr.a1;

public class SortedLinkedList {
    private NodeType head;
    private NodeType currentPos;


    public SortedLinkedList() {
        head = null;
        currentPos = head;
    } // constructor

    public int getLength() {

        int length = 1;
        NodeType tempCount = new NodeType();
        tempCount = head;
        // temp node to search through list

        while (tempCount.next != null) {
            tempCount = tempCount.next;
            length++;
        } // while
        // finds length
        return length;
    } // getLength

    public void insertItem(ItemType item) {
        NodeType node = new NodeType();
        node.info = item;

        if (head == null || item.compareTo(head.info) == -1) { // special case
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
    // ADD CHECK FOR DUP

    public void deleteItem(ItemType item){

    } // deleteItem

    public int searchItem(ItemType item) {
        if (this.head.next == null) { // empty check
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

    public void print() {
        NodeType temp = new NodeType();
        temp = head;
        while (temp.next != null) {
            System.out.print(temp.info.getValue() + " ");
            temp = temp.next;
        } // while
        System.out.println(temp.info.getValue() + " ");
        currentPos = head;
    } // print


} // SortedLinkedList
