package de.neuefische.hh2020j1.linkedanimals;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalListItemTest {

    @Test
    void testAddOneAnimal() {
        AnimalListItem head = new AnimalListItem(new Animal("Capibara"));

        head.add(new Animal("Bird"));

        AnimalListItem actualListItem = head.getNext();

        assertNotNull(actualListItem);

        Animal actualAnimal = actualListItem.getValue();

        assertEquals(new Animal("Bird"), actualAnimal);
    }

    @Test
    void testAddTwoAnimals(){
        AnimalListItem head = new AnimalListItem(new Animal("Capibara"));

        head.add(new Animal("Bird"));
        head.add(new Animal("Aligator"));

        AnimalListItem secondListItem = head.getNext();

        assertNotNull(secondListItem);

        AnimalListItem thirdListItem = secondListItem.getNext();

        assertNotNull(thirdListItem);

        Animal actualAnimal = thirdListItem.getValue();

        assertEquals(new Animal("Aligator"), actualAnimal);
    }

    @Test
    void testToString(){
        AnimalListItem head = new AnimalListItem(new Animal("Capibara"));
        head.add(new Animal("Bird"));
        head.add(new Animal("Aligator"));

        String actual = head.toString();

        assertEquals("Capibara -> Bird -> Aligator", actual);
    }

    @Test
    void testRemoveAllButFirst(){
        AnimalListItem head = new AnimalListItem(new Animal("Bird"));
        head.add(new Animal("Capibara"));

        head.removeAll(new Animal("Capibara"));

        Animal actualAnimal = head.getValue();

        assertEquals(new Animal("Bird"), actualAnimal);

        AnimalListItem actualListItem = head.getNext();

        assertNull(actualListItem);
    }

    @Test
    void testRemoveAllIncludingFirst(){
        AnimalListItem head = new AnimalListItem(new Animal("Capibara"));
        head.add(new Animal("Bird"));
        head.add(new Animal("Capibara"));

        head.removeAll(new Animal("Capibara"));

        Animal actualAnimal = head.getValue();

        assertEquals(new Animal("Bird"), actualAnimal);

        AnimalListItem actualListItem = head.getNext();

        assertNull(actualListItem);
    }

    @Test
    void testAddElementToEmptyList(){
        AnimalListItem head = new AnimalListItem();

        head.add(new Animal("Capibara"));

        Animal actualAnimal = head.getValue();

        assertEquals(new Animal("Capibara"), actualAnimal);
        assertNull(head.getNext());
    }
}

