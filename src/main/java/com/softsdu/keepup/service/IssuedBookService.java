package com.softsdu.keepup.service;

import java.util.List;

import com.softsdu.keepup.domain.IssuedBook;
import com.softsdu.keepup.domain.Magazine;
import com.softsdu.keepup.domain.ReturnedStatus;
import com.softsdu.keepup.repository.IssuedMagazineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IssuedBookService {

	@Autowired
	private IssuedMagazineRepository issuedMagazineRepository;
	
	public List<IssuedBook> getAll() {
		return issuedMagazineRepository.findAll();
	}
	
	public IssuedBook get(Long id) {
		return issuedMagazineRepository.findById(id).get();
	}
	
	public Long getCountByBook(Magazine magazine) {
		return issuedMagazineRepository.countByMagazineAndReturned(magazine, ReturnedStatus.NOT_RETURNED);
	}
	
	public IssuedBook save(IssuedBook issuedBook) {
		return issuedMagazineRepository.save(issuedBook);
	}
	
	public IssuedBook addNew(IssuedBook issuedBook) {
		issuedBook.setReturned( ReturnedStatus.NOT_RETURNED );
		return issuedMagazineRepository.save(issuedBook);
	}

}
