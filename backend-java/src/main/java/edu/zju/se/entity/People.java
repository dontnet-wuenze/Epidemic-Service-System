package edu.zju.se.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
public class People implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String identity;

    private String grade;

    private String department;

    private String major;

    private String _class;

    private String phonenumber;

    private String nucleic;

    private String healthycode;

    private String campus;

    private String date;

}

