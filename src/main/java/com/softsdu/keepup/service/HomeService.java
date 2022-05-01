package com.softsdu.keepup.service;

import java.util.HashMap;
import java.util.Map;

import com.softsdu.keepup.service.AccountService;
import com.softsdu.keepup.service.MagazineService;
import com.softsdu.keepup.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeService {

	@Autowired
	private AccountService accountService;

	@Autowired
	private SubscriptionService subscriptionService;

	@Autowired
	private MagazineService magazineService;

	public Map<String, Long> getTopTilesMap() {
		Map<String, Long> map = new HashMap<String, Long>();
		map.put("totalAccounts", accountService.getTotalCount());
		map.put("totalWorkers", accountService.getWorkerCount());
		map.put("totalLibrarians", accountService.getLibrarianCount());
		map.put("totalSubscriptions", subscriptionService.getTotalCount());
		map.put("totalMagazines", magazineService.getTotalCount());
		map.put("totalIssuedMagazines", magazineService.getTotalBorrowedMagazines());
		return map;
	}

}