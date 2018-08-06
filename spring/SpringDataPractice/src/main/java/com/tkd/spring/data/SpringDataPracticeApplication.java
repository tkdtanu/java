package com.tkd.spring.data;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import lombok.Data;
import lombok.NoArgsConstructor;

@SpringBootApplication
public class SpringDataPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataPracticeApplication.class, args);
	}
	
	@Bean
	CommandLineRunner initData(EmployeeRepository employeeRepository, ManagerRepository managerRepository) {
		return args -> {
			Manager manager = managerRepository.save(new Manager("Gandalf"));
			employeeRepository.save(new Employee("Tarun", "Das", "Manager", manager));
			employeeRepository.save(new Employee("Rakesh", "Panda", "Portal Admin", manager));
		};
	}
}
@Data
@Entity
@NoArgsConstructor
class Employee {
	@Id
	@GeneratedValue
	Long id;
	String firstName;
	String lastName;
	String role;
	@ManyToOne
	Manager manager;
	public Employee(String firstName, String lastName, String role, Manager manager) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.manager = manager;
	}

}
@RepositoryRestResource
interface EmployeeRepository extends CrudRepository<Employee, Long> {
	
	List<Employee> findByLastName(@Param("lastName")String lastName);
	
	List<Employee> findByRole(@Param("role") String role);
	
	List<Employee> findByManagerName(@Param("mName") String managerName);
	
}

@Data
@Entity
@NoArgsConstructor
class Manager {
	@Id @GeneratedValue Long id;
	
	@OneToMany(mappedBy="manager")
	List<Employee> employees;
	String name;
	public Manager(String name) {
		this.name = name;
	}
}

@RepositoryRestResource
interface ManagerRepository extends CrudRepository<Manager, Long>{
	List<Manager> findByEmployeesRoleContains(@Param("role") String role);
}
