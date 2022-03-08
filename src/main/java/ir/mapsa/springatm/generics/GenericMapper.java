package ir.mapsa.springatm.generics;

import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

public interface GenericMapper<E, D> {

    E toEntity(D dto);

    D toDto(E entity);

    List<E> toEntities(List<D> dtoes);

    List<D> toDtoes(List<E> entites);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void update(@MappingTarget E entity, D dto);


}
