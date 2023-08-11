package mcgurbuz.springframework.sfgpetclinic.model;

import mcgurbuz.springframework.sfgpetclinic.model.Person;

import java.util.Set;

public class Owner extends Person{
    private Set<Pet> pets;

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }
}
