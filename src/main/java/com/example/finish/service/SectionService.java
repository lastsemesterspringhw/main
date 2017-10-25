package com.example.finish.service;

import com.example.finish.model.Section;

import java.util.List;

public interface SectionService {
    List<Section> getAllSections();

    void deleteSection(int id);

    Section getSectionById(int id);

    void addSection(Section section);
}
