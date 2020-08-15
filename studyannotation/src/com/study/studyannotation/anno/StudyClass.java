package com.study.studyannotation.anno;

import java.lang.annotation.*;

/**
 * @author jiayq
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@StudyAnno(name = "studyClass")
@StudyClass(name = "this")
public @interface StudyClass {

    public String name() default "studyClass";

}
