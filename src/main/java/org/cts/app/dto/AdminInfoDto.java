package org.cts.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminInfoDto {

    private String adminName;
    private String adminPassword;
    private String adminEmail;
    private String adminUserId;
}
