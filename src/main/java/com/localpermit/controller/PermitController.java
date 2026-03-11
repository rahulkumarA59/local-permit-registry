package com.localpermit.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.localpermit.dto.PermitFilterDto;
import com.localpermit.entity.Permit;
import com.localpermit.entity.PermitType;
import com.localpermit.entity.Status;
import com.localpermit.service.PermitService;

@Controller
@RequestMapping("/permits")
public class PermitController {

    @Autowired
    private PermitService permitService;

    // List permits with filters
    @GetMapping
    public String listPermits(@ModelAttribute PermitFilterDto filter, Model model) {
        List<Permit> permits = permitService.findAllFiltered(filter);
        model.addAttribute("permits", permits);
        model.addAttribute("filter", filter);
        model.addAttribute("permitTypes", PermitType.values());
        model.addAttribute("statuses", Status.values());
        return "permitList";
    }

    // Show add form
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("permit", new Permit());
        model.addAttribute("permitTypes", PermitType.values());
        model.addAttribute("statuses", Status.values());
        return "addPermit";
    }

    // Save new permit
    @PostMapping
    public String savePermit(@ModelAttribute Permit permit) {
        permitService.save(permit);
        return "redirect:/permits/dashboard";
    }

    // Show edit form
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Permit permit = permitService.findById(id);
        if (permit == null) {
            return "redirect:/permits";
        }
        model.addAttribute("permit", permit);
        model.addAttribute("permitTypes", PermitType.values());
        model.addAttribute("statuses", Status.values());
        return "editPermit";
    }

    // Update permit
    @PostMapping("/edit/{id}")
    public String updatePermit(@PathVariable Long id, @ModelAttribute Permit permit) {
        permit.setId(id);
        permitService.save(permit);
        return "redirect:/permits/dashboard";
    }

    // Delete permit
    @GetMapping("/delete/{id}")
    public String deletePermit(@PathVariable Long id) {
        permitService.deleteById(id);
        return "redirect:/permits/dashboard";
    }

    // View details
    @GetMapping("/{id}")
    public String viewPermit(@PathVariable Long id, Model model) {
        Permit permit = permitService.findById(id);
        if (permit == null) {
            return "redirect:/permits";
        }
        model.addAttribute("permit", permit);
        return "permitDetails";
    }

    // Dashboard
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        Map<String, Map<String, Long>> dashboardData = permitService.getDashboardData();
        model.addAttribute("dashboardData", dashboardData);
        model.addAttribute("permitTypes", Arrays.stream(PermitType.values()).map(Enum::name).collect(Collectors.toList()));
        model.addAttribute("statuses", Arrays.stream(Status.values()).map(Enum::name).collect(Collectors.toList()));
        return "statusDashboard";
    }
}
