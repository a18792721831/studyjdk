package com.study.studyannotation.anno;

import java.lang.annotation.*;

/**
 * @author jiayq
 */
@Target(ElementType.CONSTRUCTOR)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@StudyAnno(name = "studyCons")
@StudyClass(name = "studyCons")
public @interface StudyCons {

    @StudyMethod
    public String name() default "studyCons";

}
