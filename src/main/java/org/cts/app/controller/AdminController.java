package org.cts.app.controller;

import org.cts.app.dto.AdminInfoDto;
import org.cts.app.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@Controller
@RequestMapping("/admin")
public class AdminController {

    private static final Logger logger=LoggerFactory.getLogger(AdminController.class);

    @Autowired
    AdminService adminService;

    @PostMapping("/register")
    public ResponseEntity<?> saveAdminDetails(@RequestBody AdminInfoDto adminInfoDto){
        logger.info("Entered into admin register controller");
        return adminService.saveAdminInfo(adminInfoDto);
    }

    @GetMapping("/getLoginDetails")
    public ResponseEntity<?> getAdminLoginDetails(@RequestParam String regId,
                                                  @RequestParam String password){
        logger.info("Entered into Admin Login Details");
        return adminService.getAdminLoginDetails(regId,password);
    }

}
