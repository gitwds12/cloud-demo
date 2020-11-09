package org.example.elastic;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EsUserDao extends ElasticsearchRepository<EsUser, Integer> {

}
