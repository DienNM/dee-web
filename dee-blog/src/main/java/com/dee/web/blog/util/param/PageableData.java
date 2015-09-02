package com.dee.web.blog.util.param;

import java.io.Serializable;

/**
 * @author dien.nguyen
 */

public class PageableData implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private int pageIndex;
    
    private int pageSize;
    
    private int totalPages;
    
    public PageableData() {
        this(0, 50);
    }
    
    public PageableData(int pageIndex, int pageSize) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
    }
    
    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
    
}
