package pl.mybrand.yoga.services;

import org.springframework.stereotype.Service;
import pl.mybrand.yoga.mappers.TagMapper;
import pl.mybrand.yoga.models.dtos.TagDto;
import pl.mybrand.yoga.repositories.TagRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TagService {

    private TagRepository tagRepository;
    private TagMapper tagMapper;

    public TagService(TagRepository tagRepository, TagMapper tagMapper) {
        this.tagRepository = tagRepository;
        this.tagMapper = tagMapper;
    }

    public List<TagDto> getTags() {
        return tagRepository
                .findAll()
                .stream()
                .map(tagMapper::map)
                .collect(Collectors.toList());
    }
}