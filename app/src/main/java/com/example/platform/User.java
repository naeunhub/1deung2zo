package com.example.platform;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

/*
 *회원가입 정보
 */
@Entity(indices = {@Index(value = {"phoneNumber"}, unique = true)})
public class User {
    //성명
    private String name;

    //성별
    private String gender;

    //나이
    private int age;

    //거주지
    private String address;

    //휴대폰 번호(중복 불가)
    private String phoneNumber;

    //아이디(중복 불가)
    @PrimaryKey @NonNull
    private String id;

    //비밀번호
    private String password;


    //Getter, Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
