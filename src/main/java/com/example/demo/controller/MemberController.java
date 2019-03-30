package com.example.demo.controller;


import com.example.demo.model.MemberDAO;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MemberController {

    @Autowired
    private MemberService memberService;

    /*search member list **/
    @RequestMapping("/allmembers")
    public List<MemberDAO> getMember(MemberDAO request) {

        //check request format
        if (request.getName() != null && request.getName().equals("")) {
            request.setName(null);
        }
        if (request.getId() != null && request.getId().equals("")) {
            request.setId(null);
        }

        List<MemberDAO> memberDAOS = memberService.getAllMemberInfo(request);
        return memberDAOS;
    }

    /*add a new member**/
    @RequestMapping("/addmembers")
    public String addMember(MemberDAO request) {
        int res = memberService.addNewMember(request);
        return res == 1 ? "success" : "fail";
    }

    /*delete a member**/
    @RequestMapping("/deletemembers")
    public String deleteMember(String id) {
        int res = memberService.deleteMemberById(id);
        return res == 1 ? "success" : "fail";
    }

    /*edit a member**/
    @RequestMapping("/editmembers")
    public String editMember(MemberDAO request) {
        int res = memberService.modifySingleMemberInfo(request);
        return res == 1 ? "success" : "fail";
    }
}
