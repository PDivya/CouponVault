package com.couponvault.repositories;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.couponvault.model.UserDetail;
public interface UserDetailRepository extends CrudRepository<UserDetail, Long>{
	List<UserDetail> findAll();
	@Query(nativeQuery=true)
	List<UserDetail> findAllNative();
	UserDetail findByUsername(String name);
	
}
