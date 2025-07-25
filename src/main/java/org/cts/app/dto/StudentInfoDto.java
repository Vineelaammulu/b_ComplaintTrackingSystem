package org.cts.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data //for setters and getters
@AllArgsConstructor // generates all the constructors
@NoArgsConstructor
@Component
public class StudentInfoDto {
    private String studentName;
    private String studentPassword;
    private String studentGmail;
    private String studBranch;
    private String studYear;
    private String studRollNum;
}
