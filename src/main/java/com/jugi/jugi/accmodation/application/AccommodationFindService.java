package com.jugi.jugi.accmodation.application;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.query_dsl.FieldAndFormat;
import co.elastic.clients.elasticsearch._types.query_dsl.MatchQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch._types.query_dsl.TermQuery;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.json.JsonData;
import com.jugi.jugi.accmodation.global.AccommodationDto;
import com.jugi.jugi.accmodation.web.dto.AccommodationFindRequest;
import com.jugi.jugi.accmodation.web.dto.AccommodationFindResult;
import io.github.classgraph.AnnotationInfoList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class AccommodationFindService {

    private final ElasticsearchClient client;

    public List<AccommodationFindResult> findResult(AccommodationFindRequest request, int skip, int size) throws IOException
    {

        Query byName = MatchQuery.of(m -> m
                .field("name")
                .query(request.getSearch())
        )._toQuery();

        Query businessType = TermQuery.of(m ->
                m
                        .field("businessType.keyword")
                        .value("HOTEL")
        )._toQuery();

        Query byAddress = MatchQuery.of(m -> m
                .field("address")
                .query(request.getSearch())
        )._toQuery();

        Query byStreetAddress = MatchQuery.of(m -> m
                .field("streetNameAddress")
                .query(request.getSearch())
        )._toQuery();

        SearchResponse<AccommodationFindResult> response = client.search(s -> s
                            .index("accommodation")
                            .query(q -> q
                                    .bool(b -> b
                                            .should(byName)
                                            .should(byAddress)
                                            .should(byStreetAddress)
                                            .must(businessType)
                                    )
                            )
                        .from(skip)
                        .size(size)
                        ,
                    AccommodationFindResult.class
            );

        List<Hit<AccommodationFindResult>> hits = response.hits().hits();
        List<AccommodationFindResult> results = new ArrayList<>();

        for (Hit<AccommodationFindResult> hit : hits)
        {
            AccommodationFindResult accommodationFindResult = hit.source();
            results.add(accommodationFindResult);
        }

        return results;
    }
}
