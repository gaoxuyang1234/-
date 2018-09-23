package com.yxysoft.utils.weixin.beans.message.resp.news;

import java.util.List;

import com.yxysoft.utils.weixin.beans.message.resp.BaseMessage;
/**
 * ClassName: NewsMessage
 * @Description: 回复图文消息
 * @author 杨书元
 * @date Aug 3, 2015
 */
public class NewsMessage extends BaseMessage {
	public int ArticleCount ;
	private List<Articles> Articles ;
	public int getArticleCount() {
		return ArticleCount;
	}
	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}
	public List<Articles> getArticles() {
		return Articles;
	}
	public void setArticles(List<Articles> articles) {
		this.Articles = articles;
	}
	

}
