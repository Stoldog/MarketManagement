package com.stoldog.entity;

import java.util.List;

/**
 * Created by RL on 2017/5/6.
 */
public class Menus {
    private Integer pid;
    private String pathName;
    private Integer idFather;
    private Integer fatherPid;
    private Integer departType;
    private String iconValue;
    private String pathValue;
    private List<Menus> menusList;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPathName() {
        return pathName;
    }

    public void setPathName(String pathName) {
        this.pathName = pathName;
    }

    public Integer getIdFather() {
        return idFather;
    }

    public void setIdFather(Integer idFather) {
        this.idFather = idFather;
    }

    public Integer getFatherPid() {
        return fatherPid;
    }

    public void setFatherPid(Integer fatherPid) {
        this.fatherPid = fatherPid;
    }

    public Integer getDepartType() {
        return departType;
    }

    public void setDepartType(Integer departType) {
        this.departType = departType;
    }

    public String getIconValue() {
        return iconValue;
    }

    public void setIconValue(String iconValue) {
        this.iconValue = iconValue;
    }

    public String getPathValue() {
        return pathValue;
    }

    public void setPathValue(String pathValue) {
        this.pathValue = pathValue;
    }

    public List<Menus> getMenusList() {
        return menusList;
    }

    public void setMenusList(List<Menus> menusList) {
        this.menusList = menusList;
    }

    @Override
    public String toString() {
        return "Menus{" +
                "pid=" + pid +
                ", pathName='" + pathName + '\'' +
                ", idFather=" + idFather +
                ", fatherPid=" + fatherPid +
                ", departType=" + departType +
                ", iconValue='" + iconValue + '\'' +
                ", pathValue='" + pathValue + '\'' +
                ", menusList=" + menusList +
                '}';
    }
}
