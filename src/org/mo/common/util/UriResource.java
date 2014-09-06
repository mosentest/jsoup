package org.mo.common.util;

public class UriResource {
	// 需要获取资源的目标地址，不包含查询串
	private String target;
	// get请求时的查询串，或post请求的请求数据
	private String queryData = "";
	// 请求方式，get / post
	private String method = "GET";
	// 返回的数据的编码类型
	private String charset = "GBK";
	// 抓取数据的模式，将根据模式的分组来返回数据列表
	private String pattern;

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getQueryData() {
		return queryData;
	}

	public void setQueryData(String queryData) {
		this.queryData = queryData;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

}
