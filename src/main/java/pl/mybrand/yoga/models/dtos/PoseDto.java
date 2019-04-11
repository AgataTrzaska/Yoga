package pl.mybrand.yoga.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Filter;
import org.hibernate.annotations.FilterDef;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PoseDto {
    private String poseImage;
    private String poseNameOne;
    private String poseNameTwo;
    private String poseLevel;
    private String poseType;
    private String poseTherapeutic;
    private String poseBenefits;
    private String poseContraindications;
    private Boolean poseFavorite;
    private Boolean poseAdd;
    private List<String> tags = new ArrayList<>();
}
