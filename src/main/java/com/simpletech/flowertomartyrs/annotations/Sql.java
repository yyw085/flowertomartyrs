package com.simpletech.flowertomartyrs.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Sql方法申明，在DaoImpl使用
 * @author zimu
 * @date 2015-12-17 15:07:45 中国标准时间
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Sql {
	public String value();
}
