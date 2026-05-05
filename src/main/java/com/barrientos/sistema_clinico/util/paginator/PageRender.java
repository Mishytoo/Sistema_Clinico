package com.barrientos.sistema_clinico.util.paginator;

import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class PageRender<T> {
    @Getter
    private String url;

    private Page<T> page;

    @Getter
    private int totalPage;

    private int numElements4Page;

    @Getter
    private int actualPage;

    @Getter
    private List<PageItem> paginas;

    public PageRender(String url, Page<T> page){
        this.url = url;
        this.page = page;
        this.paginas = new ArrayList<PageItem>();

        numElements4Page = page.getSize();
        totalPage = page.getTotalPages();
        actualPage = page.getNumber() + 1;

        int desde, hasta;
        if(totalPage <= numElements4Page){
            desde = 1;
            hasta = totalPage;
        }else{
            if(actualPage <= numElements4Page/2){
                desde = 1;
                hasta = numElements4Page;
            } else if (actualPage >= totalPage - numElements4Page/2){
                desde = totalPage - numElements4Page + 1;
                hasta = numElements4Page;
            } else{
                desde = actualPage - numElements4Page/2;
                hasta = numElements4Page;
            }
        }

        for (int i=0; i < hasta; i++){
            paginas.add(new PageItem(desde + i, actualPage == desde + i));
        }

    }

    public boolean isFirst(){
        return page.isFirst();
    }

    public boolean isLast(){
        return page.isLast();
    }

    public boolean isHasNext(){
        return page.hasNext();
    }

    public boolean isHasPrevious(){
        return page.hasPrevious();
    }
}
