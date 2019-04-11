package pl.mybrand.yoga.controllers;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mybrand.yoga.models.dtos.TagDto;
import pl.mybrand.yoga.services.TagService;

import java.util.List;

@RestController
@CrossOrigin
public class TagController {
    private TagService tagService;

    @GetMapping("/dto/tags")
    public List<TagDto> getTags() {
        return tagService.getTags();
    }
}
