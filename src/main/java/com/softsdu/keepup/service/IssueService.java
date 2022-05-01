package com.softsdu.keepup.service;

import java.util.Date;
import java.util.List;

import com.softsdu.keepup.domain.Account;
import com.softsdu.keepup.domain.Issue;
import com.softsdu.keepup.domain.ReturnedStatus;
import com.softsdu.keepup.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class IssueService {

	@Autowired
	private IssueRepository issueRepository;
	
	public List<Issue> getAll() {
		return issueRepository.findAll();
	}
	
	public Issue get(Long id) {
		return issueRepository.findById(id).get();
	}
	
	public List<Issue> getAllUnreturned() {
		return issueRepository.findByReturned(ReturnedStatus.NOT_RETURNED);
	}
	
	public Issue addNew(Issue issue) {
		issue.setIssueDate( new Date() );
		issue.setReturned( ReturnedStatus.NOT_RETURNED );
		return issueRepository.save(issue);
	}
	
	public Issue save(Issue issue) {
		return issueRepository.save(issue);
	}
	
	public Long getCountByAccount(Account account) {
		return issueRepository.countByAccountAndReturned(account, ReturnedStatus.NOT_RETURNED);
	}
}
