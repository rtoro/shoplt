package com.atomic.shoplt.repository;

import com.atomic.shoplt.domain.UserApp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the User entity.
 */
@Repository
public interface UserRepository extends CrudRepository<UserApp, Long>
{

	String USERS_BY_LOGIN_CACHE = "usersByLogin";

	String USERS_BY_EMAIL_CACHE = "usersByEmail";

	Optional<UserApp> findOneByActivationKey(String activationKey);

	List<UserApp> findAllByActivatedIsFalseAndCreatedDateBefore(Instant dateTime);

	Optional<UserApp> findOneByResetKey(String resetKey);

	Optional<UserApp> findOneByEmailIgnoreCase(String email);

	Optional<UserApp> findOneByLogin(String login);

	@EntityGraph(attributePaths = "authorities")
	Optional<UserApp> findOneWithAuthoritiesById(Long id);

	@EntityGraph(attributePaths = "authorities")
	@Cacheable(cacheNames = USERS_BY_LOGIN_CACHE)
	Optional<UserApp> findOneWithAuthoritiesByLogin(String login);

	@EntityGraph(attributePaths = "authorities")
	@Cacheable(cacheNames = USERS_BY_EMAIL_CACHE)
	Optional<UserApp> findOneWithAuthoritiesByEmail(String email);

	Page<UserApp> findAllByLoginNot(Pageable pageable, String login);

	Iterable<UserApp> findAll(Sort sort);

	Page<UserApp> findAll(Pageable pageable);
}
