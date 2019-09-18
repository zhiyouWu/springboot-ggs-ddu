package annotation.test;

import java.lang.annotation.*;

/**
 * @Package annotation.test
 * @Author wuzy@watone.com.cn
 * @Date 2019/9/17 11:26
 * @Version V1.0
 * @Description:
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MyAnnotation {
    String name() default "anno";
    int age() default 18;
}

