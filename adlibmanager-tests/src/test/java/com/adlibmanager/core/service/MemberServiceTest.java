package com.adlibmanager.core.service;

import com.adlibmanager.core.domain.Member;
import com.adlibmanager.db.service.MemberServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

public class MemberServiceTest {

    private MemberService memberService;

    @Before
    public void setUp() {
        memberService = new MemberServiceImpl(); // direct implementation
    }

    @Test
    public void shouldAddMemberAndSearchByName() {
        Member member = new Member("1", "Ali Khan", "ali@example.com", LocalDate.now());
        memberService.addMember(member);

        List<Member> results = memberService.searchMembers("Ali");
        assertEquals(1, results.size());
        assertEquals("Ali Khan", results.get(0).getName());
    }

    @Test
    public void shouldDeleteMemberById() {
        Member member = new Member("2", "Sara Smith", "sara@example.com", LocalDate.now());
        memberService.addMember(member);

        memberService.deleteMember("2");

        List<Member> results = memberService.searchMembers("Sara");
        assertEquals(0, results.size());
    }
}
