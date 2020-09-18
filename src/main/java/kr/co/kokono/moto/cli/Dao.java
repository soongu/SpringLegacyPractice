package kr.co.kokono.moto.cli;


import lombok.extern.slf4j.Slf4j;

import java.sql.*;

@Slf4j
public class Dao {

    private Connection conn;

    public Dao(Connection connection) {
        this.conn = connection;
    }

    public void run() {

        try(PreparedStatement pstmt = conn.prepareStatement("select * from member")) {

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Member member = new Member(rs);
                log.info("member = " + member);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
