package com.example.wjug.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
public class Employee {
    @Id
    private UUID id;
    @Version
    private long version;
    private String firstName;
    private String lastName;
    private BigDecimal hourlyEarnings;
    private Integer lastNotSettledTimesheetWorkTime;
}
