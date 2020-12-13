package controller;

import model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.StorageService;

@Controller
public class StorageController {

    @Autowired
	StorageService storageService;

    @RequestMapping(value = "/getAllDepartments", method = RequestMethod.GET, headers = "Accept=application/json")
    public String getDepartments(Model model) {

        List<Department> listOfDepartments = storageService.getAllDepartments();
        model.addAttribute("department", new Department());
        model.addAttribute("listOfDepartments", listOfDepartments);
        return "departmentDetails";
    }

    @RequestMapping(value = "/getDepartment/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Department getDepartmentById(@PathVariable int id) {
        return storageService.getDepartment(id);
    }

    @RequestMapping(value = "/addDdepartment", method = RequestMethod.POST, headers = "Accept=application/json")
    public String addDepartment(@ModelAttribute("department") Department department) {
        if (department.getId() == 0) {
            storageService.addDepartment(department);
        } else {
            storageService.updateDepartment(department);
        }

        return "redirect:/getAllDepartments";
    }

    @RequestMapping(value = "/updateDepartment/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public String updateDepartment(@PathVariable("id") int id, Model model) {
        model.addAttribute("department", this.storageService.getDepartment(id));
        model.addAttribute("listOfDepartments", this.storageService.getAllDepartments());
        return "departmentDetails";
    }

    @RequestMapping(value = "/deleteDepartment/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public String deleteDepartment(@PathVariable("id") int id) {
        storageService.deleteDepartment(id);
        return "redirect:/getAllDepartments";

    }
}
