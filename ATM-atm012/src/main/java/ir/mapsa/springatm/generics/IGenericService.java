package ir.mapsa.springatm.generics;

import java.util.List;
import java.util.Optional;

public interface IGenericService<E, ID> {

    void save(E entity);

    List<E> findAll();

    boolean existById(ID id);

    Optional<E> findById(ID id);

    void deleteById(ID id);

}
