package com.guyue.commonweb.util;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.WebUtils;

import com.alibaba.fastjson.JSON;

public class RestClient {

    private static Logger log = LoggerFactory.getLogger(RestClient.class);


    private final RestTemplate restTemplate = new RestTemplate();
    private String token;
    private String baseUrl;

    public RestClient() {
        List<HttpMessageConverter<?>> list = new ArrayList<HttpMessageConverter<?>>();
        List<HttpMessageConverter<?>> converterList = restTemplate.getMessageConverters();
        for (HttpMessageConverter<?> item : converterList) {
            if (item.getClass().equals(StringHttpMessageConverter.class)) {
                list.add(new StringHttpMessageConverter(StandardCharsets.UTF_8));
                break;
            } else {
                list.add(item);
            }
        }
        FormHttpMessageConverter formHttpMessageConverter = new FormHttpMessageConverter();
        formHttpMessageConverter.setCharset(Charset.forName("UTF8"));
        list.add(formHttpMessageConverter);
        list.add(new ResourceHttpMessageConverter());
        restTemplate.setMessageConverters(list);
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    public <T> T post(String url, Map<String, String> params, Class<T> clazz, Object... uriVariables) {
        return exchange(url, HttpMethod.POST, mapToEntity(params), clazz, uriVariables);
    }

    public <T> T postWithMultiFile(String url, MultiValueMap<String, Object> params, Class<T> clazz, Object... uriVariables) {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Content-Type", "multipart/form-data");
        HttpEntity<?> requestEntity = new HttpEntity<MultiValueMap<String, Object>>(params, requestHeaders);
        return exchange(url, HttpMethod.POST, requestEntity, clazz, uriVariables);
    }


    public <T> T postJSON(String url, Map<String, String> params, Class<T> clazz, Object... uriVariables) {
        return this.postJSON(url, JSON.toJSONString(params), clazz, uriVariables);
    }

    public <T> T postJSON(String url, String params, Class<T> clazz, Object... uriVariables) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/json; charset=UTF-8"));
        log.info("RestClient url:{} ,post params:{} ", url, params);
        HttpEntity<String> formEntity = new HttpEntity<String>(params, headers);
        return exchange(url, HttpMethod.POST, formEntity, clazz, uriVariables);
    }


    public <T> T getJSON(String url, Map<String, String> params, Class<T> clazz, Object... uriVariables) {
        if (url.indexOf("?") > -1) {
            url = url + "&" + queryString(params);
        } else {
            url = url + "?" + queryString(params);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/json; charset=UTF-8"));
        HttpEntity<String> formEntity = new HttpEntity<String>("", headers);
        return exchange(url, HttpMethod.GET, formEntity, clazz, uriVariables);
    }

    public <T> T get(String url, Map<String, String> params, Class<T> clazz, Object... uriVariables) {
        if (url.indexOf("?") > -1) {
            url = url + "&" + queryString(params);
        } else {
            url = url + "?" + queryString(params);
        }
        return exchange(url, HttpMethod.GET, mapToEntity(null), clazz, uriVariables);
    }

    public <T> T get(String url, Class<T> clazz, Object... uriVariables) {
        return this.get(url, null, clazz, uriVariables);
    }

    public byte[] getByte(String url, Object... uriVariables) {
        return restTemplate.getForObject(url, byte[].class, uriVariables);
    }

    public <T> T put(String url, Map<String, String> params, Class<T> clazz, Object... uriVariables) {
        return exchange(url, HttpMethod.PUT, mapToEntity(params), clazz, uriVariables);
    }

    private <T> T exchange(String url, HttpMethod method, HttpEntity<?> requestEntity, Class<T> responseType, Object... uriVariables) {
        try {
            if (!StringUtils.isEmpty(this.baseUrl)) {
                url = this.baseUrl + url;
            }
            long startTime = System.currentTimeMillis();
            log.info("req:{},startTime:{}", url, startTime);
            ResponseEntity<String> rep = restTemplate.exchange(url, method, requestEntity, String.class, uriVariables);
            log.info("rep:{},take:{}", rep.getBody(), System.currentTimeMillis() - startTime);
            if (rep.getBody().startsWith("{") || rep.getBody().startsWith("[")) {
                return JSON.parseObject(rep.getBody(), responseType);
            } else {
                return (T) rep.getBody();
            }
        } catch (Throwable e) {
            log.error("RestClientException error {}", e);
        }
        log.error("req is error");
        return null;
    }


    private HttpEntity<String> mapToEntity(Map<String, String> params) {
        HttpHeaders headers = new HttpHeaders();
        //默认管理员角色权限
        if (null != token) {
            headers.set("Authorization", "Basic " + token);
        }
        // headers.set("Authorization", "Basic eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6WyJhZG1pbiJdfQ.IYJ1nyNzGF5F6xX-eCl-rrqdDv0dVUHfzzidU1E9L5c");
        headers.setContentType(MediaType.parseMediaType("application/x-www-form-urlencoded; charset=UTF-8"));
        String queryString = queryString(params);
        log.info("queryString is {}", queryString);
        HttpEntity<String> formEntity = new HttpEntity<String>(queryString, headers);
        return formEntity;
    }

    private String queryString(Map<String, String> params) {
        StringBuffer buffer = new StringBuffer();
        if (params != null && !params.isEmpty()) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                if (entry.getValue() != null) {
//                    try {
//                        buffer.append("&").append(entry.getKey()).append("=").append( URLEncoder.encode(entry.getValue().toString(), "UTF-8"));
//                    } catch (UnsupportedEncodingException e) {
//                       log.error("UnsupportedEncodingException",e);
//                    }
                    buffer.append("&").append(entry.getKey()).append("=").append(entry.getValue());
                }
            }
        }
        return buffer.length() == 0 ? "" : buffer.substring(1);
    }

    public Map<String, String> getParametersStartingWith(HttpServletRequest request, String prefix) {
        Map<String, String> params = new HashMap<String, String>();
        for (Map.Entry<String, Object> entry : WebUtils.getParametersStartingWith(request, prefix).entrySet()) {
            if (!StringUtils.isEmpty(entry.getValue())) {
                params.put(entry.getKey(), entry.getValue().toString());
            }
        }
        return params;
    }


}
