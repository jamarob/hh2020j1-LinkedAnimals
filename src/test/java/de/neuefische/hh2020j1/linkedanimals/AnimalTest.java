package de.neuefische.hh2020j1.linkedanimals;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    @Test
    void testToString(){
        Animal animal = new Animal("Capibara");

        String actual = animal.toString();

        assertEquals("Capibara", actual);
    }

}