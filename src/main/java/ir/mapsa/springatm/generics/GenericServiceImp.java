package ir.mapsa.springatm.generics;

import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

public abstract class GenericServiceImp<E, ID> implements IGenericService<E, ID> {

    protected abstract GenericRepository<E, ID> getRepository();

    @Override
    public void save(E entity) {
        getRepository().save(entity);
    }

    @Override
    public List<E> findAll() {
        return getRepository().findAll();
    }

    @Override
    public boolean existById(ID id) {
        return getRepository().existsById(id);
    }

    @Override
    public Optional<E> findById(ID id) {

        if (existById(id)) {
            return getRepository().findById(id);
        } else throw new NotFoundException("id not exist");

    }

    @Override
    public void deleteById(ID id) {
        if (existById(id)) {
            getRepository().deleteById(id);
        } else throw new NotFoundException("id not exist");

    }
}
