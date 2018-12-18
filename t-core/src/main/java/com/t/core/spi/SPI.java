package com.t.core.spi;

import java.lang.annotation.*;

/**
 * @author tb
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface SPI {
    /**
     * config中的键值
     */
    String key() default "";

    /**
     * 默认扩展实现
     */
    String dftValue() default "";
}
