package org.cts.app.repository;

import org.cts.app.entity.StudentInfoTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentInfoRepository extends JpaRepository<StudentInfoTable,Long> {

    @Query(value = "select MAX(stud_reg_ID) from student_info_table",nativeQuery = true)
    String findMaxLengthStudRegId();

    @Query(value = "select * from student_info_table where stud_rollnum=:studRollNum",nativeQuery = true)
    List<StudentInfoTable> studentInfoList(String studRollNum);

    @Query(value = "select * from student_info_table where stud_reg_id=:regId and stud_pwd=:password",nativeQuery = true)
    List<StudentInfoTable> studentInfoLoginDetails(String regId ,String password);
}
