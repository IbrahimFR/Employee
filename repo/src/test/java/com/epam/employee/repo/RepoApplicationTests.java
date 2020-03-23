//package com.epam.repo;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import javax.persistence.EntityManager;
//import javax.sql.DataSource;
//
//@ExtendWith(SpringExtension.class)
//@DataJpaTest
//class RepoApplicationTests {
//
//	@Autowired
//	private DataSource dataSource;
//	@Autowired private JdbcTemplate jdbcTemplate;
//	@Autowired private EntityManager entityManager;
//
//
//	@Test
//	void injectedComponentsAreNotNull(){
//		assertThat(dataSource).isNotNull();
//		assertThat(jdbcTemplate).isNotNull();
//		assertThat(entityManager).isNotNull();
//		assertThat(userRepository).isNotNull();
//	}
//
//}
