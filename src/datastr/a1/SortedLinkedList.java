package datastr.a1;

public class SortedLinkedList {
    private NodeType head;
    private NodeType currentPos;
    private int length;

//    private NodeType predloc;
//    private NodeType location;

    public SortedLinkedList() {
        head = null;
        currentPos = head;
        length = 0;
    } // constructor

    public int getLength() {
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

} // SortedLinkedList
