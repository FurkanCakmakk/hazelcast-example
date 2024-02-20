package com.cakmak.hazelcast.library.rest;

import org.springframework.data.domain.Page;

import java.util.List;

public class ResponseBuilder {

    private ResponseBuilder(){

    }

    public static <T> Response<DataResponse<T>> build(List<T> items){
        System.out.println("Response Builder içerisindeki DataResponse metoduna girdi");
        return new Response<>(new DataResponse<>(items));
    }

    public static <T> Response<PageResponse<T>> build(Page<T> items){
        System.out.println("Response Builder içerisindeki PageResponse metoduna girdi");

        return new Response<>(new PageResponse<>(items));
    }

    public static <T> Response<T> build(T item) {
        System.out.println("Response Builder içerisindeki Response metoduna girdi");

        return new Response<>(item);
    }

    public static Response<MetaResponse> build(MetaResponse metaResponse){
        System.out.println("Response Builder içerisindeki MetaResponse metoduna girdi");

        return new Response<>(metaResponse);
    }

}
