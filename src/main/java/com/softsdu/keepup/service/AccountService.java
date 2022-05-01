package com.softsdu.keepup.service;

import java.util.Date;
import java.util.List;

import com.softsdu.keepup.domain.Account;
import com.softsdu.keepup.domain.Role;
import com.softsdu.keepup.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;


    public Long getTotalCount() {
        return accountRepository.count();
    }

    public Long getWorkerCount() {
        return accountRepository.countByRole(Role.WORKER);
}

    public Long getLibrarianCount() {
        return accountRepository.countByRole(Role.LIBRARIAN);
    }

    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    public Account get(Long id) {
        return accountRepository.findById(id).get();
    }

    public Account addNew(Account account) {
        return accountRepository.save( account );
    }

    public Account save(Account account) {
        return accountRepository.save( account );
    }

    public void delete(Account account) {
        accountRepository.delete(account);
    }

    public void delete(Long id) {
        accountRepository.deleteById(id);
    }

}