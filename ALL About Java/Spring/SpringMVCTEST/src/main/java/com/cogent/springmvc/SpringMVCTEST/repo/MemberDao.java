package com.cogent.springmvc.SpringMVCTEST.repo;

import java.util.List;

import com.cogent.springmvc.SpringMVCTEST.domain.Member;

public interface MemberDao
{
    public Member findById(Long id);

    public Member findByEmail(String email);

    public List<Member> findAllOrderedByName();

    public void register(Member member);
}
