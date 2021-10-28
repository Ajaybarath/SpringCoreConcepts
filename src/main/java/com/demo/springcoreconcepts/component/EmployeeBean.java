package com.demo.springcoreconcepts.component;

import ch.qos.logback.classic.Logger;
import com.demo.springcoreconcepts.SpringCoreConceptsApplication;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeBean {

    private int eid;
    private String ename;

    @Autowired
    private DepartmentBean deptBean;

    public static final Logger logger = (Logger) LoggerFactory.getLogger(SpringCoreConceptsApplication.class);

    public EmployeeBean() {}

    @Autowired
    public EmployeeBean(DepartmentBean deptBean) {
        logger.trace("*** Autowiring by using @Autowire annotation as constructor ***");
        this.deptBean = deptBean;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public DepartmentBean getDeptBean() {
        return deptBean;
    }

    @Autowired
    public void setDeptBean(DepartmentBean deptBean) {
        logger.trace("*** Autowiring by using @Autowire annotation as setters ***");
        this.deptBean = deptBean;
    }

    public void showEmployeeDetails() {
        logger.debug("Employee id: {}", eid);
        logger.debug("Employee name: {}", ename);
        deptBean.setDeptName("Information Technology");
        logger.debug("Department: {}", deptBean.getDeptName());
    }
}
