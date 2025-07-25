package org.cts.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student_info_table")
public class StudentInfoTable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name ="id")
    private Long studentId;

    @Column(name = "stud_name")  // column name in database
    private String studentName;

    @Column(name = "stud_pwd")
    private String studentPassword;

    @Column(name = "stud_gmail")
    private String studentGmail;

    @Column(name = "stud_branch")
    private String studBranch;

    @Column(name = "stud_year")
    private String studYear;

    @Column(name = "stud_reg_ID")
    private String studRegId;

    @Column(name = "stud_rollnum")
    private String studRollNum;

}
