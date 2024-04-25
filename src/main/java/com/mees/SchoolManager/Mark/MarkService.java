package com.mees.SchoolManager.Mark;

import com.mees.SchoolManager.Mark.Mark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarkService {
    @Autowired
    private MarkRepository MarkRepository;

    public List<Mark> getAllMarks() {
        return MarkRepository.findAll();
    }
}
