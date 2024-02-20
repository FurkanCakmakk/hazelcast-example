package com.cakmak.hazelcast.library.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> {
    private T data;
    private MetaResponse meta;

    public Response(MetaResponse meta) {
        System.out.println("Meta Response içerisindeki ilk constructora girdi");
        this.meta = meta;
    }

    public Response(T data){
        System.out.println("Meta Response içerisindeki İKİNCİ constructora girdi");

        this.data = data;
        this.meta = MetaResponse.success();
    }

    @Override
    public String toString(){
        System.out.println("Meta Response içerisindeki toString metoduna girdi");

        StringBuilder sb = new StringBuilder("data: ");
        sb.append(data != null ? data.toString() : "null");
        sb.append(", meta: ");
        sb.append(meta != null ? meta.toString() : "null");
        return sb.toString();
    }
}
