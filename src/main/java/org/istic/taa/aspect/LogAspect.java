package org.istic.taa.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

import java.util.logging.Logger;

@Aspect
public class LogAspect {

    private static Logger logger;

	//@Before("execution(public * *.*(..))")
	@AfterReturning("execution(public * *.*(..))")
	public void log(JoinPoint pjp) throws Throwable{
        logger = Logger.getLogger(pjp.getSignature().getName());
		logger.info(pjp.getSignature().getName() + pjp.getThis().toString());
		
	}

}
