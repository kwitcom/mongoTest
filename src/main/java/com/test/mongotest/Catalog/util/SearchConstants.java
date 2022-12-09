package com.test.mongotest.Catalog.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SearchConstants {

    public static final int CONNECT_TIMEOUT_MS = 20_000;
    public static final String SEARCH = "search";
    public static final String SIMPLE = "simple";
    public static final String FULL = "full";
    public static final String API_KEY = "api-key";
    public static final String DOCS = "docs";
    public static final String MERGE_OR_UPLOAD = "mergeOrUpload";
    public static final String SEARCH_ACTION = "@search.action";
    public static final String DELETE = "delete";
    public static final String DELETE_UPPER  = "DELETE";
    public static final String CREATE  = "CREATE";
    public static final String UPDATE  = "UPDATE";
    public static final String READ  = "READ";
    public static final String SEARCH_INDEX_NAME = "search_index_name";
    public static final String DEFAULT_INDEX_NAME = "catalogue-assets-v3";
    public static final String SERVICE_STATS = "/servicestats";

    public static final int DEFAULT_LIMIT = 1000;
    public static final int DEFAULT_OFFSET = 0;
    public static final String COUNT = "$count";
    public static final String AZURE_COUNT = "azureCount";
    public static final String AZURE_FILTER = "azureFilter";
    public static final String AZURE_FACETS = "azureFacets";
    public static final String SEARCH_SCORE = "@search.score";
    public static final String FS = "/";
    public static final String DOCS_INDEX = "/docs/index";
    public static final String INDEX = "index";
    public static final String INDEXES = INDEX + "es";
    public static final String DOCS_SEARCH = DOCS + FS + SEARCH;
    public static final String FS_INDEXES_FS = FS + INDEXES + FS;
    public static final String EDM_COMPLEX_TYPE = "Edm.ComplexType";
    public static final String EDM_STRING = "Edm.String";
    public static final String EDM_DATETIMEOFFSET = "Edm.DateTimeOffset";
    public static final String EDM_BOOLEAN = "Edm.Boolean";

    public static final String NAME = "name";
    public static final String NAME_LOWER = "nameLower";
    public static final String CREATE_TIME = "createTime";
    public static final String TIMESTAMP_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
    public static final String KEY = "key";
    public static final String VALUE = "value";
    public static final String DATE = "Date";

    public static final String AND = "and";
    public static final String AND_W_SPACES = " and ";
    public static final String EQ = "eq";
    public static final String EQ_W_SPACES = " eq ";
    public static final String NE = "ne";
    public static final String NE_W_SPACES = " ne ";
    public static final String NOT = "not ";
    public static final String OR = "or ";
    public static final String GE = "ge";
    public static final String LT = "lt";
    public static final String FILTER_FWD_SLASH = "/";
    public static final String FILTER_OPEN_PARENTHESIS = "(";
    public static final String FILTER_CLOSE_PARENTHESIS = ")";
    public static final String SINGLE_QUOTE = "'";
    public static final String SINGLE_STAR = "*";

    public static final String ANY = "any";
    public static final String ALL = "all";
    public static final String ANY_T = "/any(t:";
    public static final String ANY_T_T = ANY_T + "t";
//    public static final String RELATIONS_FS = RELATIONS + FS;
    public static final String FACET_COUNT = ",count:";
    public static final String DEFAULT_FACET_LIMIT = ",count:10";

    public static final String CATALOGUE_TYPES = "catalogue_types";
    public static final String CATALOGUE_USERS = "catalogue_users";
    public static final String CATEGORY = "category";

    public static final String PRIMARY_SUBJECTS = "primarySubjects";
    public static final String EXTENSION = "extension";
//    public static final List<String> DEFAULT_FACETS = Arrays.asList(
//            PRIMARY_SUBJECTS,
//            CLASSIFICATIONS + UNDER + OWNERSHIP_TYPE,
//            EXTENSION,
//            TYPE_NAME);

    public static Object formatAtlasDate(Date value) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TIMESTAMP_PATTERN);
        return simpleDateFormat.format(value);
    }

//    public static <T> T getJson(String resPath, Class<T> clazz) {
//        try {
//            InputStream file = new ClassPathResource(resPath).getInputStream();
//            return new ObjectMapper().readValue(file, clazz);
//        } catch (IOException e) {
//            throw new PwCInternalException("Unable to get Json from specified path" + e.getMessage());
//        }
//    }

//    public static ZonedDateTime parseStringToZonedDateTime(String dateValue) {
//        try {
//            //We try to parse YYYY-MM-dd string format
//            return LocalDate.parse(dateValue, DateTimeFormatter.ofPattern("yyyy-MM-dd")).atStartOfDay(ZoneOffset.UTC);
//        } catch (DateTimeParseException e) {
//            try {
//                //try to parse YYYY-MM-ddT:HH:MMZ
//                return LocalDateTime.parse(dateValue).atZone(ZoneOffset.UTC);
//            } catch (DateTimeParseException f) {
//                try {
//                    //try to parse YYYY-MM-ddT:HH:MM
//                    return OffsetDateTime.parse(dateValue).toZonedDateTime();
//                } catch (DateTimeParseException g) {
//                    throw new PwCBadRequestException(String.format("Date format is not supported: {%s}", dateValue));
//                }
//            }
//        }
//    }
}
