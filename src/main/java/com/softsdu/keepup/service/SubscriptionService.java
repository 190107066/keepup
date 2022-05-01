package com.softsdu.keepup.service;

import com.softsdu.keepup.domain.Subscription;
import com.softsdu.keepup.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    public Long getTotalCount() {
        return subscriptionRepository.count();
    }


    public List<Subscription> getAll() {
        return subscriptionRepository.findAll();
    }

    public Subscription get(Long id) {
        return subscriptionRepository.findById(id).get();
    }

    public Subscription addNew(Subscription category) {
        return subscriptionRepository.save(category);
    }

    public Subscription save(Subscription category) {
        return subscriptionRepository.save(category);
    }

    public void delete(Subscription category) {
        subscriptionRepository.delete(category);
    }

    public void delete(Long id) {
        subscriptionRepository.deleteById(id);
    }

//    public boolean hasUsage(Subscription category) {
//        return category.getBooks().size()>0;
//    }
}
