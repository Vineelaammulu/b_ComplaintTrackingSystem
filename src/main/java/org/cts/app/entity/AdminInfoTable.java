package org.cts.app.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "admin_info_table")
public class AdminInfoTable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long adminId;

    @Column(name = "admin_name")
    private String adminName;

    @Column(name = "admin_password")
    private String adminPassword;

    @Column(name = "admin_email")
    private String adminEmail;

    @Column(name="admin_reg_id")
    private String adminRegID;

    @Column(name = "admin_user_id")
    private String adminUserId;
}
