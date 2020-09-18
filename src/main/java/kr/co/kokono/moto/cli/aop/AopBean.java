package kr.co.kokono.moto.cli.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;

@Slf4j
public class AopBean {

    public void aroundLog(ProceedingJoinPoint pjp) {
        log.error(">>> before aop log");
        try {
            Object proceed = pjp.proceed();
            log.error(">> returning aop log");
        } catch (Throwable throwable) {
            log.error(">> throwing aop log");
        }
        log.error(">>> after aop log");
    }




}
