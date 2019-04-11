package pl.mybrand.yoga.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.mybrand.yoga.models.Pose;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface PoseRepository extends JpaRepository<Pose, String> {

@Query(value = "delete from Pose p where p.poseNameOne=?1")//jpa, 2 sposób
@Transactional
@Modifying
    void deleteByPoseNameOne(String poseNameOne);

@Query(value = "select p from Pose p where p.poseNameOne=?1")
    Optional<Pose> findByPoseNameOne(String poseNameOne);

        }