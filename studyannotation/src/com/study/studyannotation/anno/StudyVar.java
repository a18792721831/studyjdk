package com.study.studyannotation.anno;


import java.lang.annotation.*;

/**
 * @author jiayq
 */
@Target(ElementType.LOCAL_VARIABLE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@StudyAnno(name = "studyVar")
@StudyClass(name = "studyVar")
public @interface StudyVar {

    @StudyMethod(name = "studyVar")
    public String name() default "studyVar";

}
