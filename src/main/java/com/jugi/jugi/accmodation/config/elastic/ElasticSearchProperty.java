package com.jugi.jugi.accmodation.config.elastic;

import lombok.Getter;
import lombok.Setter;
import org.apache.http.HttpHost;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Getter
@Setter
@ConfigurationProperties(prefix = "elasticsearch")
public class ElasticSearchProperty {

    private List<ElasticSearchProperty.ElasticNode> nodes;

    public static class ElasticNode
    {
        private String ip;
        private Integer port;
        private String protocol;

        public HttpHost getHttpHost()
        {
            return new HttpHost(this.ip, this.port, this.protocol);
        }
    }
}

