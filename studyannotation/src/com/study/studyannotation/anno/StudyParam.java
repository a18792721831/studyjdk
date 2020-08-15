package com.study.studyannotation.anno;

import java.lang.annotation.*;

/**
 * @author jiayq
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@StudyAnno(name = "studyParam")
@StudyClass(name = "studyParam")
public @interface StudyParam {

    @StudyMethod(name = "studyParam")
    public String value() default "";

}
