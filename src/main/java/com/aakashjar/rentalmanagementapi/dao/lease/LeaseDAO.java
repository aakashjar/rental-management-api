package com.aakashjar.rentalmanagementapi.dao.lease;

import java.util.List;

import com.aakashjar.rentalmanagementapi.model.lease.Lease;

import org.springframework.data.repository.CrudRepository;

public interface LeaseDAO extends CrudRepository<Lease, Long> {

	List<Lease> findByLeaseStatus(char leaseStatus);

	List<Lease> findByLeaseStatusAndTenantId(char leaseStatus, long tenantId);

	boolean existsByLeaseStatusAndPropertyId(char leaseStatus, long propertyId);

	List<Lease> findByLeaseStatusAndPropertyId(char leaseStatus, long propertyId);

	boolean existsByLeaseStatusAndPropertyUnitId(char leaseStatus, long propertyUnitId);

	List<Lease> findByLeaseStatusAndPropertyUnitId(char leaseStatus, long propertyUnitId);

	boolean existsByLeaseStatusAndPropertyIdAndPropertyUnitId(char leaseStatus, long propertyId, long propertyUnitId);

	List<Lease> findByLeaseStatusAndPropertyIdAndPropertyUnitId(char leaseStatus, long propertyId, long propertyUnitId);

}