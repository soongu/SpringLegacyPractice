package kr.co.kokono.moto.web.repository;


import kr.co.kokono.moto.web.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class MemberDao {

    private JdbcTemplate template;

    @Autowired
    public MemberDao(JdbcTemplate template) {
        this.template = template;
    }

    public void insert(String username, String password) {

        String sql = "INSERT INTO MEMBER (USERNAME, PASSWORD) VALUES (?, ?)";
        template.update(sql, username, password);
    }

    public List<Member> findAll() {
        String sql = "SELECT * FROM MEMBER ORDER BY ID";

        return template.query(sql, (rs, i) ->
             new Member(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("password")
            )
        );
    }

}







