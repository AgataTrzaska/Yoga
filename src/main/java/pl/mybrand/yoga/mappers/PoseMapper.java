package pl.mybrand.yoga.mappers;

import org.springframework.stereotype.Component;
import pl.mybrand.yoga.commons.Mapper;
import pl.mybrand.yoga.models.Pose;
import pl.mybrand.yoga.models.Tag;
import pl.mybrand.yoga.models.dtos.PoseDto;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class PoseMapper implements Mapper<Pose, PoseDto> {

    @Override
    public PoseDto map(Pose f) {

        List<String> tags = f
                .getTags()
                .stream()
                .map(TagsToStringsList.INSTANCE)
                .collect(Collectors.toList());

        return PoseDto
                .builder()
                .poseImage(f.getPoseImage())
                .poseNameOne(f.getPoseNameOne())
                .poseNameTwo(f.getPoseNameTwo())
                .poseLevel(f.getPoseLevel())
                .poseType(f.getPoseType())
                .poseTherapeutic(f.getPoseTherapeutic())
                .poseBenefits(f.getPoseBenefits())
                .poseContraindications(f.getPoseContraindications())
                .poseFavorite(f.getPoseFavorite())
                .poseAdd(f.getPoseAdd())
                .tags(tags)
                .build();
    }

    @Override
    public Pose reverse(PoseDto to) {//żeby móc dodawać samemu planety
        return Pose
                .builder()
                .poseImage(to.getPoseImage())
                .poseNameOne(to.getPoseNameOne())
                .poseNameTwo(to.getPoseNameTwo())
                .poseLevel(to.getPoseLevel())
                .poseType(to.getPoseType())
                .poseTherapeutic(to.getPoseTherapeutic())
                .poseBenefits(to.getPoseBenefits())
                .poseContraindications(to.getPoseContraindications())
                .poseFavorite(to.getPoseFavorite())
                .poseAdd(to.getPoseAdd())
                .build();
    }

    private enum TagsToStringsList implements Function<Tag, String> {
        INSTANCE;

        @Override
        public String apply(Tag tag) {
            return null;
        }
    }
}
