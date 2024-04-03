package com.product.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.product.dto.LogInCredentials;
import com.product.entity.SignUp;
import com.product.exceptionHandling.BadrequestException;
import com.product.exceptionHandling.UserNotFoundException;
import com.product.repository.SignUpRepo;

import jakarta.transaction.Transactional;

@Service
public class SignUpService {

	@Autowired
	SignUpRepo signUpRepo;

	@Autowired
	EmailService emailService;

	
	
	//sign up details
	//inserting into db and sending mail to the user
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

	
	//Login base on db fetching 
	public String Login(LogInCredentials logInCredentials) {
		boolean a = this.signUpRepo.existEmailId(logInCredentials.getUserName());
		System.out.println(a);
		if (a == true) {
			System.out.println("login..if");
			String passwordData = logInPassword(logInCredentials.getUserName());
			System.out.println("passwordData- " + passwordData);
//			return "Email Exist "+passwordData; 
			if (passwordData.equals(logInCredentials.getPassword())) {
				return "logIn Successfull";

			} else {
				return "Password Missmatch";
			}
		} else {
			System.out.println("login..else");
			return "Email Not Exist";
		}

	}

	//checking password is available or not and fetching the password
	public String logInPassword(String emailId) {
		String passwd = this.signUpRepo.findPasswordByEmail(emailId);
		if (passwd != null) {
			System.out.println("password..if");
			return passwd;
		} else {
			System.out.println("passeord..else");
			return null;
		}

	}
	
	//forgot password 
	@Transactional
	public String forgotPwd(LogInCredentials credentials) {
		boolean user = this.signUpRepo.existEmailId(credentials.getUserName());
		System.out.println(user);
		if (user == true) {
			System.out.println("forgot..if");
			 Random random = new Random();
		        long l= 100000 + random.nextInt(900000);
		        String str=String.valueOf(l);
		        System.out.println("random "+l);
		        //update call
		        this.signUpRepo.updateFieldByEmail(str, credentials.getUserName());
		        //mail call
		        emailService.sendEmail(credentials.getUserName(), "Forgot Password OTP", str);
			return "Password is reset,plz check in your mail";
		}else {
			return "Email Not Exist";
		}
		
		
		
	}
	

	public Map<String, Object> LoinSerivce(LogInCredentials credentials) {
		Map<String, Object> map = new HashMap<>();
		boolean emailExists = this.signUpRepo.existEmail(credentials.getUserName())
				.orElseThrow(() -> new UserNotFoundException("Error to fetching user Name"));

		if (emailExists) {
			String dbPassword = this.signUpRepo.findPasswordEmail(credentials.getUserName())
					.orElseThrow(() -> new BadrequestException("Error to fetching password"));

			if (dbPassword != null && dbPassword.equals(credentials.getPassword())) {
				map.put("Message", "Login Credentials Matched");
				map.put("Status", HttpStatus.OK);
				map.put("data", credentials);
			} else {

				throw new BadrequestException("Password Mismatch");
			}
		} else {

			throw new UserNotFoundException("User not found");
		}

		return map;
	}
}
