package com.test.mongotest.Catalog.model;

import lombok.*;

import java.io.Serializable;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Suggestor implements Serializable {

    private static final String ANALYZING_INFIX_MATCHING = "analyzingInfixMatching";
    private static final long serialVersionUID = 9104708687005676670L;

    private String name, searchMode;
    private List<String> sourceFields;

//    public static Optional<Suggestor> convertToSuggestor(List<SearchField> searchFields, String suggestorName) {
//        List<String> suggestorFields = searchFields.parallelStream()
//                .filter(f -> (Objects.nonNull(f.getSuggestable()) && f.getSuggestable()))
//                .map(SearchField::getFieldName)
//                .collect(Collectors.toList());
//        Optional<Suggestor> suggestor = Optional.empty();
//        if (CollectionUtils.isNotEmpty(suggestorFields)) {
//            return Optional.of(Suggestor.builder().name(suggestorName).searchMode(ANALYZING_INFIX_MATCHING).sourceFields(suggestorFields).build());
//        } else {
//            return suggestor;
//        }
//
//    }

}
