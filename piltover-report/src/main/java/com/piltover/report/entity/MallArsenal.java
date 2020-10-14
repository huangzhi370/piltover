package com.piltover.report.entity;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class MallArsenal implements Serializable {
    private Integer id;

    @ApiModelProperty(value = "名称")
    private String arsenalName;

    @ApiModelProperty(value = "描述")
    private String arsenalDesc;

    @ApiModelProperty(value = "持有者")
    private String holder;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArsenalName() {
        return arsenalName;
    }

    public void setArsenalName(String arsenalName) {
        this.arsenalName = arsenalName;
    }

    public String getArsenalDesc() {
        return arsenalDesc;
    }

    public void setArsenalDesc(String arsenalDesc) {
        this.arsenalDesc = arsenalDesc;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", arsenalName=").append(arsenalName);
        sb.append(", arsenalDesc=").append(arsenalDesc);
        sb.append(", holder=").append(holder);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}