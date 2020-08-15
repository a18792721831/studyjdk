package com.study.studyannotation.anno;

import java.lang.annotation.*;

/**
 * @author jiayq
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@StudyAnno(name = "studyMethod")
@StudyClass(name = "studyMethod")
public @interface StudyMethod {

    @StudyMethod(name = "name")
    public String name() default "studyMethod";

}
