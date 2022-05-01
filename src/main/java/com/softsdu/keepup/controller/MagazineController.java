package com.softsdu.keepup.controller;

import java.util.List;
import com.softsdu.keepup.domain.Magazine;
import com.softsdu.keepup.service.MagazineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping(value = "/magazine")
public class MagazineController {

    @Autowired
    private MagazineService magazineService;

    @RequestMapping(value = {"", "/list"}, method = RequestMethod.GET)
    public String showBooksPage(Model model) {
        model.addAttribute("magazines", magazineService.getAll());
        return "/magazine/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addBookPage(Model model) {
        model.addAttribute("magazine", new Magazine());
        return "/magazine/form";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editBookPage(@PathVariable(name = "id") Long id,  Model model) {
        Magazine magazine = magazineService.get(id);
        if( magazine != null ) {
            model.addAttribute("magazine", magazine);
            return "/magazine/form";
        } else {
            return "redirect:/magazine/add";
        }
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveBook(Magazine magazine, BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
        if( bindingResult.hasErrors() ) {
            return "/magazine/form";
        }

        if( magazine.getId() == null ) {
            if( magazineService.getByName(magazine.getName()) != null ) {
                bindingResult.rejectValue("name", "name", "Name already exists");
                return "/magazine/form";
            } else {
                magazineService.addNew(magazine);
                redirectAttributes.addFlashAttribute("successMsg", "'" + magazine.getName() + "' is added as a new Book.");
                return "redirect:/magazine/add";
            }
        } else {
            Magazine updatedMagazine = magazineService.save(magazine);
            redirectAttributes.addFlashAttribute("successMsg", "Changes for '" + magazine.getName() + "' are saved successfully. ");
            return "redirect:/magazine/edit/"+updatedMagazine.getId();
        }
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public String removeBook(@PathVariable(name = "id") Long id, Model model) {
        Magazine book = magazineService.get( id );
        if( book != null ) {
            if( magazineService.isTaken(book) ) {
                model.addAttribute("bookInUse", true);
                return showBooksPage(model);
            } else {
                magazineService.delete(id);
            }
        }
        return "redirect:/magazine/list";
    }
}
