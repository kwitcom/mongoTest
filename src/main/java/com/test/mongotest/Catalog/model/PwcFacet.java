package com.test.mongotest.Catalog.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PwcFacet implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty(value="value")
	private String value;
	private long count;

	public PwcFacet(String value, long count) {
		this.value = value;
		this.count = count;
	}
}
