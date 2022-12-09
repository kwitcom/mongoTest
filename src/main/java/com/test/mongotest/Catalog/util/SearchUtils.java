package com.test.mongotest.Catalog.util;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public final class SearchUtils {

//
//    public static void mapInsertFields(final Map<String, Object> pwcAsset, final List<SimpleIndexField> fields, Map<String, Object> populatedFields, final String serviceType) {
//        if (Objects.nonNull(fields) && !fields.isEmpty() && Objects.nonNull(pwcAsset) && !pwcAsset.isEmpty()) {
//            fields.stream()
//                    .forEach(sif -> {
//                        String indexFieldName = sif.getName();
//                        Object assetFieldVal = pwcAsset.get(indexFieldName);
//
//                        formatDates(populatedFields, sif, indexFieldName, assetFieldVal);
//                        if (Objects.nonNull(sif.getFields())
//                                && Objects.isNull(populatedFields.get(indexFieldName))) {
//                            populatedFields.put(indexFieldName, new HashMap<>());
//                            Map<String, Object> populatedSubFields = (Map<String, Object>) populatedFields.get(indexFieldName);
//                            mapInsertFields(pwcAsset, sif.getFields(), populatedSubFields, serviceType);
//                            if (isSubFieldsEmpty(populatedSubFields)) {
//                                populatedFields.put(indexFieldName, null);
//                            }
//                        }
//                    });
//        }
//    }
//
//    public static List<SimpleIndexField> extractValidFields(final List<SimpleIndexField> fields, final String typeIdentifier) {
//        if (StringUtils.isBlank(typeIdentifier)) {
//            return fields;
//        }
//        List<String> customFieldNames = fields.parallelStream()
//                .filter(f -> f.getName().contains(typeIdentifier))
//                .map(fn -> fn.getName())
//                .collect(Collectors.toList());
//
//        List<SimpleIndexField> validSearchFields = fields.parallelStream()
//                .filter(f -> !(customFieldNames.contains(f.getName()) && !f.getName().contains(typeIdentifier)))
//                .collect(Collectors.toList());
//
//        return validSearchFields;
//    }
//
//    public static void mapInsertFieldsComplex
//            (Map<String, Object> pwcAsset, List<SimpleIndexField> fields, Map<String, Object> populatedFields) {
//        if (Objects.isNull(fields)
//                || fields.isEmpty()
//                || Objects.isNull(pwcAsset)
//                || pwcAsset.isEmpty()) {
//            return;
//        }
//        fields.stream()
//                .forEach(f -> {
//                    String keyName = f.getName();
//                    Object assetAttrVal = pwcAsset.get(keyName);
//                    if (Objects.nonNull(f.getFields())
//                            && Objects.nonNull(assetAttrVal)) {
//                        if (assetAttrVal.getClass().isArray()) {
//                            Object[] subValues = (Object[]) assetAttrVal;
//                            ArrayList<Object> list = new ArrayList<>();
//                            populatedFields.put(keyName, list);
//                            for (Object m : subValues) {
//                                Map<String, Object> map = new HashMap<>();
//                                list.add(map);
//                                populateFieldBasedOnType(map, f, m);
//                            }
//                        } else if (assetAttrVal instanceof List) {
//                            List<Object> subValues = (List<Object>) assetAttrVal;
//                            ArrayList<Object> list = new ArrayList<>();
//                            populatedFields.put(keyName, list);
//                            for (Object m : subValues) {
//                                Map<String, Object> map = new HashMap<>();
//                                list.add(map);
//                                populateFieldBasedOnType(map, f, m);
//                            }
//                        } else if (assetAttrVal instanceof Map) {
//                            Map<String, Object> populatedSubFields = (Map<String, Object>) populatedFields.get(keyName);
//                            mapInsertFieldsComplex((Map<String, Object>) assetAttrVal, f.getFields(), populatedSubFields);
//                        }
//                    } else {
//                        formatDates(populatedFields, f, keyName, assetAttrVal);
//                    }
//                });
//    }
//
//    private static void populateFieldBasedOnType(Map<String, Object> populatedFields, SimpleIndexField f, Object m) {
//        if (m instanceof Map) {
//            mapInsertFieldsComplex((Map<String, Object>) m, f.getFields(), populatedFields);
//        }
//    }
//
//    public static void mapRelations(Map<String, Object> relAttributes, List<SimpleIndexField> fields, Map<String, Object> populatedFields) {
//        log.info(convertObjectToJsonString(relAttributes));
//        List<SimpleIndexField> relations = fields.stream()
//                .filter(f -> f.getName().equalsIgnoreCase(RELATIONS))
//                .collect(Collectors.toList());
//        if (Objects.isNull(relAttributes)
//                || relAttributes.isEmpty()) {
//            populatedFields.remove(RELATIONS);
//            return;
//        }
//        populatedFields.put(RELATIONS, new HashMap<>());
//        Map<String, Object> relationsInSearch = (Map<String, Object>) populatedFields.get(RELATIONS);
//        relations.get(0).getFields().stream()
//                .filter(f -> Objects.nonNull(relAttributes.get(f.getName())))
//                .forEach(f -> {
//                    String relFieldName = f.getName();
//                    Object relFieldValues = relAttributes.get(relFieldName);
//
//                    if (relFieldValues instanceof Map) {
//                        Map<String, Object> finalMap = addRelValuesForMap((Map<String, Object>) relFieldValues);
//                        relationsInSearch.put(relFieldName, finalMap);
//                    } else if (relFieldValues instanceof List) {
//                        List relationsList = addRelValuesForList((List<Map<String, Object>>) relFieldValues);
//                        relationsInSearch.put(relFieldName, relationsList);
//                    } else if (relFieldValues instanceof Object[]) {
//                        List relationsList = addRelValuesForObjectList((Object[]) relFieldValues);
//                        relationsInSearch.put(relFieldName, relationsList);
//                    }
//                });
//
//        if (relAttributes.containsKey(PWC_CLIENT)) {
//            Map<String, Object> clientDetails = (Map<String, Object>) relAttributes.get(PWC_CLIENT);
//            String clientId = clientDetails.get(ID).toString().trim();
//            String validClientId = clientId.startsWith(NEGATIVE) ? clientId.substring(1) : clientId;
//            String clientName = clientDetails.get(NAME).toString().trim();
//
//            if(clientName.isEmpty()) {
//                log.warn(String.format("Any null or empty attributes are not acceptable.  Response from populatedFields: {%s}", populatedFields));
//                throw new PwCBadRequestException(String.format("Invalid value for client_name: {%s} in the request: {%s}", populatedFields.get(clientName), populatedFields));
//            }
//
//            populatedFields.put(CLIENT_ID, validClientId);
//            populatedFields.put(CLIENT_NAME, clientName);
//        }
//
//        if (relAttributes.containsKey(WORKSPACE)) {
//            Map<String, Object> workspaceDetails = (Map<String, Object>) relAttributes.get(WORKSPACE);
//            String workspaceId = workspaceDetails.get(ID).toString().trim();
//            String validWorkspaceId = workspaceId.startsWith(NEGATIVE) ? workspaceId.substring(1) : workspaceId;
//            String workspaceName = NOT_AVAILABLE;
//            if (Objects.nonNull(workspaceDetails.get(NAME))) {
//                workspaceName = workspaceDetails.get(NAME).toString().trim();
//            }
//
//            populatedFields.put(WORKSPACE_ID, validWorkspaceId);
//            populatedFields.put(WORKSPACE_NAME, workspaceName);
//            if (workspaceDetails.containsKey(CLIENT_ID)) {
//                populatedFields.put(CLIENT_ID, workspaceDetails.get(CLIENT_ID));
//                populatedFields.put(CLIENT_NAME, workspaceDetails.get(CLIENT_NAME));
//            }
//        }
//    }
//
//    private static Map<String, Object> addRelValuesForMap(Map<String, Object> relFieldValues) {
//        Map<String, Object> finalMap = new HashMap<>();
//        Map<String, Object> assetRelValue = relFieldValues;
//        updateRelatedAssetInfo(finalMap, assetRelValue);
//        return finalMap;
//    }
//
//    private static List addRelValuesForList(List<Map<String, Object>> relFieldValues) {
//        List<Map<String, Object>> assetList = relFieldValues;
//        return assetList.stream().map(a -> {
//            Map<String, Object> finalMap = new HashMap<>();
//            updateRelatedAssetInfo(finalMap, a);
//            return finalMap;
//        }).collect(Collectors.toList());
//    }

//    private static List addRelValuesForObjectList(Object[] relFieldValues) {
//        List relationsList = new ArrayList();
//        for (Object r : relFieldValues) {
//            if (r instanceof Map) {
//                Map<String, Object> finalMap = new HashMap<>();
//                updateRelatedAssetInfo(finalMap, (Map<String, Object>) r);
//                relationsList.add(finalMap);
//            }
//        }
//        return relationsList;
//    }
//
//    private static void updateRelatedAssetInfo(Map<String, Object> finalMap, Map<String, Object> assetRelValue) {
//        Object assetId = assetRelValue.get(ID);
//        if (Objects.isNull(assetId)) {
//            throw new PwCInternalException("Related asset id missing while indexing in search");
//        }
//        finalMap.put(ID, (assetId.toString().startsWith(NEGATIVE)) ? assetId.toString().substring(1) : assetId);
//        finalMap.put(TYPE_NAME, assetRelValue.get(TYPE_NAME));
//    }
//
//    public static void mapClassifications
//            (Map<String, Object> classificationAttributes, List<SimpleIndexField> fields, Map<String, Object> populatedFields) {
//
//        List<SimpleIndexField> classifications = isClassificationIndexable(classificationAttributes, fields, populatedFields);
//        if (Objects.isNull(classifications)) return;
//        Map<String, Object> classificationsInSearch = (Map<String, Object>) populatedFields.get(CLASSIFICATIONS);
//        classifications.get(0).getFields()
//                .stream()
//                .filter(field -> Objects.nonNull(classificationAttributes.get(field.getName())))
//                .forEach(f -> {
//                    String key = f.getName();
//                    Object classValues = classificationAttributes.get(key);
//                    if (classValues instanceof Map) {
//                        classificationsInSearch.put(key, classValues);
//                    } else if (classValues instanceof List) {
//                        List classificationsList = addClassificationValuesList((List<Object>) classValues);
//                        classificationsInSearch.put(key, classificationsList);
//                    } else if (classValues instanceof Object[]) {
//                        List classificationsList = addClassificationValuesObject((Object[]) classValues);
//                        classificationsInSearch.put(key, classificationsList);
//                    } else {
//                        classificationsInSearch.put(key, Collections.singletonMap(NAME, classValues));
//                    }
//                });
//    }
//
//    public static void mapClassificationsFields
//            (Map<String, Object> classificationAttributes, List<SimpleIndexField> fields, Map<String, Object> populatedFields) {
//
//        fields.stream()
//                .filter(f -> f.getName().contains(CLASSIFICATIONS))
//                .forEach(classificationField -> {
//                    String classificationFieldName = classificationField.getName()
//                            .replaceAll(CLASSIFICATIONS + UNDER, StringUtils.EMPTY);
//
//                    if (Objects.nonNull(classificationAttributes) && classificationAttributes.keySet().contains(classificationFieldName)) {
//                        populatedFields.put(CLASSIFICATIONS + UNDER + classificationFieldName,
//                                classificationAttributes.get(classificationFieldName));
//                    }
//                });
//    }
//
//    private static List addClassificationValuesList(List<Object> relFieldValues) {
//        List classificationsList = new ArrayList();
//        for (Object r : relFieldValues) {
//            if (r instanceof Map) {
//                Map<String, Object> finalMap = new HashMap<>();
//                updateClassificationAssetInfo(finalMap, (Map<String, Object>) r);
//                classificationsList.add(finalMap);
//            }
//        }
//        return classificationsList;
//    }
//
//    private static List addClassificationValuesObject(Object[] relFieldValues) {
//        List classificationsList = new ArrayList();
//        for (Object r : relFieldValues) {
//            Map<String, Object> finalMap = new HashMap<>();
//            if (r instanceof Map) {
//                updateClassificationAssetInfo(finalMap, (Map<String, Object>) r);
//                classificationsList.add(finalMap);
//            } else if (r instanceof String) {
//                updateClassificationAssetInfo(finalMap, Collections.singletonMap(NAME, r));
//                classificationsList.add(finalMap);
//            }
//        }
//        return classificationsList;
//    }
//
//    private static void updateClassificationAssetInfo
//            (Map<String, Object> finalMap, Map<String, Object> assetRelValue) {
//        finalMap.put(NAME, assetRelValue.get(NAME));
//    }
//
//    private static List<SimpleIndexField> isClassificationIndexable
//            (Map<String, Object> classificationAttributes, List<SimpleIndexField> fields, Map<String, Object> populatedFields) {
//        log.info(convertObjectToJsonString(classificationAttributes));
//        List<SimpleIndexField> classifications = fields.stream()
//                .filter(f -> f.getName().equalsIgnoreCase(CLASSIFICATIONS))
//                .collect(Collectors.toList());
//        log.info(convertObjectToJsonString(classifications));
//        if (Objects.isNull(classificationAttributes)
//                || classificationAttributes.isEmpty()
//                || classifications.isEmpty()) {
//            populatedFields.remove(CLASSIFICATIONS);
//            return null;
//        }
//
//        populatedFields.put(CLASSIFICATIONS, new HashMap<>());
//        return classifications;
//    }
//
//    public static void addDefaultndexParam(TypeDefAttribute typeDefAttribute) {
//
//        if (Objects.nonNull(typeDefAttribute.getSearchable()))
//            typeDefAttribute.setSearchable(Boolean.FALSE);
//
//        if (Objects.nonNull(typeDefAttribute.getFilterable()))
//            typeDefAttribute.setFilterable(Boolean.TRUE);
//
//        if (Objects.nonNull(typeDefAttribute.getSortable()))
//            typeDefAttribute.setSortable(Boolean.FALSE);
//
//        if (Objects.nonNull(typeDefAttribute.getFacetable()))
//            typeDefAttribute.setFacetable(Boolean.FALSE);
//
//        typeDefAttribute.setRetrievable(Boolean.TRUE);
//    }
//
//    public static SimpleIndexField createNewTypeFieldComplex(String e) {
//        SimpleIndexField simpleIndexField = new SimpleIndexField();
//        simpleIndexField.setName(e);
//        simpleIndexField.setType(SimpleIndexField.EDM_COMPLEX_TYPE);
//        simpleIndexField.setFields(new ArrayList<>());
//        return simpleIndexField;
//    }
//
//    public static void updateDefaultFields(Map<String, Object> populatedFields, Map<String, Object> attributes) {
//        if (Objects.nonNull(attributes.get(ID)))
//            populatedFields.put(GUID, attributes.get(GUID));
//        if (Objects.nonNull(attributes.get(ID)))
//            populatedFields.put(ID, attributes.get(ID));
//        if (Objects.nonNull(attributes.get(NAME)))
//            populatedFields.put(NAME_LOWER, attributes.get(NAME));
//
//        populatedFields.put(SEARCH_ACTION, MERGE_OR_UPLOAD);
//    }
//
//    public static void addDefaultIndexParam(TypeDefAttribute typeDefAttribute) {
//
//        if (Objects.nonNull(typeDefAttribute.getSearchable()))
//            typeDefAttribute.setSearchable(Boolean.FALSE);
//
//        if (Objects.nonNull(typeDefAttribute.getFilterable()))
//            typeDefAttribute.setFilterable(Boolean.TRUE);
//
//        if (Objects.nonNull(typeDefAttribute.getSortable()))
//            typeDefAttribute.setSortable(Boolean.FALSE);
//
//        if (Objects.nonNull(typeDefAttribute.getFacetable()))
//            typeDefAttribute.setFacetable(Boolean.FALSE);
//
//        typeDefAttribute.setRetrievable(Boolean.TRUE);
//    }
//
//    public static void formatDates(Map<String, Object> populatedFields, SimpleIndexField f, String keyName, Object assetAttrVal) {
////        TODO: Reconfirm on the isNotEmpty check. Affecting any attribute change to empty value
//        if (Objects.nonNull(assetAttrVal)/*
//                && StringUtils.isNotEmpty(assetAttrVal.toString())*/) {
//            if (f.getType().contains(DATE)) {
//                if (!(assetAttrVal instanceof String)) {
//                    if (assetAttrVal instanceof Long)
//                        assetAttrVal = new Date(Long.valueOf(assetAttrVal.toString()));
//                    assetAttrVal = formatAtlasDate((Date) assetAttrVal);
//                }
//            }
//            if (assetAttrVal.getClass().isArray()) {
//                List assetAttrList = new ArrayList();
//                for (Object r : (Object[]) assetAttrVal) {
//                    if (r instanceof Map) {
//                        assetAttrList.add(new HashMap<String, Object>((Map<? extends String, ?>) r));
//                    } else {
//                        assetAttrList.add(r);
//                    }
//                }
//                populatedFields.put(keyName, assetAttrList);
//            } else if (assetAttrVal instanceof List) {
//                List assetAttrList = new ArrayList();
//                for (Object r : (List<Object>) assetAttrVal) {
//                    if (r instanceof Map) {
//                        assetAttrList.add(new HashMap<String, Object>((Map<? extends String, ?>) r));
//                    } else {
//                        assetAttrList.add(r);
//                    }
//                }
//                populatedFields.put(keyName, assetAttrList);
//            } else if (assetAttrVal instanceof Map) {
//                populatedFields.put(keyName, ((Map) assetAttrVal).get(keyName));
//            } else {
//                populatedFields.put(keyName, assetAttrVal);
//            }
//        }
//    }

    public static boolean isSubFieldsEmpty(Map<String, Object> subFields) {
        return subFields.entrySet().stream()
                .filter(s -> Objects.nonNull(s.getValue()))
                .collect(Collectors.toList())
                .isEmpty();
    }
}
