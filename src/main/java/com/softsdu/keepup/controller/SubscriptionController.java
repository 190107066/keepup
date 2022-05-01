package com.softsdu.keepup.controller;

import com.softsdu.keepup.domain.Subscription;
import com.softsdu.keepup.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/subscription")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    @RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
    public String showCategoriesPage(Model model) {
        model.addAttribute("subscriptions", subscriptionService.getAll());
        return "/subscription/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addCategoryPage(Model model) {
        model.addAttribute("subscription", new Subscription());
        return "/subscription/form";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editCategoryPage(@PathVariable(name = "id") Long id, Model model) {
        Subscription subscription = subscriptionService.get(id);
        if( subscription != null ) {
            model.addAttribute("subscription", subscription);
            return "/subscription/form";
        } else {
            return "redirect:/subscription/add";
        }
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCategory( Subscription subscription, BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
        if( bindingResult.hasErrors() ) {
            return "/subscription/form";
        }

        if( subscription.getId() == null ) {
            subscriptionService.addNew(subscription);
            redirectAttributes.addFlashAttribute("successMsg", "'" + subscription.getTitle() + "' is added as a new category.");
            return "redirect:/subscription/add";
        } else {
            Subscription updateCategory = subscriptionService.save( subscription );
            redirectAttributes.addFlashAttribute("successMsg", "Changes for '" + subscription.getTitle() + "' are saved successfully. ");
            return "redirect:/subscription/edit/"+updateCategory.getId();
        }
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public String removeCategory(@PathVariable(name = "id") Long id, Model model) {
        Subscription subscription = subscriptionService.get( id );
        if( subscription != null ) {
//            if( subscriptionService.hasUsage(category) ) {
//                model.addAttribute("categoryInUse", true);
//                return showCategoriesPage(model);
//            } else {
                subscriptionService.delete(id);
//            }
        }
        return "redirect:/subscription/list";
    }

}

