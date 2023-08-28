package mcgurbuz.springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import mcgurbuz.springframework.sfgpetclinic.model.*;

public interface VisitRepository extends CrudRepository<Visit,Long> {
}
