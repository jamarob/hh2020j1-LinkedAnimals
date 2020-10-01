package de.neuefische.hh2020j1.linkedanimals;

public class ListItem<T> {

    private static ListItem getLast(ListItem item){
        return item.next == null ? item : getLast(item.next);
    }

    private T value;
    private ListItem<T> next;

    public ListItem(){}

    public ListItem(T value){
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public ListItem getNext() {
        return next;
    }

    public void add(T value) {
        if(this.value == null) {
            this.value = value;
        }else{
            ListItem lastItem = getLast(this);
            lastItem.next = new ListItem(value);
        }
    }

    @Override
    public String toString(){
        String result = value.toString();
        ListItem nextItem = next;
        while(nextItem != null) {
            result += " -> "+nextItem.value;
            nextItem = nextItem.next;
        }
        return result;
    }

    public void removeAll(T value) {
        while(this.value != null && this.value.equals(value)){
            if(next != null) {
                this.value = next.value;
                next = next.next;
            }else {
                this.value = null;
            }
        }
        ListItem listItem = this;
        while(listItem.next != null) {
            if(listItem.next.value.equals(value)){
                listItem.next = listItem.next.next;
            }else{
                listItem = listItem.next;
            }
        }
    }
}
