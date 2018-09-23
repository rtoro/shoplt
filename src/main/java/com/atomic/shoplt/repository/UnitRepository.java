package com.atomic.shoplt.repository;

import com.atomic.shoplt.domain.Unit;
import org.springframework.data.repository.CrudRepository;

/**
 * Spring Data JPA repository for the Authority entity.
 */
public interface UnitRepository extends CrudRepository<Unit, String> {
}
