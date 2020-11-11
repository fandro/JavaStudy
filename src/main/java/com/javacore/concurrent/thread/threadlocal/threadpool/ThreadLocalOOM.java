package com.javacore.concurrent.thread.threadlocal.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * threadLocal oom
 *
 * @author feako
 * @date 2018/11/30
 */
public class ThreadLocalOOM {
    public static final int Thread_pool_size=500;
    public static final int data_loop_size=10000;

    private static ThreadLocal<List<UserInfo>> threadLocal = new ThreadLocal<List<UserInfo>>();

    public static void main(String[] args) {
       ExecutorService es = Executors.newFixedThreadPool(Thread_pool_size);
        System.out.println(" --- start ---");

        for (int i = 0; i < Thread_pool_size; i++) {
            System.out.println(" --- put = "+i);

            es.execute(()->{
                threadLocal.set(new ThreadLocalOOM().addUserData());
            });
        }
        System.out.println(" --- finish ---");
    }

    public List<UserInfo> addUserData() {
        List<UserInfo> list = new ArrayList<>(data_loop_size);
        for (int i = 0; i < data_loop_size; i++) {
            list.add(new UserInfo("Mario leo"+i,"password","10"+i, "中国北京中关村宇宙中心"));
        }
        return list;
    }

    class UserInfo{
        private String userName;
        private String password;
        private String age;
        private String address;

        public UserInfo(String userName, String password, String age, String address) {
            this.userName = userName;
            this.password = password;
            this.age = age;
            this.address = address;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }
}
