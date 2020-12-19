package com.canaparro.hw.configuration;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

@Configuration
public class ElasticConfiguration extends AbstractElasticsearchConfiguration {

    @Value("${br.gov.data.occupation.url}")
    private String url;

    @Value("${br.gov.data.occupation.username}")
    private String username;

    @Value("${br.gov.data.occupation.password}")
    private String password;

    @Override
    @Bean
    public RestHighLevelClient elasticsearchClient() {
        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY,new UsernamePasswordCredentials(username, password));
        return new RestHighLevelClient(
                RestClient.builder(HttpHost.create(url))
                        .setHttpClientConfigCallback(httpClientBuilder -> httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider))
        );
    }
}
