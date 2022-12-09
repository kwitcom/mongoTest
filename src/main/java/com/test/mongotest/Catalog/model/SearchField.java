package com.test.mongotest.Catalog.model;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SearchField implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String fieldName;
	private String type, analyzer;
	private Boolean key;
	private Boolean collection;
	private Boolean sortable;
	private Boolean index;
    private Boolean filterable, retrievable, facetable, searchable;
    private Boolean suggestable=false;
}
