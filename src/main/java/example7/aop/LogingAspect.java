package example7.aop;

import java.sql.Timestamp;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogingAspect {
	
	@Before("execution( * example7.model.*.*(..))")
	public void logMethodBefore(JoinPoint jp) {
		Signature sign=jp.getSignature();
		System.err.println("AspectJ - before - "+sign.getName()+" was invoked on "+new Timestamp(System.currentTimeMillis()));

	}
	@After("execution( * example7.model.*.*(..))")
	public void logMethodAfter(JoinPoint jp) {
		Signature sign=jp.getSignature();
		System.err.println("AspectJ - after - "+sign.getName()+" was invoked on "+new Timestamp(System.currentTimeMillis()));

	}
	
	
	

}
