package com.stoldog.entity;


import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by RL on 2017/4/11.
 */
@Component
public class Message {
    private Boolean result;
    private String info;
    private List<Object> list;
    private Object object;
    private Boolean isPaged;
    private Pages page;

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public Boolean getIsPaged() {
        return isPaged;
    }

    public void setIsPaged(Boolean isPaged) {
        this.isPaged = isPaged;
    }

    public Pages getPage() {
        return page;
    }

    public void setPage(Pages page) {
        this.page = page;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "Message{" +
                "result=" + result +
                ", info='" + info + '\'' +
                ", list=" + list +
                ", object=" + object +
                ", isPaged=" + isPaged +
                ", page=" + page +
                '}';
    }
}
