package vn.edu.iuh.fit.frontEnd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.backEnd.models.Company;
import vn.edu.iuh.fit.backEnd.services.CompanyService;

@Controller
@RequestMapping("/companies")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping
    public String getAllCompanies(Model model) {
        model.addAttribute("companies", companyService.getAllCompanies());
        return "company-list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("company", new Company());
        return "create-company";
    }

    @PostMapping("/save")
    public String saveCompany(@ModelAttribute Company company) {
        companyService.createCompany(company);
        return "redirect:/companies";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Company company = companyService.getCompanyById(id);
        model.addAttribute("company", company);
        return "update-company";
    }

    @PostMapping("/update/{id}")
    public String updateCompany(@PathVariable("id") long id, @ModelAttribute Company company) {
        companyService.updateCompany(id, company);
        return "redirect:/companies";
    }

    @GetMapping("/delete/{id}")
    public String deleteCompany(@PathVariable("id") long id) {
        companyService.deleteCompany(id);
        return "redirect:/companies";
    }
}