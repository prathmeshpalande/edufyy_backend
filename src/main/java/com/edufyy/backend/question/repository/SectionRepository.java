package com.edufyy.backend.question.repository;

import com.edufyy.backend.question.model.Question;
import com.edufyy.backend.question.model.Section;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepository extends CrudRepository<Question, Long> {

    @Query(value = "select * from Section where teacher_email = ?1 and section_key = ? limit 1", nativeQuery = true)
    public Section verifyTeacherBySectionKey(String email, String sectionKey);

}
