package com.javweb.mantenjavweb.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Copyright(C) [2026] [Luvina Software Company]
 *
 * [User.java], [Apr 6 ,2026] [ntlong]
 */

/**
 * Tao model cho User
 * author: [ntlong]
 *
 * */
@Entity //dinh nghia la model
@Data //getter setter
@AllArgsConstructor //khoi tao constructor co tat ca tham so
@NoArgsConstructor //khoi tao constructor khong tham so
@Table(name = "users") //tham chieu den bang users trong database
public class User {
    @Id //danh dau la khoa chinh trong bang
    @GeneratedValue(strategy = GenerationType.IDENTITY) //tu dong tang id
    private Long id;

    private String name;
    private LocalDate birthday;
    private String department;
    private String email;
    private String phone;
    private String major;
    private LocalDate date;
    private Double score;
}
