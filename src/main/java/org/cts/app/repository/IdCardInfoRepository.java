package org.cts.app.repository;

import org.cts.app.entity.IdCardTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdCardInfoRepository extends JpaRepository<IdCardTable,Long> {
}
