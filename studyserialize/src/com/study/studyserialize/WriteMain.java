package com.study.studyserialize;

import com.study.studyserialize.neans.People;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author jiayq
 * @Date 2020/8/18
 */
public class WriteMain {

    public static void main(String[] args) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("./people.txt"));) {
            People people = new People();
            people.setName("小美");
            people.setDefaultName("default小美");
            people.setProtectedName("protected小美");
            people.setPublicName("public小美");
            outputStream.writeObject(people);
            System.out.println(people);
            outputStream.flush();
        }
    }

}
