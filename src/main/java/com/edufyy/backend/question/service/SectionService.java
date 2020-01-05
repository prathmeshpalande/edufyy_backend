package com.edufyy.backend.question.service;

import com.edufyy.backend.question.model.Section;
import com.edufyy.backend.question.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SectionService {

    @Autowired
    private SectionRepository sectionRepository;

    public Section verifyTeacherBySectionKey(String email, String sectionKey) {
        return sectionRepository.verifyTeacherBySectionKey(email, sectionKey);
    }

}
