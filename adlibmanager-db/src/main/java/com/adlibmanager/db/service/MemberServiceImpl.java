package com.adlibmanager.db.service;

import com.adlibmanager.core.domain.Member;
import com.adlibmanager.core.service.MemberService;
import com.adlibmanager.db.repository.MemberRepository;

import java.util.List;

public class MemberServiceImpl implements MemberService {

    private MemberRepository repository = new MemberRepository();

    @Override
    public void addMember(Member member) {
        repository.save(member);
    }

    @Override
    public void deleteMember(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<Member> searchMembers(String name) {
        return repository.search(name);
    }
}
