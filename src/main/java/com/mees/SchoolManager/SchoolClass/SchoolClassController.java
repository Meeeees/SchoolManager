package com.mees.SchoolManager.SchoolClass;

import com.mees.SchoolManager.SchoolClass.SchoolClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/SchoolClasses")
public class SchoolClassController {
    @Autowired
    private SchoolClassService SchoolClassService;

    @GetMapping
    public List<SchoolClass> getAllSchoolClasses() {
        return SchoolClassService.getAllSchoolClasses();
    }
}