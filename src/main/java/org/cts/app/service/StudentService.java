package org.cts.app.service;

import org.cts.app.dto.StudentInfoDto;
import org.cts.app.entity.StudentInfoTable;
import org.cts.app.repository.StudentInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentInfoRepository studentInfoRepository;

    @Autowired
    StudentInfoDto studentInfoDto;

    public ResponseEntity<?> saveStudentInfo(StudentInfoDto studentInfoDto){
        List<StudentInfoTable> studentList=studentInfoRepository.studentInfoList(studentInfoDto.getStudRollNum());
        String maxRedId = studentInfoRepository.findMaxLengthStudRegId();
        StudentInfoTable studentInfoTable = new StudentInfoTable();
        if (ObjectUtils.isEmpty(studentList)) {
            studentInfoTable.setStudentName(studentInfoDto.getStudentName());
            studentInfoTable.setStudentPassword(studentInfoDto.getStudentPassword());
            studentInfoTable.setStudentGmail(studentInfoDto.getStudentGmail());
            studentInfoTable.setStudBranch(studentInfoDto.getStudBranch());
            studentInfoTable.setStudYear(studentInfoDto.getStudYear());
            studentInfoTable.setStudRollNum(studentInfoDto.getStudRollNum());
        }
        else{
            return new ResponseEntity<>("Data for this RollNum"+studentInfoDto.getStudRollNum()+"is already present",HttpStatus.INTERNAL_SERVER_ERROR);
        }


        if (!ObjectUtils.isEmpty(maxRedId)) {
            String prefix = maxRedId.substring(0, 4);
            String numericPart = maxRedId.substring(4);
            int nextId = Integer.parseInt(numericPart) + 1;
            maxRedId = prefix + String.format("%04d", nextId);
        }
        else {
                String prefix = "CTSS";
                maxRedId = prefix + String.format("%04d", 1);
            }
            studentInfoTable.setStudRegId(maxRedId);
            studentInfoRepository.save(studentInfoTable);

        return new ResponseEntity<>("DataSaved", HttpStatus.OK);
    }
}
