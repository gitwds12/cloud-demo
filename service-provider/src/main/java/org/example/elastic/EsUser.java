package org.example.elastic;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Document(indexName = "users", type = "user")
public class EsUser {

    @Id
    private int id;
    @Field(analyzer = "ik_max_word",type = FieldType.Text)
    private String es_username;
    private String password;
    private int age;

}
