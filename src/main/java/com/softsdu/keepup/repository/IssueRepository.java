package com.softsdu.keepup.repository;

import java.util.List;

import com.softsdu.keepup.domain.Account;
import com.softsdu.keepup.domain.Issue;
import com.softsdu.keepup.domain.ReturnedStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IssueRepository extends JpaRepository<Issue, Long> {
	public List<Issue> findByReturned(ReturnedStatus returned);
	public Long countByAccountAndReturned(Account account, ReturnedStatus returned);
}
