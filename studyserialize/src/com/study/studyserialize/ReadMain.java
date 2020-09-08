package com.study.studyserialize;

import com.study.studyserialize.neans.People;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @author jiayq
 * @Date 2020/8/18
 */
public class ReadMain {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("./people.txt"));) {
            People people = (People) inputStream.readObject();
            System.out.println(people);
        }
    }

}
