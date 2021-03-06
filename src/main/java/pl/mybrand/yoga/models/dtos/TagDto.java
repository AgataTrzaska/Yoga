package pl.mybrand.yoga.models.dtos;

import lombok.Builder;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Builder
public class TagDto {

    private String title;
    private Set<String> poses = new HashSet<>();

}