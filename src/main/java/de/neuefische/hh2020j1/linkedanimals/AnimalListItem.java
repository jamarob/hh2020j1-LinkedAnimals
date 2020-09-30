package de.neuefische.hh2020j1.linkedanimals;

public class AnimalListItem {

    private static AnimalListItem getLast(AnimalListItem item){
        return item.next == null ? item : getLast(item.next);
    }

    private Animal value;
    private AnimalListItem next;

    public AnimalListItem(){}

    public AnimalListItem(Animal value){
        this.value = value;
    }

    public Animal getValue() {
        return value;
    }

    public AnimalListItem getNext() {
        return next;
    }

    public void add(Animal animal) {
        if(value == null) {
            value = animal;
        }else{
            AnimalListItem lastItem = getLast(this);
            lastItem.next = new AnimalListItem(animal);
        }
    }

    @Override
    public String toString(){
        String result = value.toString();
        AnimalListItem nextItem = next;
        while(nextItem != null) {
            result += " -> "+nextItem.value;
            nextItem = nextItem.next;
        }
        return result;
    }

    public void removeAll(Animal animal) {
        while(value != null && value.equals(animal)){
            if(next != null) {
                value = next.value;
                next = next.next;
            }else {
                value = null;
            }
        }
        AnimalListItem listItem = this;
        while(listItem.next != null) {
            if(listItem.next.value.equals(animal)){
                listItem.next = listItem.next.next;
            }else{
                listItem = listItem.next;
            }
        }
    }
}
