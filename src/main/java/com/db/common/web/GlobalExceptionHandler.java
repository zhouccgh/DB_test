package com.db.common.web;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.db.common.exception.ServiceException;
/**
 * @ControllerAdvice 修饰的类一般为
 * spring mvc中的全局异常处理类,此类
 * 中可以定义一些异常处理方法.
 * 
 * @RestControllerAdvice 也可以修饰
 * 全局异常处理类,此注解相当于
 * 在@ControllerAdvice与
 * @ResponseBody注解的组合
 */
import com.db.common.vo.JsonResult;
@RestControllerAdvice
//@ControllerAdvice
public class GlobalExceptionHandler {
     /**
      * @ExceptionHandler 注解描述的方法为异常处理方法
      * 注解内部给定的异常类型为此方法可以处理的异常类型
      */
	 @ExceptionHandler(ServiceException.class)
	 //@ResponseBody
	 public JsonResult doHandleServiceException(
			 ServiceException e){
		 e.printStackTrace();//也可以以日志形式输出
		 return new JsonResult(e);
	 }
	 @ExceptionHandler(RuntimeException.class)
	 //@ResponseBody
	 public JsonResult doHandleRuntimeException(
			 RuntimeException e){
		 e.printStackTrace();//也可以以日志形式输出
		 JsonResult r=new JsonResult();
		 r.setMessage("运行时错误,稍等片刻");
		 r.setState(0);
		 return r;
	 }
}