package com.guyue.commonweb.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpClientUtil {

	private static Log log = LogFactory.getLog(HttpClientUtil.class);
	/**
	 * httpGet
	 * 
	 * @param url
	 * @param headerParams
	 * @param requestParams
	 * @return
	 */
	public static String httpGet(String url, Map<String, String> headerParams,
			Map<String, String> requestParams) {

		String str = null;
		HttpGet httpGet = null;
		HttpClient httpClient = HttpClientBuilder.create().build();// new DefaultHttpClient();

		try {
			// 参数设置
			StringBuilder builder = new StringBuilder(url);
			builder.append("?");
			for (Map.Entry<String, String> entry : requestParams.entrySet()) {
				builder.append((String) entry.getKey());
				builder.append("=");
				builder.append((String) entry.getValue());
				builder.append("&");
			}

			String tmpUrl = builder.toString();
			tmpUrl = tmpUrl.substring(0, tmpUrl.length() - 1);

			httpGet = new HttpGet(tmpUrl);

			if (headerParams != null) {
				for (Map.Entry<String, String> entry : headerParams.entrySet()) {
					httpGet.setHeader(entry.getKey(), entry.getValue());
				}
			}

			HttpResponse response = httpClient.execute(httpGet);

			// reponse header
			log.info(response.getStatusLine().getStatusCode());

			Header[] headers = response.getAllHeaders();
			for (Header header : headers) {
				log.info(header.getName() + ": " + header.getValue());
			}

			// 网页内容
			HttpEntity httpEntity = response.getEntity();
			str = EntityUtils.toString(httpEntity);
			log.info(str);
		} catch (ClientProtocolException e) {
			log.error(e);
		} catch (IOException e) {
			log.error(e);
		} finally {
			if (httpGet != null) {
				httpGet.abort();
			}
		}
		return str;
	}
	/**
	 * httpGet
	 * 
	 * @param url
	 * @param headerParams
	 * @param requestParams
	 * @return
	 */
	public static String httpGet(String url) {

		String str = null;
		HttpGet httpGet = null;
		HttpClient httpClient = HttpClientBuilder.create().build();// new DefaultHttpClient();

		try {
			httpGet = new HttpGet(url);
			HttpResponse response = httpClient.execute(httpGet);
			// reponse header
			log.info(response.getStatusLine().getStatusCode());

			Header[] headers = response.getAllHeaders();
			for (Header header : headers) {
				log.info(header.getName() + ": " + header.getValue());
			}
			// 网页内容
			HttpEntity httpEntity = response.getEntity();
			str = EntityUtils.toString(httpEntity);
			log.info(str);
		} catch (ClientProtocolException e) {
			log.error(e);
		} catch (IOException e) {
			log.error(e);
		} finally {
			if (httpGet != null) {
				httpGet.abort();
			}
		}
		return str;
	}

	/**
	 * httpPost
	 * 
	 * @param url
	 * @param headerParams
	 * @param requestParams
	 * @param urlEncode
	 * @return
	 */
	public static String httpPost(String url, Map<String, String> headerParams,
			Map<String, String> requestParams, String urlEncode) {

		String str = null;
		HttpPost httpPost = null;
		HttpClient httpClient =  HttpClientBuilder.create().build();// new DefaultHttpClient();

		try {
			// 参数设置
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			for (Map.Entry<String, String> entry : requestParams.entrySet()) {
				params.add(new BasicNameValuePair((String) entry.getKey(),
						(String) entry.getValue()));
			}

			httpPost = new HttpPost(url);
			httpPost.setEntity(new UrlEncodedFormEntity(params, urlEncode));

			if (headerParams != null) {
				for (Map.Entry<String, String> entry : headerParams.entrySet()) {
					httpPost.setHeader(entry.getKey(), entry.getValue());
				}
			}

			// reponse header
			HttpResponse response = httpClient.execute(httpPost);
			log.info(response.getStatusLine().getStatusCode());

			Header[] headers = response.getAllHeaders();
			for (Header header : headers) {
				log.info(header.getName() + ": " + header.getValue());
			}

			// 网页内容
			HttpEntity httpEntity = response.getEntity();
			str = EntityUtils.toString(httpEntity);
		} catch (UnsupportedEncodingException e) {
			log.error(e);
		} catch (ClientProtocolException e) {
			log.error(e);
		} catch (IOException e) {
			log.error(e);
		} finally {
			if (httpPost != null) {
				httpPost.abort();
			}
		}
		return str;
	}

	/**
	 * httpPostBody
	 * 
	 * @param url
	 * @param headerParams
	 * @param requestParams
	 * @param urlEncode
	 * @return
	 */
	public static String httpPostBody(String url,
			Map<String, String> headerParams, JSONObject requestParams,
			String urlEncode) {

		String str = null;
		HttpPost httpPost = null;
		HttpClient httpClient =  HttpClientBuilder.create().build();// new DefaultHttpClient();

		try {
			StringEntity entity = new StringEntity(requestParams.toString(),
					urlEncode);
			entity.setContentEncoding(urlEncode);
			entity.setContentType("application/json");

			log.info(requestParams.toString());

			httpPost = new HttpPost(url);
			httpPost.setEntity(entity);

			if (headerParams != null) {
				for (Map.Entry<String, String> entry : headerParams.entrySet()) {
					httpPost.setHeader(entry.getKey(), entry.getValue());
				}
			}

			// reponse header
			HttpResponse response = httpClient.execute(httpPost);
			log.info(response.getStatusLine().getStatusCode());

			Header[] headers = response.getAllHeaders();
			for (Header header : headers) {
				log.info(header.getName() + ": " + header.getValue());
			}

			// 网页内容
			HttpEntity httpEntity = response.getEntity();
			str = EntityUtils.toString(httpEntity);
		} catch (UnsupportedEncodingException e) {
			log.error(e);
		} catch (ClientProtocolException e) {
			log.error(e);
		} catch (IOException e) {
			log.error(e);
		} finally {
			if (httpPost != null) {
				httpPost.abort();
			}
		}
		return str;
	}
}
