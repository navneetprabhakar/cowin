package com.cowin.apis.utils;

import com.cowin.apis.exception.SystemException;
import com.cowin.apis.models.StatesAPIResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * REST API utils
 * @author navneetprabhakar
 */
@Log4j2
@Service
public class RestUtils {

    @Autowired
    private RestTemplate restTemplate;

    private final ObjectMapper mapper=new ObjectMapper();


    /**
     * This method makes HTTP GET REST API call
     * @param url : Base URL
     * @param httpHeaders : HTTP Headers if any
     * @param queryParams : Query param key value pair
     * @return @{@link ResponseEntity}
     */
    public <T> T restGetCall(final String url, final HttpHeaders httpHeaders,
                             final Map<String, String> queryParams, Class<T> className) throws IOException{
        ResponseEntity<String> responseEntity=restGetCall(url, httpHeaders, queryParams);
        log.info("Response received from CoWin Service:{}", responseEntity);
        if(responseEntity.getStatusCode().equals(HttpStatus.OK)){
            return mapper.readValue(responseEntity.getBody(), className);
        }else{
            throw new SystemException(responseEntity.getBody(), responseEntity.getStatusCode());
        }
    }

    /**
     * This method makes HTTP GET REST API call
     * @param url : Base URL
     * @param httpHeaders : HTTP Headers if any
     * @param queryParams : Query param key value pair
     * @return @{@link ResponseEntity}
     */
    public <T> T restPostCall(final String url, final HttpHeaders httpHeaders,
                              final Map<String, String> queryParams, final Object request, Class<T> className) throws IOException{
        ResponseEntity<String> responseEntity=restPostCall(url, httpHeaders, queryParams, request);
        log.info("Response received from CoWin Service:{}", responseEntity);
        if(responseEntity.getStatusCode().equals(HttpStatus.OK)){
            return mapper.readValue(responseEntity.getBody(), className);
        }else{
            throw new SystemException(responseEntity.getBody(), responseEntity.getStatusCode());
        }
    }

    private ResponseEntity<String> restGetCall(final String url, final HttpHeaders httpHeaders,
              final Map<String, String> queryParams) throws IOException{
        HttpEntity<?> entity = new HttpEntity<>(httpHeaders);
        String uri = url;
        if (null != queryParams && !queryParams.isEmpty()) {
            uri = addQueryParameters(queryParams, uri);
        }
        log.info("Request url:{} headers:{} queryParams:{}", uri, httpHeaders, queryParams);
        return restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
    }

    private ResponseEntity<String> restPostCall(final String url, final HttpHeaders httpHeaders,
              final Map<String, String> queryParams, final Object request) throws IOException {
        HttpEntity<?> entity = new HttpEntity<>(mapper.writeValueAsString(request),httpHeaders);
        String uri = url;
        if (null != queryParams && !queryParams.isEmpty()) {
            uri = addQueryParameters(queryParams, uri);
        }
        log.info("Request url:{} headers:{} queryParams:{} body:{}", uri, httpHeaders, queryParams, mapper.writeValueAsString(request));
        return restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
    }


    /**
     * This method add query parameters to the base url and returns URL encoded value
     * @param queryParams : Query param key value pair
     * @param url : Base Url
     * @return url: URL with query parameters
     * @throws IOException
     */
    private String addQueryParameters(final Map<String, String> queryParams, final String url)
            throws IOException {
        try {
            List<NameValuePair> params = new ArrayList<>();
            for (Map.Entry<String, String> entry : queryParams.entrySet()) {
                params.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            return new URIBuilder(url).addParameters(params).build().toString();
        } catch (URISyntaxException ex) {
            throw new IOException(ex);
        }
    }
}
