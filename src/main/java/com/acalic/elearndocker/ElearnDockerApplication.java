package com.acalic.elearndocker;

import com.acalic.elearndocker.domain.Course;
import com.acalic.elearndocker.domain.Role;
import com.acalic.elearndocker.domain.TakeCourse;
import com.acalic.elearndocker.domain.User;
import com.acalic.elearndocker.service.CourseService;
import com.acalic.elearndocker.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

@SpringBootApplication
public class ElearnDockerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElearnDockerApplication.class, args);
	}

//	@Bean
//	CommandLineRunner run(UserService userService, CourseService courseService) {
//		return args -> {
//			userService.saveRole(new Role(null, "ROLE_USER"));
//			userService.saveRole(new Role(null, "ROLE_ADMIN"));
//			userService.saveRole(new Role(null, "ROLE_MANAGER"));
//			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));
//			userService.saveRole(new Role(null, "STUDENT"));
//
//			userService.saveUser(new User(
//					null,
//					"a.calic@example.com",
//					new Date(),
//					"Sasa",
//					"Calic",
//					"qwertz111",
//					new ArrayList<>(),
//					new HashSet<>(),
//					new HashSet<>(),
//					new HashSet<>(),
//					new HashSet<>()
//					));
//
//			User student = userService.saveUser(new User(
//					null,
//					"a.calic@gmail.com",
//					new Date(),
//					"Sasa",
//					"Calic",
//					"qwertz111",
//					new ArrayList<>(),
//					new HashSet<>(),
//					new HashSet<>(),
//					new HashSet<>(),
//					new HashSet<>()
//			));
//
//			Course course = courseService.saveCourse(new Course(null, "Advanced Math", "A math course", new HashSet<>(), new HashSet<>(), null, new HashSet<>()));
//
////			takeCourseService.startCourse(new TakeCourse(null, student, course, 0));
//
////			userService.saveUser(new User(null, "John Travolta", "john", "1234", new ArrayList<>(), new HashSet<>(), null));
////			userService.saveUser(new User(null, "Will Smith", "will", "1234", new ArrayList<>(), new HashSet<>(), null));
////			userService.saveUser(new User(null, "Jim Carry", "jim", "1234", new ArrayList<>(), new HashSet<>(), null));
////			userService.saveUser(new User(null, "Sasa Calic", "sasa", "1234", new ArrayList<>(), new HashSet<>(), null));
//
////			userService.addRoleToUser("john", "ROLE_USER");
////			userService.addRoleToUser("will", "ROLE_MANAGER");
////			userService.addRoleToUser("jim", "ROLE_MANAGER");
////			userService.addRoleToUser("jim", "ROLE_ADMIN");
//			userService.addRoleToUser("a.calic@example.com", "ROLE_SUPER_ADMIN");
//			userService.addRoleToUser("a.calic@example.com", "ROLE_MANAGER");
//			userService.addRoleToUser("a.calic@example.com", "ROLE_ADMIN");
//		};
//	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
