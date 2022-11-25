package group.foodie.interceptor.aspect;

import com.alibaba.fastjson.JSON;
import group.foodie.entity.response.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author renmingyuan
 * @date 2022/11/25
 */
@Slf4j
@Aspect
@Component
public class BusinessProcessAspect {

    @Pointcut("@annotation(group.foodie.interceptor.BusinessProcess)")
    public void pointCut() {
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        String classType = point.getTarget().getClass().getName();
        String methodName = point.getSignature().getName();
        try {
            log.info("Class=[{}], method=[{}]. Request=[{}]", classType, methodName, JSON.toJSONString(point.getArgs()));
            Object result = point.proceed();
            log.info("Class=[{}], method=[{}]. Response=[{}]", classType, methodName, JSON.toJSONString(result));
            return result;
        } catch (Exception e) {
            log.error("classType : {}, methodName : {} Exception", classType, methodName, e);
            return ResultVO.FAIL();
        }
    }
}
