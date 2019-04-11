package pl.mybrand.yoga.mappers;

import org.springframework.stereotype.Component;
import pl.mybrand.yoga.commons.Mapper;
import pl.mybrand.yoga.models.Pose;
import pl.mybrand.yoga.models.Tag;
import pl.mybrand.yoga.models.dtos.TagDto;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class TagMapper implements Mapper<Tag, TagDto> {

    @Override
    public TagDto map(Tag from) {

        Set<String> poses = from
                .getPoses()
                .stream()
                .map(PosesToStrings.INSTANCE)
                .collect(Collectors.toSet());

        return TagDto
                .builder()
                .title(from.getTitle())
                .poses(poses)
                .build();
    }

    @Override
    public Tag reverse(TagDto to) {

        return null;
    }

    private enum PosesToStrings implements Function<Pose, String> {
        INSTANCE;

        @Override
        public String apply(Pose pose){
            return pose.getPoseNameOne();
        }
    }
}