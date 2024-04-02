package com.product.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.product.entity.SignUp;

public interface SignUpRepo extends JpaRepository<SignUp, Integer>{
	@Query("SELECT e.mobileNumber, e.emailId FROM SignUp e where e.emailId=:emailId")
    List<Object[]> findMobileNumberAndEmail(String emailId);
    
    @Query("SELECT  CASE WHEN COUNT(e)>0 THEN true else false END FROM SignUp e where e.emailId=:emailId")
    boolean existByEmail(@Param("emailId") String emailId);
    
    @Query("SELECT  e.password from SignUp e  where e.emailId=:emailId")
    String findPasswordByEmail(@Param("emailId") String emailId);
}
