package pl.mybrand.yoga.controllers;

import org.hibernate.Filter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.query.Query;
import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.mybrand.yoga.models.Pose;
import pl.mybrand.yoga.models.dtos.PoseDto;
import pl.mybrand.yoga.repositories.PoseRepository;
import pl.mybrand.yoga.services.PoseService;
import org.hibernate.SessionFactory;

import java.sql.ResultSet;
import java.util.Iterator;
import java.util.List;

@Controller
@CrossOrigin
public class HomeController {



    private PoseService poseService;
    private PoseRepository poseRepository;

    public HomeController(PoseService poseService) {
        this.poseService = poseService;
    }

    @GetMapping("/")
    public String getHomePage(Model model){
        SecurityContext context = SecurityContextHolder.getContext();
        model.addAttribute("message", "loged in as: "
                + context.getAuthentication().getName());
        System.out.println(context.getAuthentication().getPrincipal());
        model.addAttribute("poses", poseService.getPosesDto());
        return"index";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/poses")
    public String homePage(Model model){
        model.addAttribute("poses", poseService.getPosesDto());
        return "poses";
    }

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/delete")
    public String deletePose(@RequestParam(value = "poses") String poseNameOne) {
        poseService.deletePose(poseNameOne);
        return "redirect:/poses";
    }

@PostMapping("/add")
public String addPose(@ModelAttribute PoseDto poseDto){
 poseService.addPose(poseDto);
 return "redirect:/poses";
}

@GetMapping("/addfav")
    public String addPose(@RequestParam int check){
      System.out.println(check);
        return "index";
}

//@GetMapping("/random")

//}
}
    //@GetMapping("/addfav")
    //public String addPose(@RequestParam boolean check){

       // System.out.println(check);

    //    poseService.addPose(poseDto);
       // return "redirect:/poses";
    //}

    //@RequestMapping("/randompose")
    //public String randomPose(@RequestParam int id){

//}
