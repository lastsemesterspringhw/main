package hw.sp.man.demo.repository;

import hw.sp.man.demo.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepository extends JpaRepository<Section,Long> {
}
