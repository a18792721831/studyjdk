package com.study.studyannotation.beans;

import com.study.studyannotation.anno.*;

/**
 * @author jiayq
 * @Date 2020/8/14
 */
@StudyClass(name = "people")
public class People {

    @StudyField(name = "小美")
    private String name;

    @StudyCons(name = "people")
    public People(@StudyParam("name") String name) {

        @StudyVar(name = "people:name")
        String tempName = name;
        this.name = tempName;
    }

    @StudyMethod(name = "hello")
    public String sayHello() {
        return "hello";
    }

}
