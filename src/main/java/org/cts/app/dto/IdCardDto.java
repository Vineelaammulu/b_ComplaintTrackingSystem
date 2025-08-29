package org.cts.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IdCardDto {
   private Timestamp dateOfLost;
   private Boolean wantToApply;
   private String description;
   private String bloodGroup;
   private String mobileNumber;
   private String StudentVillage;
   private String pinCode;

}
