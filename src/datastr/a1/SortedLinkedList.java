package datastr.a1;

public class SortedLinkedList {
    private NodeType head;
    private NodeType currentPos;
    private int length;

    public SortedLinkedList() {
        head = null;
        currentPos = head;
        length = 0;
    } // constructor

    public int getLength() {
        return 7;
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
    } // insertItem
    // ADD CHECK FOR DUP

    public void deleteItem(ItemType item){
        NodeType temp = new NodeType();
        temp = head;
        while (temp.next != null) {
            System.out.println(temp.info.getValue());
            temp = temp.next;
        } // while
        System.out.println(temp.info.getValue());
    } // deleteItem

    public int searchItem(ItemType item) {
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

        return index;
/**
        if (index == this.getLength()) { // if at end or not present
            if (temp.info.compareTo(item) ==  0) { // at end
                return index;
            } else { // not present
                System.out.println("Item is not present in the list");
            } // if
            return 0;
        } else { // if present
            System.out.print("The item is present at index");
            return "This item is present at index" + index;
        } // if
        // returns index of item if present
        */
    } // searchItem
    // ADD CHECK FOR EMPTY LIST

} // SortedLinkedList
