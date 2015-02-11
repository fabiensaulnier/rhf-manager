package com.rollerhockeyfrance.manager.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@JsonInclude(Include.NON_NULL)
public class Api<T> {
    
    /**
     * Statut de la requête
     */
    @JsonProperty
    private Status status;
	
    @JsonProperty
	private T data;
    
    @JsonProperty
    private Error error;
    
    @JsonProperty
    private Pagination meta;

    public enum Status {
        OK, ERROR
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public Pagination getMeta() {
        return meta;
    }

    public void setMeta(Pagination meta) {
        this.meta = meta;
    }
    
}
