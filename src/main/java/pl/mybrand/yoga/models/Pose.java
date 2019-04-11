package pl.mybrand.yoga.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;
import java.nio.file.attribute.FileTime;
import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Data //daje nam: gett sett toString hashcode equals
@Builder
@Entity
@Table(name = "poses")
public class Pose {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pose_image")
    private String poseImage;

    @Column(name = "pose_name_one")
    private String poseNameOne;

    @Column(name = "pose_level")
    private String poseLevel;

    @Column(name = "pose_name_two")
    private String poseNameTwo;

    @Column(name = "pose_type")
    private String poseType;

    @Column(name = "pose_therapeutic")
    private String poseTherapeutic;

    @Column(name = "pose_benefits")
    private String poseBenefits;

    @Column(name = "pose_contraindications")
    private String poseContraindications;

    @Column(name = "pose_favorite")
    private Boolean poseFavorite;

    @Column(name = "pose_add")
    private Boolean poseAdd;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPoseNameOne(){
        return poseNameOne;
    }

    public void setPoseNameOne(String poseNameOne) {
        this.poseNameOne = poseNameOne;
    }

    public String getPoseNameTwo(){
        return poseNameTwo;
    }

    public void setPoseNameTwo(String poseNameTwo) {
        this.poseNameTwo = poseNameTwo;
    }

    public String getPoseImage(){
        return poseImage;
    }

    public void setPoseImage(String poseImage) {
        this.poseImage = poseImage;
    }

    public String getPoseLevel(){
        return poseLevel;
    }

    public void setPoseLevel(String poseLevel) {
        this.poseLevel = poseLevel;
    }

    public String getPoseType(){
        return poseType;
    }

    public void setPoseType(String poseType) {
        this.poseType = poseType;
    }

    public String getPoseBenefits(){
        return poseBenefits;
    }

    public void setPoseBenefits(String poseBenefits) {
        this.poseBenefits = poseBenefits;
    }

    public String getPoseTherapeutic(){
        return poseTherapeutic;
    }

    public void setPoseTherapeutic(String poseTherapeutic) {
        this.poseTherapeutic = poseTherapeutic;
    }

    public String getPoseContraindications(){
        return poseContraindications;
    }

    public void setPoseContraindications(String poseContraindications) {
        this.poseContraindications = poseContraindications;
    }

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "pose_tag",
            joinColumns = @JoinColumn(name = "pose_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tags = new HashSet<>();
}
