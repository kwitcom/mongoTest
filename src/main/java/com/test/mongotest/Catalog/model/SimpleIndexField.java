package com.test.mongotest.Catalog.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SimpleIndexField implements Serializable {
    public static final String COLLECTION = "Collection";
    public static final String EDM_STRING = "Edm.String";
    public static final String EDM_DOUBLE = "Edm.Double";
    public static final String EDM_INT64 = "Edm.Int64";
    public static final String EDM_DATE_TIME_OFFSET = "Edm.DateTimeOffset";
    public static final String EDM_BOOLEAN = "Edm.Boolean";
    public static final String EDM_COMPLEX_TYPE = "Edm.ComplexType";
    private static final long serialVersionUID = -449755364542615349L;
    private String name, analyzer;
    private Boolean searchable, filterable, retrievable, sortable, facetable, key;
    private String type;
    private List<SimpleIndexField> fields;

//    public static String convertTypeToAzureType(String type, Boolean isCollection) {
//        String returnType = (Objects.nonNull(isCollection) && isCollection == true) ? COLLECTION + "(" + convertToAzureType(type) + ")" : convertToAzureType(type);
//        return returnType;
//    }


//    public static String convertToAzureType(String type, Boolean isCollection) {
//        String returnType = (Objects.nonNull(isCollection) && isCollection) ? COLLECTION + "(" + convertToAzureType(type) + ")" : convertToAzureType(type);
//        return returnType;
//    }

    public static String convertToAzureComplexType(Boolean isCollection) {
        if (!isCollection) {
            return EDM_COMPLEX_TYPE;
        } else {
            return COLLECTION + "(" + EDM_COMPLEX_TYPE + ")";
        }
    }

//    public static String convertToAzureType(String type) {
//
//        switch (type.toLowerCase()) {
//            case STRING:
//                return EDM_STRING;
//            case DOUBLE:
//                return EDM_DOUBLE;
//            case INTEGER:
//                return EDM_INT64;
//            case DATE:
//                return EDM_DATE_TIME_OFFSET;
//            case BOOLEAN:
//                return EDM_BOOLEAN;
//            default:
//                return EDM_STRING;
//        }
//
//    }

//    public static SimpleIndexField convertToSimpleIndexField(SearchField field) {
//        return SimpleIndexField.builder()
//                .name(field.getFieldName())
//                .key(field.getKey())
//                .type(SimpleIndexField.convertTypeToAzureType(field.getType(), field.getCollection()))
//                .filterable(field.getFilterable())
//                .facetable(field.getFacetable())
//                .retrievable(field.getRetrievable())
//                .searchable(field.getSearchable())
//                .sortable(field.getSortable())
////				.analyzer(getFieldAnalyzer(field.getAnalyzer()))
//                .build();
//    }

	/*private static String getFieldAnalyzer(String fieldAnalyzer) {
		return StringUtils.isAllEmpty(fieldAnalyzer) ? "fr.lucene" : fieldAnalyzer;
	}*/
}
