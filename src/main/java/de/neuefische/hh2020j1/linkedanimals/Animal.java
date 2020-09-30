package de.neuefische.hh2020j1.linkedanimals;

import java.util.Objects;

public class Animal {

    private String species;

    public Animal(String species) {
        this.species = species;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(species, animal.species);
    }

    @Override
    public int hashCode() {
        return Objects.hash(species);
    }

    @Override
    public String toString(){
        return species;
    }

}
