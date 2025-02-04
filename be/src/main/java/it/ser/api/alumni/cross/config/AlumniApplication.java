package it.ser.api.alumni.cross.config;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FullyQualifiedAnnotationBeanNameGenerator;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(
        basePackages = {"it.ser.api"},
        nameGenerator = FullyQualifiedAnnotationBeanNameGenerator.class
)
@EntityScan(basePackages = {"it.ser.api.alumni.storage.entities"})
@EnableJpaRepositories(basePackages = {"it.ser.api.alumni.storage.repo"})
public class AlumniApplication {

    public static void main(String... args) {
        SpringApplication.run(AlumniApplication.class, args);
    }
}
