package com.study.studyserialize.neans;

import java.io.*;

/**
 * @author jiayq
 * @Date 2020/8/18
 */
public class People implements Serializable {

    private static final long serialVersionUID = -6503146510165814266L;
    private String name;

    private static String staticName;

    public String publicName;

    protected String protectedName;

    transient String defaultName;

    private transient final String finalName = "finalName";

    private final static String finalStaticName = "staticFinalName";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getStaticName() {
        return staticName;
    }

    public static void setStaticName(String staticName) {
        People.staticName = staticName;
    }

    public String getPublicName() {
        return publicName;
    }

    public void setPublicName(String publicName) {
        this.publicName = publicName;
    }

    public String getProtectedName() {
        return protectedName;
    }

    public void setProtectedName(String protectedName) {
        this.protectedName = protectedName;
    }

    public String getDefaultName() {
        return defaultName;
    }

    public void setDefaultName(String defaultName) {
        this.defaultName = defaultName;
    }

    public String getFinalName() {
        return finalName;
    }

    public static String getFinalStaticName() {
        return finalStaticName;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", publicName='" + publicName + '\'' +
                ", protectedName='" + protectedName + '\'' +
                ", defaultName='" + defaultName + '\'' +
                ", finalName='" + finalName + '\'' +
                '}';
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.writeUTF("people : " + toString());
        stream.defaultWriteObject();
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        System.out.println(stream.readUTF());
        stream.defaultReadObject();
    }

}
