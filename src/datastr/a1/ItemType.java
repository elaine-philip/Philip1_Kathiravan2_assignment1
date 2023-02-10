package datastr.a1;

public class ItemType {
    private int value;

    public int compareTo(ItemType item) {
        if (this.value == item.value) {
            return 0;
        } else if (this.value > item.value) {
            return 1;
        } else {
            return -1;
        } // if
    } // compareTo

    public int getValue() {
        return value;
    } // getValue

    public void initialize(int num) {
        this.value = num;
    } // initialize

} // ItemType
