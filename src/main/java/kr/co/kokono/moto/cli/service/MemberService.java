package kr.co.kokono.moto.cli.service;

import kr.co.kokono.moto.cli.domain.Member;
import kr.co.kokono.moto.cli.repository.MemberDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class MemberService {

    private final MemberDao memberDao;

    @Autowired
    public MemberService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Transactional
    public void insert(String username, String password) {
        memberDao.insert(username, password);
    }

    @Transactional(readOnly = true)
    public List<Member> findAll() {
        return memberDao.findAll();
    }
}
