package edu.zju.se.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class People implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private int grade;

    private String department;

    private String major;

    private String _class;

    private String phonenumber;

    private String nucleic;

    private String healthycode;

    private String campus;

    private String most_recent_date;

}

