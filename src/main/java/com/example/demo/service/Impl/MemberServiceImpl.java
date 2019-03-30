package com.example.demo.service.Impl;

import com.example.demo.mapper.MemberMapper;
import com.example.demo.model.MemberDAO;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<MemberDAO> getAllMemberInfo(MemberDAO member) {
        List<MemberDAO> res = null;

        StringBuffer sql = new StringBuffer();
        sql.append("select id,name,start_date,end_date,description,level,status from member where 1 = 1");

        if(member == null){
            res = jdbcTemplate.query(sql.toString(),new MemberMapper());
        }else{
            if(member.getId() != null){
                sql.append(" and id like '").append(member.getId()).append("%'");
            }
            if(member.getStartDate() != null){
                sql.append(" and start_date = '").append(member.getStartDate()).append("'");
            }
            if(member.getEndDate() != null){
                sql.append(" and end_date = '").append(member.getEndDate()).append("'");
            }
            if(member.getStatus() != null){
                sql.append(" and status = '").append(member.getStatus()).append("'");
            }
            if(member.getLevel() != null){
                sql.append(" and level = '").append(member.getLevel()).append("'");
            }
            if(member.getDescription() != null){
                sql.append(" and description = '").append(member.getDescription()).append("'");
            }
            if(member.getName() != null){
                sql.append(" and name like '").append(member.getName()).append("%'");
            }
        }

        res = jdbcTemplate.query(sql.toString(),new MemberMapper());
        return res;
    }

    @Override
    public List<MemberDAO> getMemberById(String id) {
        String sql = "select * from member where id = " + id;
        List<MemberDAO> res = jdbcTemplate.query(sql,new MemberMapper());
        return res;
    }

    @Override
    public int addNewMember(MemberDAO member) {
        String sql = "insert into member(name,start_date,end_date,description,level,status) value(?,?,?,?,?,?)";
        int res = jdbcTemplate.update(sql,
                member.getName(),
                member.getStartDate(),
                member.getEndDate(),
                member.getDescription(),
                member.getLevel(),
                member.getStatus());
        return res;
    }

    @Override
    public int deleteMemberById(String id) {
        String sql = "delete from member where id = ?";
        int res = jdbcTemplate.update(sql,id);
        return res;
    }

    @Override
    public int modifySingleMemberInfo(MemberDAO member) {
        StringBuffer sql = new StringBuffer();
        sql.append("update member set");

        if(member.getName() != null){
            sql.append(" name= '" + member.getName()).append("',");
        }
        if(member.getStartDate() != null){
            sql.append(" start_date= '" + member.getStartDate()).append("',");
        }
        if(member.getEndDate() != null){
            sql.append(" end_date= '" + member.getEndDate()).append("',");
        }
        if(member.getDescription() != null){
            sql.append(" description= '" + member.getDescription()).append("',");
        }
        if(member.getLevel() != null){
            sql.append(" level= '" + member.getLevel()).append("',");
        }
        if(member.getStatus() != null){
            sql.append(" status= '" + member.getStatus()).append("'");
        }
        sql.append(" where id = " + member.getId());

        int res = jdbcTemplate.update(sql.toString());
        return res;
    }

}
