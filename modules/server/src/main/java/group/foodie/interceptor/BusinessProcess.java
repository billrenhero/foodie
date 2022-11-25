package group.foodie.interceptor;

import java.lang.annotation.*;

/**
 * @author renmingyuan
 * @date 2022/11/25
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BusinessProcess {


}
