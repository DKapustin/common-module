package medical.common.core.aop;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class LoggingAdvice {
    @Pointcut(value = "execution(* liga.medical.common.service.*.*(..))")
    public void restPointcut() {
    }

    @Around(value = "restPointcut()")
    public Object restLogger(ProceedingJoinPoint pjp) throws JsonProcessingException {
        String methodName = pjp.getSignature().getName();
        String className = pjp.getTarget().getClass().toString();

        log.info("ClassName - " + className +
                "; MethodName - " + methodName  +
                ", Date: " + new Date());

        Object object = null;
        try {
            object = pjp.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return object;
    }
}
