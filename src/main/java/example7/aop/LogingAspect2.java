package example7.aop;

import java.sql.Timestamp;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import example7.model.Bark;

@Component
@Aspect
public class LogingAspect2 {

	@Pointcut("execution( * example7.model.*.*(..))")
	public void modelPointCut() {

	}

	@Before("modelPointCut()")
	public void logMethodBefore(JoinPoint jp) {
		Signature sign = jp.getSignature();
		System.err.println("AspectJ - before - " + sign.getName() + " was invoked on "
				+ new Timestamp(System.currentTimeMillis()));

	}

	@After("modelPointCut()")
	public void logMethodAfter(JoinPoint jp) {
		Signature sign = jp.getSignature();
		System.err.println(
				"AspectJ - after - " + sign.getName() + " was invoked on " + new Timestamp(System.currentTimeMillis()));

	}

	@AfterReturning(pointcut = "execution( example7.model.Bark example7.model.*.*(..))", returning = "barkResult")
	public void addTimeToBark(org.aspectj.lang.JoinPoint jp, Object barkResult) {
		Bark result = (Bark) barkResult;
		if (result != null) {
			result.setWhen(new Date());
		}
	}

	@Around("execution( example7.model.Bark example7.model.*.*(..))")
	public Object silenceTheBark(final ProceedingJoinPoint pjp) throws Throwable {

		Bark theBark = (Bark) pjp.proceed(pjp.getArgs());
		if (theBark.getNumberOfTimes() <= 3)
			return theBark;
		else
			return null;
	}
	
	@Before("@annotation(example7.annotation.ArgExampleAnnotation)")
	public void beforeAnntation(JoinPoint jp) {
		Signature sign = jp.getSignature();
		System.err.println("AspectJ -@annotation -  before - " + sign.getName() + " was invoked with  "+ jp.getArgs()[0]);
	}
	
	@Before("@args(example7.annotation.ArgExampleAnnotation)")
	public void beforeArgsAnntation(JoinPoint jp) {
		Signature sign = jp.getSignature();
		System.err.println("AspectJ -@args -  before - " + sign.getName() + " was invoked with  "+ jp.getArgs()[0]);
	}

}
