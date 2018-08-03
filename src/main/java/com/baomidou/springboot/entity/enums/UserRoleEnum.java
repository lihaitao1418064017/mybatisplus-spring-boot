package com.baomidou.springboot.entity.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * 测试枚举
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum UserRoleEnum implements IEnum<Integer> {
    SIMPLE(0,"普通会员"),
    MEMBER(1, "会员"),
    SUPER_MEMBER(2, "超级会员");

    private Integer value;
    private String roleName;

    UserRoleEnum(final Integer value, final String roleName) {
        this.value = value;
        this.roleName = roleName;
    }

    public static UserRoleEnum getByRoleName(final String roleName){
         for(UserRoleEnum userRoleEnum:UserRoleEnum.values()){
             if(userRoleEnum.getRoleName().equals(roleName)){
                 return userRoleEnum;
             }
         }
        return null;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }

    public String getRoleName(){
        return this.roleName;
    }
}
