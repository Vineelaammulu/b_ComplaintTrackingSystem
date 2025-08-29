package org.cts.app.service;

import org.cts.app.dto.ComplaintRegistrationDto;
import org.cts.app.entity.ComplaintRegistrationTable;
import org.cts.app.entity.IdCardTable;
import org.cts.app.entity.StudentInfoTable;
import org.cts.app.repository.ComplaintRegistrationRepository;
import org.cts.app.repository.IdCardInfoRepository;
import org.cts.app.repository.StudentInfoRepository;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;


@Service
public class ComplaintRegistrationService {

    @Autowired
    private ComplaintRegistrationRepository complaintRegistrationRepository;

    @Autowired
    private StudentInfoRepository studentInfoRepository;

    @Autowired
    private IdCardInfoRepository idCardInfoRepository;

    public ResponseEntity<?> saveComplaints(ComplaintRegistrationDto complaintRegistrationDto) {
        JSONObject jsonObject = new JSONObject();
        if (!ObjectUtils.isEmpty(complaintRegistrationDto)) {
            ComplaintRegistrationTable complaintRegistrationTable = new ComplaintRegistrationTable();
            IdCardTable idCardTable=new IdCardTable();
            StudentInfoTable getStudentDetails=studentInfoRepository.getDetailsOnRegId(complaintRegistrationTable.getRegistrationId());
            complaintRegistrationTable.setComplaintSection(complaintRegistrationDto.getComplaintSection());
            complaintRegistrationTable.setRegistrationId(complaintRegistrationDto.getRegID());
            String idCardSection = "IDCard";
            String transportSection = "Transport";
            String hotelSection = "Canteen";
            String hostelSection = "Hostel";
            String feeSection = "DUES";
            if (!ObjectUtils.isEmpty(complaintRegistrationDto.getComplaintSection().equals(idCardSection))) {
                complaintRegistrationTable.setComplaintCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
                String maxRedComplaintNum = complaintRegistrationRepository.findMaxLengthAdminRegId();
                if (!ObjectUtils.isEmpty(maxRedComplaintNum)) {
                    String prefix = maxRedComplaintNum.substring(0, 4);
                    String numericPart = maxRedComplaintNum.substring(4);
                    int nextId = Integer.parseInt(numericPart) + 1;
                    maxRedComplaintNum = prefix + String.format("%04d", nextId);
                } else {
                    String prefix = "CTSCID";
                    maxRedComplaintNum = prefix + String.format("%04d", 1);
                }
                complaintRegistrationTable.setComplaintNum(maxRedComplaintNum);
                idCardTable.setStudentName(getStudentDetails.getStudentName());
                idCardTable.setRollNumber(getStudentDetails.getStudRollNum());
                idCardTable.setBloodGroup(complaintRegistrationDto.getIdCardDto().getBloodGroup());
                idCardTable.setStudentVillage(complaintRegistrationDto.getIdCardDto().getStudentVillage());
                idCardTable.setStudMobileNumber(complaintRegistrationDto.getIdCardDto().getMobileNumber());
                idCardTable.setPinCode(complaintRegistrationDto.getIdCardDto().getPinCode());
                idCardTable.setWantToApply(complaintRegistrationDto.getIdCardDto().getWantToApply());
                idCardTable.setDescription(complaintRegistrationDto.getIdCardDto().getDescription());
                idCardTable.setDateOfLoss(complaintRegistrationDto.getIdCardDto().getDateOfLost());
                idCardInfoRepository.save(idCardTable);
                jsonObject.put("ComplaintNum", maxRedComplaintNum);
                jsonObject.put("Message","Your request is further reviewed by admin");
                return new ResponseEntity<>(jsonObject, HttpStatus.OK);
            }
        }
        else {
            return new ResponseEntity<>("Request from UI is empty",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(jsonObject, HttpStatus.OK);
    }


}
