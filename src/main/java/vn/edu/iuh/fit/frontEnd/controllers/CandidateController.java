package vn.edu.iuh.fit.frontEnd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.backEnd.models.Candidate;
import vn.edu.iuh.fit.backEnd.services.CandidateService;
import vn.edu.iuh.fit.backEnd.services.JobRecommendationService;
import vn.edu.iuh.fit.backEnd.services.SkillService;

import java.util.List;

@Controller
@RequestMapping("/candidates")
public class CandidateController {
    @Autowired
    private CandidateService candidateService;
    @Autowired
    private JobRecommendationService jobRecommendationService;
    @Autowired
    private SkillService skillService;

    @GetMapping
    public String getAllCandidates(Model model) {
        List<Candidate> candidates = candidateService.getAllCandidates();
        model.addAttribute("candidates", candidates);
        return "candidate-list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("candidate", new Candidate());
        return "create-candidate";
    }

    @PostMapping("/save")
    public String saveCandidate(@ModelAttribute Candidate candidate) {
        candidateService.createCandidate(candidate);
        return "redirect:/candidates";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Candidate candidate = candidateService.getCandidateById(id);
        model.addAttribute("candidate", candidate);
        return "update-candidate";
    }

    @PostMapping("/update/{id}")
    public String updateCandidate(@PathVariable("id") long id, @ModelAttribute Candidate candidate) {
        candidateService.updateCandidate(id, candidate);
        return "redirect:/candidates";
    }

    @GetMapping("/delete/{id}")
    public String deleteCandidate(@PathVariable("id") long id) {
        candidateService.deleteCandidate(id);
        return "redirect:/candidates";
    }
    @GetMapping("/recommendations/{id}")
    public String showJobRecommendations(@PathVariable("id") long id, Model model) {
        model.addAttribute("jobs", jobRecommendationService.recommendJobsForCandidate(id));
        return "job-recommendations";
    }

    @GetMapping("/skills/{id}")
    public String showSkillRecommendations(@PathVariable("id") long id, Model model) {
        model.addAttribute("skills", skillService.recommendSkillsForCandidate(id));
        return "skill-recommendations";
    }
}