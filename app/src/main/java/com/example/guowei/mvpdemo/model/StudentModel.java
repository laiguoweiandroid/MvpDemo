package com.example.guowei.mvpdemo.model;

import android.content.Context;

import com.example.guowei.mvpdemo.bean.Student;
import com.example.guowei.mvpdemo.presenter.GetStudentInfoListener;

/**
 * model层 业务逻辑和数据处理
 * Created by Guowei on 2017/6/13.
 */

public class StudentModel {
    public StudentModel() {
    }
    public void getStudentInfo(final int studentId, final GetStudentInfoListener listener){
        //开启一条子线程
        Thread thread =new Thread(new Runnable() {
            @Override
            public void run() {
                listener.loading();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(studentId==1){
                    Student s=new Student();
                    s.setId(007);
                    s.setAge(25);
                    s.setGender("男");
                    s.setName("张三");
                    listener.success(s);
                }else{
                    listener.failed("该用户不存在");
                }

            }
        });
        thread.start();

    }

}
