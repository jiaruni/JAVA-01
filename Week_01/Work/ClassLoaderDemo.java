package jvm;

import java.io.FileInputStream;
import java.lang.reflect.Method;

public class ClassLoaderDemo extends ClassLoader{

    public static void main(String[] args) throws Exception {
        FileInputStream input = new FileInputStream("E:\\java进阶\\第一课\\Hello\\Hello.xlass");
        int read , i = 0;
        byte[] buffer =  new byte[1024];
        while((read=input.read())!=-1) {
            buffer[i] = (byte) (255 - read);
            i++;
        }
        Class<?> hello = new ClassLoaderDemo().findClass("Hello", buffer, i);
        Method[] methods = hello.getMethods();
        Object o = hello.newInstance();
        methods[0].invoke(o);
        System.out.println(methods[0]);
    }
    protected Class<?> findClass(String name,byte[] bytes,int length) throws ClassNotFoundException {
        return defineClass(name,bytes,0,length);
    }
}
