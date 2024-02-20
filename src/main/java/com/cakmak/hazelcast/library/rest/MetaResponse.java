package com.cakmak.hazelcast.library.rest;

import com.cakmak.hazelcast.library.enums.MessageCodes;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MetaResponse {
    private String code;
    private String description;

    public static MetaResponse of(String code , String description){
        System.out.println("Meta response içerisindeki OF metodu çalıştı");
        return new MetaResponse(code , description);
    }

    public static MetaResponse success(){
        System.out.println("Meta Response içerisindeki success metodu çalıştı");
        return new MetaResponse(MessageCodes.SUCCESS.getCode(), "Success");
    }

}
