package com.aakashjar.rentalmanagementapi.dao.tenant;

import com.aakashjar.rentalmanagementapi.model.tenant.Tenant;

import org.springframework.data.repository.CrudRepository;

public interface TenantDAO extends CrudRepository<Tenant, Long> {

}
