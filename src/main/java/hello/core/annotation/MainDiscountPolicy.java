package hello.core.annotation;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Qualifier("mainDiscountPolicy")
// 클래스 명에 Ctrl + Win + B를 누르면 이 어노테이션을 어디서 사용하고 있는지 추적할 수 있다.
public @interface MainDiscountPolicy {
}
