package com.sliit.procurement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sliit.procurement.model.User;

public interface UserRepository extends JpaRepository<User,Integer>  {

    User findByPersonNo(int personNo);
}
