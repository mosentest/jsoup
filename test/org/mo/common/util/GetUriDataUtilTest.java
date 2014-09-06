package org.mo.common.util;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;
import org.junit.Test;

public class GetUriDataUtilTest {

	@Test
	public void testGetDataByUri() throws HttpException, IOException {
		String url="http://www.cwl.gov.cn/kjxx/ssq/hmhz/";
		String param="彩票";
		String response=GetUriDataUtil.createhttpClient(url, param);
	}

}
