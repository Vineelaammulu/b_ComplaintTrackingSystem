package org.cts.app.service;

import org.cts.app.dto.AdminInfoDto;
import org.cts.app.entity.AdminInfoTable;
import org.cts.app.repository.AdminInfoRepository;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.security.auth.login.CredentialNotFoundException;
import java.util.List;

@Service
public class AdminService {

    @Autowired
    AdminInfoRepository adminInfoRepository;

    public ResponseEntity<?> saveAdminInfo(AdminInfoDto adminInfoDto){
        List<AdminInfoTable> adminInfoList=adminInfoRepository.getDetailsOfAdmin(adminInfoDto.getAdminUserId());
        if (ObjectUtils.isEmpty(adminInfoList)) {
            String maxRedId = adminInfoRepository.findMaxLengthAdminRegId();
            if (ObjectUtils.isEmpty(adminInfoList)) {
                AdminInfoTable adminInfoTable = new AdminInfoTable();
                adminInfoTable.setAdminName(adminInfoDto.getAdminName());
                adminInfoTable.setAdminPassword(adminInfoDto.getAdminPassword());
                adminInfoTable.setAdminEmail(adminInfoDto.getAdminEmail());
                adminInfoTable.setAdminUserId(adminInfoDto.getAdminUserId());
                if (!ObjectUtils.isEmpty(maxRedId)) {
                    String prefix = maxRedId.substring(0, 4);
                    String numericPart = maxRedId.substring(4);
                    int nextId = Integer.parseInt(numericPart) + 1;
                    maxRedId = prefix + String.format("%04d", nextId);
                } else {
                    String prefix = "CTSA";
                    maxRedId = prefix + String.format("%04d", 1);
                }
                adminInfoTable.setAdminRegID(maxRedId);
                adminInfoRepository.save(adminInfoTable);
            } else {
                return new ResponseEntity<>("Admin details for this user id is already exists", HttpStatus.INTERNAL_SERVER_ERROR);
            }
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("AdminRegID", maxRedId);

            return new ResponseEntity<>(jsonObject, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Already had an admin account for this UserID plead Login", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> getAdminLoginDetails(String RegId, String Password){
        List<AdminInfoTable> adminLoginDetails=adminInfoRepository.adminInfoLoginDetails(RegId,Password);
        if (!ObjectUtils.isEmpty(adminLoginDetails)){
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("adminLoginDetails",adminLoginDetails);
            return new ResponseEntity<>(jsonObject,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("No Details found for provided credentials",HttpStatus.NOT_FOUND);
        }
    }
}
