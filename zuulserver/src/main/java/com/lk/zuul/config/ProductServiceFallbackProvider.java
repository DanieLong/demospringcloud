package com.lk.zuul.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

@Component
public class ProductServiceFallbackProvider implements ZuulFallbackProvider {
    protected Logger logger = LoggerFactory.getLogger(ProductServiceFallbackProvider.class);

    @Override
    public String getRoute() {
        // 注意: 这里是route的名称，不是服务的名称，
        // 如果这里写成大写PRODUCT-SERVICE将无法起到回退作用
        return "product-service";
    }

    @Override
    public ClientHttpResponse fallbackResponse() {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode(){
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode()  {
                return 200;
            }

            @Override
            public String getStatusText() {
                return "OK";
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody()  {
                return new ByteArrayInputStream("商品服务暂不可用，请稍后重试!".getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
                return headers;
            }
        };
    }
}
