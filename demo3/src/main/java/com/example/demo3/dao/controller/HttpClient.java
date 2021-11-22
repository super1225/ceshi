package com.example.demo3.dao.controller;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletResponse;
@Service
public class HttpClient {
    public String client(String url, HttpMethod method, MultiValueMap<String,String> params){
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> response1 = template.getForEntity(url,String.class );
        return response1.getBody();


    }






    @Configuration
    public class RestTempleConfig {

        private Integer connectionRequestTimeout = 3000;
        private Integer connectTimeout = 3000;
        private Integer readTimeout = 3000;

        // 启动的时候要注意，由于我们在controller中注入了RestTemplate，所以启动的时候需要实例化该类的一个实例
        @Autowired
        private RestTemplateBuilder builder;

        // 使用RestTemplateBuilder来实例化RestTemplate对象，spring默认已经注入了RestTemplateBuilder实例
        @Bean
        public RestTemplate restTemplate() {
            return builder.build();
        }

        @Bean
        public RestTemplate customRestTemplate() {
            HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
            httpRequestFactory.setConnectionRequestTimeout(connectionRequestTimeout);
            httpRequestFactory.setConnectTimeout(connectTimeout);
            httpRequestFactory.setReadTimeout(readTimeout);
            return new RestTemplate(httpRequestFactory);
        }
    }

}
