package com.softsdu.keepup.bootstrap;

import com.softsdu.keepup.domain.Magazine;
import com.softsdu.keepup.domain.Subscription;
import com.softsdu.keepup.domain.SubscriptionStatus;
import com.softsdu.keepup.repository.MagazineRepository;
import com.softsdu.keepup.repository.SubscriptionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class BootStrapData implements CommandLineRunner {
    private final SubscriptionRepository subscriptionRepository;
    private final MagazineRepository magazineRepository;

    public BootStrapData(SubscriptionRepository subscriptionRepository, MagazineRepository magazineRepository) {
        this.subscriptionRepository = subscriptionRepository;
        this.magazineRepository = magazineRepository;
    }

    @Override
    public void run(String... args) throws Exception {


    }
}
