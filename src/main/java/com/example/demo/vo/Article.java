package com.example.demo.vo;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class Article{
	
	public Article(String title, String body) {
		this.title = title;
		this.body = body;
	}
	
	int id;
	LocalDateTime regDate;
	LocalDateTime updateDate;
	String title;
	String body;
}
