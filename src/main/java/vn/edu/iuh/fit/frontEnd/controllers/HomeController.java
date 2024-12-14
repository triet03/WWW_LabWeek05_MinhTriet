package vn.edu.iuh.fit.frontEnd.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String index() {
        return "index";
    }

    @GetMapping("/add-candidate-skill")
    public String addCandidateSkill(Model model) {
        // Thêm dữ liệu mẫu để truyền sang view (nếu cần)
        model.addAttribute("candidates", List.of());
        model.addAttribute("skills", List.of());
        return "add-candidate-skill"; // Tên file HTML trang "Thêm Kỹ Năng Ứng Viên"
    }
}
