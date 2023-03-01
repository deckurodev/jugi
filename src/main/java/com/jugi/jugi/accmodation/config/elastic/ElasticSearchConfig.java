package com.jugi.jugi.accmodation.config.elastic;


import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Configuration
public class ElasticSearchConfig {

    private final ElasticSearchProperty elasticSearchProperty;

    @Bean
    public ElasticsearchClient elasticsearchClient()
    {
        RestClient httpClient = RestClient.builder(
                new HttpHost("localhost", 9200))
                .build();

        ElasticsearchTransport transport = new RestClientTransport(
                httpClient,
                new JacksonJsonpMapper()
        );

        return new ElasticsearchClient(transport);
    }

}

