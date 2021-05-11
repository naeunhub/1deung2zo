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
    public String name;

    //성별
    public String gender;

    //나이
    public int age;

    //거주지
    public String address;

    //휴대폰 번호(중복 불가)
    public String phoneNumber;

    //아이디(중복 불가)
    @PrimaryKey @NonNull
    public String id;

    //비밀번호
    public String password;

}
