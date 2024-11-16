package com.gs.EnergiShare.AuditLog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AuditLogRepository extends JpaRepository<AuditLog, Integer> {
    Page<AuditLog> findByTableNameContaining(String tableName, Pageable pageable);
}
