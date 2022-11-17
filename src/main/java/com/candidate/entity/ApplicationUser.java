package com.candidate.entity;

import com.candidate.enums.RoleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "app_user")
public class ApplicationUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @Column(name = "username")
    private String username;
    @Column(name = "age")
    private int age;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private Long phone;
    @Column(name = "sex")
    private String sex;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id")
    private Address address;
    @Column(name = "password`")
    private String password;
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private RoleType role;
    @Column(name="status")
    private Boolean status=false;
    @Column(name="created_by")
    private String createdBy;
    @Column(name = "created_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate createdDate;
    @Column(name = "updated_by")
    private String updatedBy;
    @Column(name = "updated_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate updatedDate;

}
