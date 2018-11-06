package com.first.project.domain;

import javax.persistence.*;
import java.util.Date;


@MappedSuperclass
public abstract class DbCommon{

    private Long id;

    private Integer deleteFlag = 0;

    private Date createDate;

    private Date updateDate;

    @Id
    @Column(name="id", updatable=false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
