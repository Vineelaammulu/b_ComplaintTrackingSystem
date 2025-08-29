package org.cts.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComplaintRegistrationDto {

    private String complaintSection;
    private String regID;
    private IdCardDto idCardDto;
}
