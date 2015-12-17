package com.simpletech.flowertomartyrs.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.simpletech.flowertomartyrs.annotations.Intent;
import com.simpletech.flowertomartyrs.model.entity.RestfulEntity;
import com.simpletech.flowertomartyrs.util.AfReflecter;
import com.simpletech.flowertomartyrs.util.ServiceException;

/**
 * Controller 数据异常处理切面
 * @author zimu
 * @date 2015-12-17 15:07:45 中国标准时间
 */
@Aspect
@Component
public class ControllerAspect {

	@Around("execution(public Object com.simpletech.flowertomartyrs.controller.*.*(..))")
	public Object around(ProceedingJoinPoint point) {
		Object result = null;
		Signature signature = point.getSignature();
		Class<?> type = point.getTarget().getClass();
		String methodName = signature.getName();
		Intent annotation = AfReflecter.getMethodAnnotation(type , methodName, Intent.class);
		String intent = "请求";
		if (annotation != null) {
			intent = annotation.value();
		}
		annotation = type.getAnnotation(Intent.class);
		String model = "";
		if (annotation != null) {
			model = annotation.value();
		}
		intent = String.format(intent, model);
		try {
			result = point.proceed();
		} catch (ServiceException e) {
			return RestfulEntity.getFailure(e.getMessage());
		} catch (Throwable e) {
			e.printStackTrace();
			return RestfulEntity.getFailure(intent+"失败"+"-"+e.getMessage());
		}
		if(result == null){
			return RestfulEntity.getSuccess(intent+"成功");
		}else if ("null".equals(result)) {
			result = null;
		}
		
		return RestfulEntity.getSuccess(result);
	}

}
