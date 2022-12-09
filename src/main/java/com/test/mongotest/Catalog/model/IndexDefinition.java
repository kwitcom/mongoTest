package com.test.mongotest.Catalog.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class IndexDefinition implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter(value = AccessLevel.NONE)
    private List<SimpleIndexField> fields;
    private List<Suggestor> suggesters;
    private String name;


    public IndexDefinition(String name, List<SimpleIndexField> fields, List<Suggestor> suggesters) {
        this.setName(name);
        this.setFields(fields);
        this.setSuggesters(suggesters);
    }

    public IndexDefinition(String name, List<SimpleIndexField> fields) {
        this.setName(name);
        this.setFields(fields);
    }

//    public List<SimpleIndexField> getFields() {
//        if (CollectionUtils.isEmpty(fields)) {
//            fields = new ArrayList<>();
//            this.setFields(fields);
//        }
//        return fields;
//    }

//    public Optional<SimpleIndexField> getFieldByName(String fieldName) {
//        return this.getFields().stream().filter(f -> StringUtils.equals(fieldName, f.getName())).findAny();
//    }

}
