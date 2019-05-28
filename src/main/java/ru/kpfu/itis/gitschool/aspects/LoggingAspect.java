/* Big thanks for provided help with code to Mikhail Kornilov (@KornilovMikhail)*/

package ru.kpfu.itis.gitschool.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
    private long start;

    @Pointcut("execution(* ru.kpfu.itis.gitschool.repositories..*.*(..))")
    public void repoHook() {
    }

    @Pointcut("execution(@ru.kpfu.itis.gitschool.annotations.AspectAnno * *(..))")
    public void annoHook() {
    }

    @Before("repoHook()")
    public void logBefore(JoinPoint jp) {
        logger.info("Method '" + jp.getSignature().toShortString() + "' was invoked");
    }

    @Before("annoHook()")
    public void startTimer(JoinPoint jp) {
        start = System.nanoTime();
        logger.info("Method '" + jp.getSignature().toShortString() + "' was invoked");
    }

    @After("annoHook()")
    public void stopTimer(JoinPoint jp) {
        logger.info("Method '" + jp.getSignature().toShortString() + "' was executed.");
        logger.info("It's been taken " + (System.nanoTime() - start) + " nanoseconds for execution.");
    }
}
