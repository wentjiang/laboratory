package com.wentjiang.laboratory.remote;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsAsyncClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * Created by jiangwentao on 2017/7/14 16:24.
 */
@Slf4j
public class RemoteRequest {
    private static MediaType contentType = new MediaType(MediaType.APPLICATION_FORM_URLENCODED.getType(), MediaType.APPLICATION_FORM_URLENCODED.getSubtype(), StandardCharsets.UTF_8);

    public static void main(String[] args) {
        HttpComponentsAsyncClientHttpRequestFactory requestFactory = new HttpComponentsAsyncClientHttpRequestFactory();
        requestFactory.setConnectTimeout(5000);
        requestFactory.setReadTimeout(5000);

        RestTemplate restTemplate = new RestTemplate(requestFactory);
        String url = "http://data.csgo.com.cn/csgoMatch/teams/10006";
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN));
        headers.setContentType(contentType);
        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(params, headers);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, httpEntity, String.class);
        log.info("request {} with {}", url, httpEntity);
        if (!Integer.toString(responseEntity.getStatusCode().value()).startsWith("2")) {
            log.warn("http request failed status={}, url={}", responseEntity.getStatusCode(), url);
            throw new RuntimeException("remote http request failed");
        }
        log.info("response {}", responseEntity.getBody());

//        return JSON.parseObject(responseEntity.getBody());
    }
}
