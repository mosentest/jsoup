package org.mo.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

public final class GetUriDataUtil {
	/**
	 * 方法过时，有问题
	 * 
	 * @param uri
	 * @throws HttpException
	 * @throws IOException
	 */
	@Deprecated
	public static void getDataByUri2(String uri) throws HttpException,
			IOException {
		GetMethod getMethod = new GetMethod(uri);
		HttpClient httpClient = new HttpClient();
		httpClient.setConnectionTimeout(1000 * 60);
		int status = 0;
		status = httpClient.executeMethod(getMethod);
		String response = "";
		if (status == HttpStatus.SC_OK) {
			response = getMethod.getResponseBodyAsString();
		} else {
			System.out.println("检索失败");
		}
		getMethod.releaseConnection();
		String regExData = "找到 ([,\\d]*) 个网页"; // 正则表达式来获取([,\\d]*) ，得到命中的条数
		if (response != null && response.trim().length() > 0) {
			Pattern pattern = Pattern.compile(regExData);
			Matcher matcher = pattern.matcher(response);
			if (matcher.find()) {
				if (matcher.groupCount() >= 1) {
					int iTmpInteger = Integer.parseInt(matcher.group(1)
							.replaceAll(",", ""), 10);
					System.out.println("找到" + iTmpInteger + "个网页");
				}
			}
		}
	}

	public static void getDataByUri(String uri) {
		BufferedReader reader = null;
		try {
			URL url = new URL(uri);
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
			String line;
			while ((line = reader.readLine()) != null) {

			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static String createhttpClient(String url, String param) {
		HttpClient client = new HttpClient();
		String response = null;
		String keyword = null;
		GetMethod postMethod = new GetMethod(url);
		try {
			if (param != null)
				keyword = new String(param.getBytes("gb2312"), "ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		try {
			int statusCode = client.executeMethod(postMethod);
			response = new String(postMethod.getResponseBodyAsString()
					.getBytes("ISO-8859-1"), "UTF-8");// 这里要注意下
														// gb2312要和你抓取网页的编码要一样
			String p = response.replaceAll("\\&[a-zA-Z]{1,10};", "")
					.replaceAll("<[^>]*>", "");// 去掉网页中带有html语言的标签
			System.out.println(p);
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}
}
