package com.adlibmanager.core.service;

import com.adlibmanager.core.domain.Member;
import java.util.List;

public interface MemberService {
    void addMember(Member member);
    void deleteMember(String id);
    List<Member> searchMembers(String name);
}
