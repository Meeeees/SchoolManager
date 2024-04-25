package com.mees.SchoolManager.SchoolClass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface SchoolClassRepository extends JpaRepository<SchoolClass, Integer> {

    @Query("SELECT c FROM SchoolClass c JOIN FETCH c.students s WHERE c.id = :SchoolClassId")
    SchoolClass getSchoolClassWithStudents(@Param("SchoolClassId") Integer SchoolClassId);
}
