package com.softsdu.keepup.repository;

import com.softsdu.keepup.domain.IssuedBook;
import com.softsdu.keepup.domain.Magazine;
import com.softsdu.keepup.domain.ReturnedStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IssuedMagazineRepository extends JpaRepository<IssuedBook, Long> {
	Long countByMagazineAndReturned(Magazine magazine, ReturnedStatus returned);
}
