package com.product.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.product.entity.SignUp;

public interface SignUpRepo extends JpaRepository<SignUp, Integer>{
	@Query("SELECT e.mobileNumber, e.emailId FROM SignUp e where e.emailId=:emailId")
    List<Object[]> findMobileNumberAndEmail(String emailId);
    
    @Query("SELECT  CASE WHEN COUNT(e)>0 THEN true else false END FROM SignUp e where e.emailId=:emailId")
    boolean existByEmail(@Param("emailId") String emailId);
    
    @Query("SELECT  e.password from SignUp e where e.emailId=:emailId")
    String findPasswordByEmail(@Param("emailId") String emailId);
    
    @Query("SELECT CASE WHEN COUNT(e) > 0 THEN true ELSE false END FROM SignUp e WHERE e.emailId = :emailId")
    Optional<Boolean> existEmail(@Param("emailId") String emailId);

    @Query("SELECT e.password FROM SignUp e WHERE e.emailId = :emailId")
    Optional<String> findPasswordEmail(@Param("emailId") String emailId);
    
    @Query("SELECT  CASE WHEN COUNT(e)>0 THEN true else false END FROM SignUp e where e.emailId=:emailId")
    boolean existEmailId(@Param("emailId") String emailId);
    
    @Modifying
    @Query("UPDATE SignUp e SET e.password = :password WHERE e.emailId = :emailId")
    void updateFieldByEmail(@Param("password") String password, @Param("emailId") String emailId);

}
