package org.cts.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "id_card_info_table")
public class IdCardTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idCardId;

    @Column(name = "student_name")
    private String studentName;

    @Column(name ="student_rollNum")
    private String rollNumber;

    @Column(name = "bloodGroup")
    private String bloodGroup;

    @Column(name = "stud_village")
    private String studentVillage;

    @Column(name = "stud_mobile_number")
    private String studMobileNumber;

    @Column(name = "pinCode")
    private String pinCode;

    @Column(name = "wantToApply")
    private Boolean wantToApply;

    @Column(name = "Date_Of_Lost")
    private Timestamp dateOfLoss;

    @Column(name = "description")
    private String description;
}

