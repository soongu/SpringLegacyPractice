package kr.co.kokono.moto.web.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Member {

    private int id;
    private String username;
    private String password;

    public Member(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
}
