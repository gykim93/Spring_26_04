package com.example.demo.repository;

import java.lang.reflect.Member;

import org.apache.ibatis.annotations.Mapper;
import com.example.demo.vo.Article;
@Mapper
public interface MemberRepository {
	public int doJoin(String loginId, String loginPw, String name, String nickname, String cellphoneNum, String email);
	
	public Member getMemberById(int id);
	
	public int getLastInsertId();
}
