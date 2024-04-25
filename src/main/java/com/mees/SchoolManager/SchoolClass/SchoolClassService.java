package com.mees.SchoolManager.SchoolClass;

import com.mees.SchoolManager.SchoolClass.SchoolClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SchoolClassService {
    @Autowired
    private SchoolClassRepository SchoolClassRepository;

    public List<SchoolClass> getAllSchoolClasses() {
        List<SchoolClass> SchoolClasses = SchoolClassRepository.findAll();
        List<SchoolClass> SchoolClassesWithStudents = new ArrayList<>();
        for (SchoolClass aSchoolClass : SchoolClasses) {
            SchoolClassesWithStudents.add(SchoolClassRepository.getSchoolClassWithStudents(aSchoolClass.getId()));
        }
        return SchoolClassesWithStudents;
    }
}
