package com.study.studyannotation.anno;

import java.lang.annotation.*;

/**
 * @author jiayq
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@StudyAnno(name = "studyField")
@StudyClass(name = "studyField")
public @interface StudyField {

    @StudyMethod(name = "studyField")
    public String name() default "studyField";

}
