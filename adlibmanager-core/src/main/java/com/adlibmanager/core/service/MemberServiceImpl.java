package com.adlibmanager.core.service;

import com.adlibmanager.core.domain.Member;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemberServiceImpl implements MemberService {

    private List<Member> members = new ArrayList<>();

    @Override
    public void addMember(Member member) {
        members.add(member);
    }

    @Override
    public void deleteMember(String id) {
        members.removeIf(member -> member.getId().equals(id));
    }

    @Override
    public List<Member> searchMembers(String name) {
        return members.stream()
                .filter(member -> member.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }
}
