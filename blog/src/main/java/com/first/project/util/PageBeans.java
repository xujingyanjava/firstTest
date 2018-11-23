package com.first.project.util;


import org.springframework.data.domain.AbstractPageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PageBeans extends AbstractPageRequest implements Pageable {


    private Sort sort;

    /**
     * Creates a new {@link AbstractPageRequest}. Pages are zero indexed, thus providing 0 for {@code page} will return
     * the first page.
     *
     * @param page must not be less than zero.
     * @param size must not be less than one.
     */
    public PageBeans(int page, int size) {
        super(page, size);
    }

    @Deprecated
    public PageBeans(int page, int size, Sort sort) {

        super(page, size);

        this.sort = sort;
    }



    @Override
    public Sort getSort() {
        return null;
    }

    @Override
    public Pageable next() {
        return null;
    }

    @Override
    public Pageable previous() {
        return null;
    }

    @Override
    public Pageable first() {
        return null;
    }

}
