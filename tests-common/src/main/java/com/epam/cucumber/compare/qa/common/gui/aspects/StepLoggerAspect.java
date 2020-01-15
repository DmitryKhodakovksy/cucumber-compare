package com.epam.cucumber.compare.qa.common.gui.aspects;

import com.epam.cucumber.compare.qa.common.gui.services.attachments.Attachments;
import com.epam.cucumber.compare.qa.common.gui.services.webdriver.WrappedWebdriver;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class StepLoggerAspect {

    @Autowired
    private Attachments attachments;

    @Autowired
    @Lazy
    private WrappedWebdriver driver;

    @Pointcut("execution (* *..stepsDef..*StepsDef.*(..))")
    public void cucumberStepOperation() {
    }

    private void proceed(ProceedingJoinPoint proceedingJoinPoint) {
        try {
            proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            attachScreenshot();
            throwable.printStackTrace();
        }
    }

    @Around("cucumberStepOperation()")
    public void logCucumberStep(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        proceed(proceedingJoinPoint);
    }

    private void attachScreenshot() {
        attachments.attachScreenShot();
    }
}
