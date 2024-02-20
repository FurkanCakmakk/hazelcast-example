package com.cakmak.hazelcast.library.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PageResponse<T> {
    private Page<T> items = Page.empty();

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("pageItems: ");

        System.out.println("PageResponse içerisindeki toString metodu çalıştı. İlk veri : " +sb);

        if(items != null){
            items.forEach(item-> {
                sb.append(item.toString());
                sb.append('\n');
            });
        }

        System.out.println("PageResponse içerisindeki toString metodu çalıştı. SON veri : " +sb.toString());

        return sb.toString();
    }
}
