package com.mees.SchoolManager.Mark;

import com.mees.SchoolManager.Mark.Mark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Marks")
public class MarkController {
    @Autowired
    private MarkService MarkService;

    @GetMapping
    public List<Mark> getAllMarks() {
        return MarkService.getAllMarks();
    }
}