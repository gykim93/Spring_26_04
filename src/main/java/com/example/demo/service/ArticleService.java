package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.vo.Article;

@Service
public class ArticleService {
	private int lastArticleId;
	public List<Article> articles;

//	서비스메서드
	public ArticleService() {
		articles = new ArrayList<>();
		lastArticleId = 0;

		makeTestData();
	}

	private void makeTestData() {
		for (int i = 1; i <= 10; i++) {
			String title = "제목" + i;
			String body = "내용" + i;

			writeArticle(title, body);
		}
	}

	public Article writeArticle(String title, String body) {
		int id = lastArticleId + 1;

		Article article = new Article(id, title, body);

		articles.add(article);
		lastArticleId++;

		return article;

	}

	public Article getArticleById(int id) {
		for (Article article : articles) {
			if (article.getId() == id) {
				return article;
			}
		}
		return null;
	}

	// 게시글 수정
	@RequestMapping("/usr/article/doModify")
	@ResponseBody
	public void modifyArticle(int id, String title, String body) {
		Article article = getArticleById(id);
		article.setTitle(title);
		article.setBody(body);
	}

	// 게시글 삭제
	@RequestMapping("/usr/article/doDelete")
	@ResponseBody
	public void deleteArticle(int id) {
		Article article = getArticleById(id);
		articles.remove(article);

	}

}
