package com.demo.springcoreconcepts;

import com.demo.springcoreconcepts.component.DemoBean;
import com.demo.springcoreconcepts.component.EmployeeBean;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ch.qos.logback.classic.Logger;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringCoreConceptsApplication {

    public static final Logger logger = (Logger) LoggerFactory.getLogger(SpringCoreConceptsApplication.class);

    public static void main(String[] args) {
        logger.debug("Welcome to Spring Concepts Demo");
        ApplicationContext context = (ApplicationContext) SpringApplication.run(SpringCoreConceptsApplication.class, args);
        logger.debug("Checking context : {}", context.getBean(DemoBean.class));
        logger.debug("\n*** Example Using @Autowire annotation on property ***");
        EmployeeBean employeeBean = context.getBean(EmployeeBean.class);
        employeeBean.setEid(104);
        employeeBean.setEname("Ajay");
        employeeBean.showEmployeeDetails();
    }

}
