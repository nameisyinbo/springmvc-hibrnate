package online.qsx.model;

import org.springframework.stereotype.Component;

@Component
public class Page {
    private int pageSize = 5 ;//每页数据

    private int pageNo = 1 ;//当前页

    private int totalCount ;//总数据数

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }


}
