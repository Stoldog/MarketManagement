package com.stoldog.entity;

/**
 * Created by RL on 2017/4/11.
 */
public class Pages {
    private Integer pageSize=10;
    private Integer curPage;
    private Long pageNum;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurPage() {
        return curPage;
    }

    public void setCurPage(Integer curPage) {
        this.curPage = curPage;
    }

    public Long getPageNum() {
        return pageNum;
    }

    public void setPageNum(Long pageNum) {
        this.pageNum = pageNum;
    }

    //计算总数
    public void calPageNum(Long a){
        if(a%10==0){
            pageNum= a/10;
        }else {
            pageNum= a/10+1;
        }
    }
    public Integer calCurPage(){
        return (curPage-1)*pageSize;
    }
    @Override
    public String toString() {
        return "Pages{" +
                "pageSize=" + pageSize +
                ", curPage=" + curPage +
                ", pageNum=" + pageNum +
                '}';
    }
}
