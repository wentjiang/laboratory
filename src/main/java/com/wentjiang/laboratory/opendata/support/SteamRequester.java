package com.wentjiang.laboratory.opendata.support;

import com.wentjiang.laboratory.httpclient.SteamHelper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;

import java.io.IOException;
import java.text.MessageFormat;

/**
 * Created by jiangwentao on 2017/8/21 12:15.
 */
public class SteamRequester {

    private static final String SEARCH_COMMUNITY_URL = "https://steamcommunity.com/search/users";

    private HttpClientBuilder httpClientBuilder;

    public SteamRequester(HttpClientBuilder builder) {
        httpClientBuilder = builder;
    }

    public SearchInfo getSearchInfo(String key, int page) {
        String result = null;
        String sessionId = null;
        HttpGet communityGet = new HttpGet(SEARCH_COMMUNITY_URL);
        String url = "https://steamcommunity.com/search/SearchCommunityAjax?text={0}&sessionid={1}&filter=users&steamid_user=false&page={2}";
//        CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(new BasicCookieStore()).build();
        HttpClient httpClient = httpClientBuilder.getClient();

        HttpClientContext context = new HttpClientContext();
        try {
            httpClient.execute(communityGet, context);

            sessionId = HttpUtil.getCookie(context, "sessionid");

            String requestUrl = MessageFormat.format(url, key, sessionId, page);
            System.out.println(requestUrl);

            HttpGet httpGet = new HttpGet(requestUrl);

            HttpUtil.addHttpHeads(httpGet, SteamHelper.SEARCH_COMMUNITY_URL, true);

            HttpResponse response = httpClient.execute(httpGet, context);

            result = String.valueOf(response.getStatusLine().getStatusCode());
            System.out.println(result + " page : " + page );

            String contentResult = HttpUtil.getResponseContent(response);

        } catch (IOException e) {
            e.printStackTrace();
        }
        SearchInfo searchInfo = new SearchInfo();
        searchInfo.setInfo(result);
        return searchInfo;
    }

}
