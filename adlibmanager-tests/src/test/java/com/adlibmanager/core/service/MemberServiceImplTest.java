package com.adlibmanager.core.service;

import com.adlibmanager.core.domain.Member;
import com.adlibmanager.db.service.MemberServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

public class MemberServiceImplTest {

    private MemberService memberService;

    @Before
    public void setUp() {
        memberService = new MemberServiceImpl();
    }

    @Test
    public void shouldAddAndFindMember() {
        Member member = new Member("m101", "Alice Test", "alice@test.com", LocalDate.now());
        memberService.addMember(member);

        List<Member> found = memberService.searchMembers("Alice");
        assertFalse(found.isEmpty());
        assertEquals("Alice Test", found.get(0).getName());
    }

    @Test
    public void shouldDeleteMemberById() {
        Member member = new Member("m102", "Bob Delete", "bob@delete.com", LocalDate.now());
        memberService.addMember(member);
        memberService.deleteMember("m102");

        List<Member> found = memberService.searchMembers("Bob");
        assertTrue(found.isEmpty());
    }
}