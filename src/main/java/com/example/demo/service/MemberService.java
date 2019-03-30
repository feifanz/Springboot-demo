package com.example.demo.service;

import com.example.demo.model.MemberDAO;

import java.util.List;

public interface MemberService {

    /*search member by several conditions**/
    List<MemberDAO> getAllMemberInfo(MemberDAO member);

    /*search member by id**/
    List<MemberDAO> getMemberById(String id);

    /*add a new member**/
    int addNewMember(MemberDAO member);

    /*delete a member by id**/
    int deleteMemberById(String id);

    /*modify member**/
    int modifySingleMemberInfo(MemberDAO member);
}
