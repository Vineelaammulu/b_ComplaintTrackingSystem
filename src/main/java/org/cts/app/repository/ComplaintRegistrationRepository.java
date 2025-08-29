package org.cts.app.repository;

import org.cts.app.entity.ComplaintRegistrationTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplaintRegistrationRepository extends JpaRepository<ComplaintRegistrationTable,Long> {

    @Query(value = "select MAX(reg_id) from complaint_registration_table",nativeQuery = true)
    String findMaxLengthAdminRegId();
}
