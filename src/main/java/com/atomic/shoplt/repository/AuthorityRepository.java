package com.atomic.shoplt.repository;

import com.atomic.shoplt.domain.Authority;
import org.springframework.data.repository.CrudRepository;

/**
 * Spring Data JPA repository for the Authority entity.
 */
public interface AuthorityRepository extends CrudRepository<Authority, String> {
}
