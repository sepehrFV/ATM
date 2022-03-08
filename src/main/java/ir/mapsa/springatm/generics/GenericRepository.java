package ir.mapsa.springatm.generics;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.List;

@NoRepositoryBean
public interface GenericRepository<E, ID> extends PagingAndSortingRepository<E, ID>, JpaRepository<E, ID> {

    List<E> findAll();

}
