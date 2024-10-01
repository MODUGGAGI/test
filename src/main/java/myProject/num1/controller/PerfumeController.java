package myProject.num1.controller;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import myProject.num1.item.Perfume;
import myProject.num1.repository.PerfumeSearchCond;
import myProject.num1.repository.UpdatePerfume;
import myProject.num1.service.PerfumeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("/basic/perfumes")
@RequiredArgsConstructor
public class PerfumeController {

    private final PerfumeService perfumeService;

    @GetMapping
    public String perfumes(@ModelAttribute("perfumeSearch") PerfumeSearchCond perfumeSearch, Model model) {
        List<Perfume> perfumes = perfumeService.findItems(perfumeSearch);
        model.addAttribute("perfumes", perfumes);
        return "/basic/perfumes";
    }

    @GetMapping("/{perfumeId}")
    public String perfume(@PathVariable long perfumeId, Model model) {
        Perfume perfume = perfumeService.findById(perfumeId).get();
        model.addAttribute("perfume", perfume);
        return "/basic/perfume";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("perfume", new Perfume());
        return "/basic/addForm";
    }

    @PostMapping("/add")
    public String addPerfume(Perfume perfume, RedirectAttributes redirectAttributes) {
        Perfume savedPerfume = perfumeService.save(perfume);

        redirectAttributes.addAttribute("perfumeId", savedPerfume.getId());
        redirectAttributes.addAttribute("status", true);

        return "redirect:/basic/perfumes/{perfumeId}";
        //새로 고침 시 계속해서 중복 등록이 되는 것을 막기위해 redirect:/ 사용
    }

    @GetMapping("/{perfumeId}/edit")
    public String editForm(@PathVariable long perfumeId, Model model) {
        Perfume perfume = perfumeService.findById(perfumeId).get();
        model.addAttribute("perfume", perfume);

        return "/basic/editForm";
    }

    @PostMapping("/{perfumeId}/edit")
    public String editPerfume(@PathVariable long perfumeId, UpdatePerfume updatePerfume) {
        perfumeService.update(perfumeId, updatePerfume);

        return "redirect:/basic/perfumes/{perfumeId}";
        //새로 고침 시 계속해서 중복 등록이 되는것을 막기 위해서 redirect: 사용
    }
}
