package kr.co.kokono.moto.cli;

import lombok.Getter;
import lombok.ToString;

import java.sql.ResultSet;
import java.sql.SQLException;

@Getter
@ToString
public class Member {

    private int id;
    private String username;
    private String password;

    public Member(ResultSet rs) throws SQLException {
        this.id = rs.getInt("id");
        this.username = rs.getString("username");
        this.password = rs.getString("password");
    }
}
