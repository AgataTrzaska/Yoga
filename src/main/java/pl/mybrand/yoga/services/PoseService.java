package pl.mybrand.yoga.services;

import org.springframework.stereotype.Service;
import pl.mybrand.yoga.mappers.PoseMapper;
import pl.mybrand.yoga.models.Pose;
import pl.mybrand.yoga.models.dtos.PoseDto;
import pl.mybrand.yoga.repositories.PoseRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PoseService {

    private PoseRepository poseRepository;
    private PoseMapper poseMapper;

    public PoseService(PoseRepository poseRepository, PoseMapper poseMapper) {
        this.poseRepository = poseRepository;
        this.poseMapper = poseMapper;
    }
    public List<Pose> getPoses() {
        return poseRepository.findAll();
    }

    public List<PoseDto> getPosesDto() {

        return poseRepository
                .findAll()
                .stream()
                .map(poseMapper::map)
                .collect(Collectors.toList());
    }

    public Pose addPose(PoseDto poseDto) {
        return poseRepository.save(poseMapper.reverse(poseDto));
    }

    public void deletePose(String poseNameOne) {
        poseRepository.deleteByPoseNameOne(poseNameOne);
    }

    public void updatePose(PoseDto poseDto) {
        poseRepository
                .findByPoseNameOne(poseDto.getPoseNameOne())
                .ifPresent(p -> {
                    p.setPoseImage(poseDto.getPoseImage());
                    p.setPoseNameTwo(poseDto.getPoseNameTwo());
                    p.setPoseLevel(poseDto.getPoseLevel());
                    p.setPoseType(poseDto.getPoseType());
                    p.setPoseTherapeutic(poseDto.getPoseTherapeutic());
                    p.setPoseBenefits(poseDto.getPoseBenefits());
                    p.setPoseContraindications(poseDto.getPoseContraindications());
                    p.setPoseFavorite(poseDto.getPoseFavorite());
                    p.setPoseAdd(poseDto.getPoseAdd());
                    poseRepository.save(p);
                });
    }
}
