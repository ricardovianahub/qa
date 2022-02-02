package com.aa.homework.debbie;

import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLContext;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.io.Resource;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

// when I send pieripa though postman, I want to see response success

public class PieripaTest {
    @Value("${server.ssl.key-store}")
    private Resource keyStore;   // inject keystore specified in config

    @Value("${server.ssl.key-store-password}")
    private String keyStorePassword;  // inject password from config

    @Value("${example}")
    private String example;

    @LocalServerPort
    protected int port;   // server port picked randomly at runtime

    private TestRestTemplate testRestTemplate;

    private ObjectMapper objectMapper;
    private TestRestTemplate restTemplate;

    //    @BeforeEach
    public void setup() throws Exception {
        SSLContext sslContext = new SSLContextBuilder()
                .loadTrustMaterial(
                        keyStore.getURL(),
                        keyStorePassword.toCharArray()
                ).build();
        SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(sslContext);
        CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(socketFactory).build();
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(
                httpClient);
        RestTemplateBuilder rtb = new RestTemplateBuilder()
                .requestFactory(() -> factory)
                .rootUri("https://localhost:" + port);
        this.testRestTemplate = new TestRestTemplate(rtb, null, null, TestRestTemplate.HttpClientOption.SSL);
    }

    @Test
    void example() {
        System.out.printf("Example: %s%n", example);
    }

    //    @Test
    void test() throws JsonProcessingException {
        objectMapper = new ObjectMapper();
        String response = testRestTemplate.getForObject("http://aacloud.qa.esoa.qcorpaa.aa.com/api/deniedboardingaccomodation/v1/", String.class);
        List<Map> lines = objectMapper.readValue(response, List.class);
        System.out.println(lines.get(0));
        //assertTrue("");
    }
}

