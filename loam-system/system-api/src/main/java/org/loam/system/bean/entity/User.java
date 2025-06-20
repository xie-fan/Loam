package org.loam.system.bean.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.loam.common.core.bean.entity.AbstractBeanEntity;

@EqualsAndHashCode(callSuper = true)
@Data
public class User extends AbstractBeanEntity<Long> {

    private String account;

    private String name;

    private String password;

    private String sex;

    private String phone;

    private String email;

}
