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
@Table(name = "complaint_registration_table")
public class ComplaintRegistrationTable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")    // automatically generated
    private Long complaintID;

    @Column(name = "complaint_section")  //it should contain a dropdown options
    private String complaintSection;

    @Column(name = "complaint_num")
    private String complaintNum;   // will be generated automatically

    @Column(name = "reg_id")
    private String registrationId; //student registration

    @Column(name = "complaint_created_date")
    private Timestamp complaintCreatedDate;   // will be generated automatically









}
