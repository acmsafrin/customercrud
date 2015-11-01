package com.mycompany.myproject.service.dto;

import com.mycompany.myproject.persist.entity.Department;
import org.dozer.Mapping;

public class CustomerDto {

    @Mapping("id")
    private Long id;

    @Mapping("name")
    private String name;
    
    @Mapping("mobile")
    private String mobile;
    
    @Mapping("department")
    private Department department;

    @Mapping("retired")
    private boolean retired;
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public boolean isRetired() {
        return retired;
    }

    public void setRetired(boolean retired) {
        this.retired = retired;
    }
    
    

}
