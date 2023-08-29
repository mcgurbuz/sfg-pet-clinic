package mcgurbuz.springframework.sfgpetclinic.services.map;

import mcgurbuz.springframework.sfgpetclinic.model.Owner;
import mcgurbuz.springframework.sfgpetclinic.services.*;
import mcgurbuz.springframework.sfgpetclinic.model.*;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerMapService extends AbstractMapService<Owner,Long> implements OwnerService{

    private final PetServiceType petServiceType;
    private final PetService petService;

    public OwnerMapService(PetServiceType petServiceType, PetService petService) {
        this.petServiceType = petServiceType;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner save(Owner object) {

        Owner savedOwner = null;
        if(object!=null)
        {
            if(object.getPets() !=null){
                object.getPets().forEach(pet -> {
                    if(pet.getPetType()!=null){
                        if(pet.getPetType().getId()==null){
                            pet.setPetType(petServiceType.save(pet.getPetType()));
                        }
                    }else
                    {
                        throw new RuntimeException("Pet Type is Required");
                    }

                    if(pet.getId()==null){
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(object);
        }else
        {
            return null;
        }




    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}