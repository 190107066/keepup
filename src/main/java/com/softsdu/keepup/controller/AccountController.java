package com.softsdu.keepup.controller;

import java.util.Arrays;
import java.util.List;


import com.softsdu.keepup.domain.Account;
import com.softsdu.keepup.domain.Role;
import com.softsdu.keepup.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @ModelAttribute(name = "accountRole")
    public List<Role> accountRole() {
        return Arrays.asList(Role.values());
    }

    @RequestMapping(value = {"/", "/list"},  method = RequestMethod.GET)
    public String showAccountsPage(Model model) {
        System.out.println(accountService.getAll());
        model.addAttribute("accounts", accountService.getAll());
        return "/account/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addAccountPage(Model model) {
        model.addAttribute("account", new Account());
        return "/account/form";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editAccountPage(@PathVariable(name = "id") Long id, Model model) {
        Account account = accountService.get( id );
        if( account != null ) {
            model.addAttribute("account", account);
            return "/account/form";
        } else {
            return "redirect:/account/add";
        }
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveAccount(Account account, BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
        if( bindingResult.hasErrors() ) {
            return "/account/form";
        }

        if( account.getId() == null ) {
            accountService.addNew(account);
            redirectAttributes.addFlashAttribute("successMsg", "'" + account.getEmail()+ " ' is added as a new member.");
            return "redirect:/account/add";
        } else {
            Account updatedAccount = accountService.save( account );
            redirectAttributes.addFlashAttribute("successMsg", "Changes for '" + account.getEmail() + " ' are saved successfully. ");
            return "redirect:/account/edit/" + updatedAccount.getId();
        }
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public String removeAccount(@PathVariable(name = "id") Long id, Model model) {
        Account account = accountService.get( id );
        if( account != null ) {
            accountService.delete(id);
        }
        return "redirect:/account/list";
    }
}
