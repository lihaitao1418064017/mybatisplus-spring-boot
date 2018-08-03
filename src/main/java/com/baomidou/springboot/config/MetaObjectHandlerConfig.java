package com.baomidou.springboot.config;

import java.util.Date;

import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;

@Component
public class MetaObjectHandlerConfig extends MetaObjectHandler {

  /**
   * mybatisplus自定义填充公共字段 ,即没有传的字段自动填充
   * @param metaObject
   */
  @Override
  public void insertFill(MetaObject metaObject) {
    System.out.println("插入方法实体填充");
//    setFieldValByName("date", new Date(), metaObject);
  }

  @Override
  public void updateFill(MetaObject metaObject) {
    System.out.println("更新方法实体填充");
  }
}
