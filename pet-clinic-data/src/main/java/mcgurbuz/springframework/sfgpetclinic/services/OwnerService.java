package mcgurbuz.springframework.sfgpetclinic.services;

import mcgurbuz.springframework.sfgpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService <Owner, Long>{

    Owner findByLastName(String lastName);
}
