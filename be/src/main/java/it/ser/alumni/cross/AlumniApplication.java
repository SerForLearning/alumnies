package it.ser.alumni.cross;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FullyQualifiedAnnotationBeanNameGenerator;

@SpringBootApplication
@ComponentScan(
        basePackages = {"it.ser.alumni"},
        nameGenerator = FullyQualifiedAnnotationBeanNameGenerator.class
)
public class AlumniApplication {

    public static void main(String... args) {
        SpringApplication.run(AlumniApplication.class, args);
    }
}
