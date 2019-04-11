package pl.mybrand.yoga.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mybrand.yoga.models.Tag;

public interface TagRepository extends JpaRepository<Tag,String> {

}