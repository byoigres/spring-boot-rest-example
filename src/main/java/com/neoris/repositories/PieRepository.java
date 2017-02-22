package com.neoris.repositories;

import com.neoris.models.Pie;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

/**
 * Created by sergio.angulo on 22/02/2017.
 */

public interface PieRepository extends CrudRepository<Pie, Long> {
    List<Pie> findByName(String name);
}
