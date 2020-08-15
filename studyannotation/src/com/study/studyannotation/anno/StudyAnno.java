package com.study.studyannotation.anno;

import java.lang.annotation.*;

/**
 * @author jiayq
 */
@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@StudyAnno(name = "this")
public @interface StudyAnno {

    public String name() default "studyAnno";

}
