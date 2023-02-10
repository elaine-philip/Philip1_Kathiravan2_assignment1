package datastr.a1;

public class SortedLinkedList {
    private NodeType head;
    private NodeType currentPos;
    private int length;

    private NodeType predloc;
    private NodeType location;

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

        if (head == null) {
            node.info = item;
//            node.next = head;
            predloc = head;
            location = head;
            head = node;
        }  else {
            predloc = null;
            location = head;
            while (item.compareTo(location.info) >= 0) {
                predloc = location;
                location = location.next;
            } // while
            predloc.next = node;
            node.next = location;
        } // if

    } // insertItem

    public void deleteItem(ItemType item){

    } // deleteItem

} // SortedLinkedList
