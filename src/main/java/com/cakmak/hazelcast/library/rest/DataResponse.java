package com.cakmak.hazelcast.library.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor

public class DataResponse<T> {
    private List<T> items = List.of();

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("listItems: ");

        System.out.println("DataResponse içerisinceki toString metodu çalıştı ilk dönen veri : " + sb);

        if(items!= null){
            items.forEach(item -> {
                sb.append(item.toString());
                sb.append('\n');
            });
        }

        System.out.println("DataResponse içerisinceki toString metodu çalıştı SON dönen veri : " + sb.toString());

        return sb.toString();
    }
}
