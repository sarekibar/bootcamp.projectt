package com.tobeto.bootcamp.core.aspects.logging;

import com.tobeto.bootcamp.core.crossCuttingConcerns.logging.LogParameter;
import com.tobeto.bootcamp.core.crossCuttingConcerns.logging.LoggerServiceBase;
import com.tobeto.bootcamp.wepapi.controllers.EmployeesController;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.catalina.filters.ExpiresFilter;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Aspect
@Component
public class LogAspect {

    private final LoggerServiceBase loggerServiceBase;
    private HttpServletRequest httpServletRequest;

    @Autowired
    public LogAspect(LoggerServiceBase loggerServiceBase,
                     HttpServletRequest httpServletRequest) {
        this.loggerServiceBase = loggerServiceBase;
        this.httpServletRequest = httpServletRequest;
    }

    @Pointcut("within(@org.springframework.stereotype.Repository *)"
            + " || within(@org.springframework.stereotype.Service *)"
            + " || within(@org.springframework.web.bind.annotation.RestController *)")
    public void springBeanPoincut() {

    }

    @Around(("springBeanPointcut() && @annotation(com.tobeto.bootcamp.core.aspects.logging.Loggable)"))
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {

        Object result = joinPoint.proceed();
        String methodName = joinPoint.getSignature().getDeclaringTypeName()
                + "." + joinPoint.getSignature().getName();
        List<LogParameter> logParameters = new ArrayList<>();
        logParameters.add(new LogParameter(result));


        String userName = getUserName();
        loggerServiceBase.log(methodName, logParameters.userName);
        return result;
    }

    private String getUserName() {
        if (httpServletRequest.getUserPrincipal() != null) {
            return httpServletRequest.getUserPrincipal().getName();
        } else {
            return "?";
        }
    }

}


