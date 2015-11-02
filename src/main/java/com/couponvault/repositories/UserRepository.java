package com.couponvault.repositories;

import org.springframework.data.repository.CrudRepository;

import com.couponvault.model.User;
public interface UserRepository extends CrudRepository<User,Long> {

	User findByUsername(String username);

}
