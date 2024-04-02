package com.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.entity.SignUp;
import com.product.repository.SignUpRepo;

@Service
public class SignUpService {

	@Autowired
	SignUpRepo signUpRepo;

	@Autowired
	EmailService emailService;

	public String insertSignUpDetails(SignUp signUp) {

		List<Object[]> a = this.signUpRepo.findMobileNumberAndEmail(signUp.getEmailId());
		boolean emailExists = false;
		for (Object[] result : a) {
			System.out.println("Mobile Number: " + result[0]);
			System.out.println("Email: " + result[1]);
			if (result[1].equals(signUp.getEmailId())) {
				System.out.println("if.." + result[1]);

				emailExists = true;
				break;

			}
		}

		if (emailExists) {
			return "Existed"; // Return "Existed" if email exists
		} else {
			// If the email doesn't exist, save the new sign-up details
			this.signUpRepo.save(signUp);
			System.out.println("Inserted new sign-up details");
			String mail = signUp.getEmailId();
			emailService.sendEmail(mail, "Registration", "Hi,You have successfully registered.");
			System.out.println("email Send..");
			return "Inserted";
		}
	}
	
	public String Login(SignUp signUp) {
		boolean logInMailExists = false;
		List<Object[]> a = this.signUpRepo.findMobileNumberAndEmail(signUp.getEmailId());
		for (Object[] result : a) {
			if(result[1].equals(signUp.getEmailId())) {
				System.out.println("mail exist" + result[1]);
				logInMailExists=true;
				break;
			}
		}
		if (logInMailExists) {
			return "Login Exist"; 
		} else {
			
			return "LogIn Not Exist";
		}
		
		
		
	}


}
