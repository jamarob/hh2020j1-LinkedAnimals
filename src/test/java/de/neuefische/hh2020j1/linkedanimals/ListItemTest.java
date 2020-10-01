package de.neuefische.hh2020j1.linkedanimals;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListItemTest {

    @Test
    void testAddOneAnimal() {
        ListItem<Animal> head = new ListItem(new Animal("Capibara"));

        head.add(new Animal("Bird"));

        ListItem<Animal> actualListItem = head.getNext();

        assertNotNull(actualListItem);

        Animal actualAnimal = actualListItem.getValue();

        assertEquals(new Animal("Bird"), actualAnimal);
    }

    @Test
    void testAddTwoAnimals(){
        ListItem<Animal> head = new ListItem(new Animal("Capibara"));

        head.add(new Animal("Bird"));
        head.add(new Animal("Aligator"));

        ListItem<Animal> secondListItem = head.getNext();

        assertNotNull(secondListItem);

        ListItem<Animal> thirdListItem = secondListItem.getNext();

        assertNotNull(thirdListItem);

        Animal actualAnimal = thirdListItem.getValue();

        assertEquals(new Animal("Aligator"), actualAnimal);
    }

    @Test
    void testToString(){
        ListItem<Animal> head = new ListItem(new Animal("Capibara"));
        head.add(new Animal("Bird"));
        head.add(new Animal("Aligator"));

        String actual = head.toString();

        assertEquals("Capibara -> Bird -> Aligator", actual);
    }

    @Test
    void testRemoveAllButFirst(){
        ListItem<Animal> head = new ListItem(new Animal("Bird"));
        head.add(new Animal("Capibara"));

        head.removeAll(new Animal("Capibara"));

        Animal actualAnimal = head.getValue();

        assertEquals(new Animal("Bird"), actualAnimal);

        ListItem actualListItem = head.getNext();

        assertNull(actualListItem);
    }

    @Test
    void testRemoveAllIncludingFirst(){
        ListItem<Animal> head = new ListItem(new Animal("Capibara"));
        head.add(new Animal("Bird"));
        head.add(new Animal("Capibara"));

        head.removeAll(new Animal("Capibara"));

        Animal actualAnimal = head.getValue();

        assertEquals(new Animal("Bird"), actualAnimal);

        ListItem<Animal> actualListItem = head.getNext();

        assertNull(actualListItem);
    }

    @Test
    void testAddElementToEmptyList(){
        ListItem<Animal> head = new ListItem();

        head.add(new Animal("Capibara"));

        Animal actualAnimal = head.getValue();

        assertEquals(new Animal("Capibara"), actualAnimal);
        assertNull(head.getNext());
    }
}

