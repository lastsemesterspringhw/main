package hw.sp.man.demo.Services;

import hw.sp.man.demo.model.Section;
import hw.sp.man.demo.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectionServicesImpl implements SectionServices {

    @Autowired
    private SectionRepository sectionRepository;

    @Override
    public void save(Section section) {
        sectionRepository.save(section);

    }

    @Override
    public List<Section> findAllSection() {
        return null;
    }

    @Override
    public Section findAllSectionById(long id) {
        return sectionRepository.findOne(id);



    }

    @Override
    public void deleteSection(long id) {
        sectionRepository.delete(id);
    }


}
