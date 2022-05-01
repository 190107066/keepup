package com.softsdu.keepup.repository;

import com.softsdu.keepup.domain.Account;
import com.softsdu.keepup.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Long countByRole(Role role);
}
