package org.cts.app.repository;

import org.cts.app.entity.AdminInfoTable;
import org.cts.app.entity.StudentInfoTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AdminInfoRepository extends JpaRepository<AdminInfoTable,Long> {

    @Query(value = "select MAX(admin_reg_id) from admin_info_table",nativeQuery = true)
    String findMaxLengthAdminRegId();

    @Query(value = "select * from admin_info_table where admin_user_id=:adminUserId", nativeQuery = true)
    List<AdminInfoTable> getDetailsOfAdmin(String adminUserId);

    @Query(value = "select * from admin_info_table where admin_reg_id=:regId and admin_password=:password",nativeQuery = true)
    List<AdminInfoTable> adminInfoLoginDetails(String regId , String password);


}
