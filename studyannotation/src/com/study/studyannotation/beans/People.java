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

    @StudyField(name = "protected:小美")
    protected String proName;

    @StudyField(name = "public:小美")
    public String pubName;

    @StudyField(name = "default:小美")
    String defName;

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
