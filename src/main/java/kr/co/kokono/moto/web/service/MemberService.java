package kr.co.kokono.moto.web.service;

import kr.co.kokono.moto.web.domain.Member;
import kr.co.kokono.moto.web.repository.MemberDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class MemberService {

    private final MemberDao memberDao;

    @Transactional
    public void insert(String username, String password) {
        memberDao.insert(username, password);
    }

    @Transactional(readOnly = true)
    public List<Member> findAll() {
        return memberDao.findAll();
    }
}
