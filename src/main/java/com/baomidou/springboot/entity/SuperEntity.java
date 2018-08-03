package com.baomidou.springboot.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

/**
 * 演示实体父类
 */
public class SuperEntity<T extends Model> extends Model<T> {

    /**
     * 主键ID , 这里故意演示注解可以无
     */
    @TableId("id")
    private Long id;

    public Long tenant_id;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SuperEntity getSuperEntity(Long tenant_id){
        this.tenant_id=tenant_id;
        return  this;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
