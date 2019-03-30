package com.example.demo;

import com.example.demo.model.MemberDAO;
import com.example.demo.service.MemberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    private MemberService memberService;

    @Test
    public void contextLoads() {
        //test get all

        MemberDAO newMember2 = new MemberDAO();
        newMember2.setName("name");

        List<MemberDAO> memberDAOS = memberService.getAllMemberInfo(newMember2);
        System.out.println(memberDAOS.size());

        //test get by id
        List<MemberDAO> member  = memberService.getMemberById("2");
        //System.out.println(member.get(0).toString());

        //test insert
        MemberDAO newMember = new MemberDAO();
        newMember.setName("name");
        newMember.setStartDate("2019-01-01");
        newMember.setEndDate("2019-03-01");
        newMember.setLevel("level");
        newMember.setStatus("status");
        newMember.setDescription("des");
        //memberService.addNewMember(newMember);

        //test delete
        //memberService.deleteMemberById("22");

        //test update
        MemberDAO exsitMember = new MemberDAO();
        exsitMember.setId("1");
        exsitMember.setName("1");
        exsitMember.setStartDate("2011-01-01");
        //exsitMember.setEndDate("2011-03-01");
        //exsitMember.setLevel("level1");
        exsitMember.setStatus("status1");
        exsitMember.setDescription("des1");
       // memberService.modifySingleMemberInfo(exsitMember);

    }

}
