package com.example.demo.mapper;

import com.example.demo.model.MemberDAO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        MemberDAO memberDAO = new MemberDAO();

        //map database object to dao
        memberDAO.setId(resultSet.getString("id"));
        memberDAO.setStartDate(resultSet.getString("start_date"));
        memberDAO.setEndDate(resultSet.getString("end_date"));
        memberDAO.setDescription(resultSet.getString("description"));
        memberDAO.setLevel(resultSet.getString("level"));
        memberDAO.setStatus(resultSet.getString("status"));
        memberDAO.setName(resultSet.getString("name"));

        return memberDAO;
    }
}
