package com.example.finish.service;

import com.example.finish.model.Course;
import com.example.finish.model.Section;
import com.example.finish.repo.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectionServiceImpl implements SectionService{

    @Autowired
    private SectionRepository sectionRepository;

    @Override
    public List<Section> getAllSections() {
        return sectionRepository.findAll();
    }

    @Override
    public void deleteSection(int id) {
        sectionRepository.delete(id);
    }

    @Override
    public Section getSectionById(int id) {
        return sectionRepository.findOne(id);
    }

    @Override
    public void addSection(Section section) {
        sectionRepository.save(section);
    }

}
