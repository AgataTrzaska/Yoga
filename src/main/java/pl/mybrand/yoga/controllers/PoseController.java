package pl.mybrand.yoga.controllers;


import org.springframework.web.bind.annotation.*;
import pl.mybrand.yoga.models.Pose;
import pl.mybrand.yoga.models.dtos.PoseDto;
import pl.mybrand.yoga.services.PoseService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class PoseController {
    private PoseService poseService;

    public PoseController(PoseService poseService) {
        this.poseService = poseService;
    }

    @GetMapping("/poses")
    public List<Pose> getPoses() {
        return poseService.getPoses();
    }

    @PostMapping("/dto/poses")//to wyrzuca na serwer, bo ma ciało
    public Pose addPose(@RequestBody PoseDto poseDto) {
        return poseService.addPose(poseDto);
    }

    @PutMapping("/dto/poses")
    public void updatePose(@RequestBody PoseDto poseDto) {
        poseService.updatePose(poseDto);
    }

    @DeleteMapping("/dto/poses/{poseNameOne}")
    public void deletePose(@PathVariable String poseNameOne) {//PathVariable wyciąga ze ścieżki
        poseService.deletePose(poseNameOne);
    }

}
