package hw.sp.man.demo.Services;

import hw.sp.man.demo.model.Section;

import java.util.List;

public interface SectionServices {
    void save(Section section);

    List<Section> findAllSection();

    Section findAllSectionById(long id);

    void deleteSection(long id);
}
