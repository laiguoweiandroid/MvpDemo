package com.example.guowei.mvpdemo.view;

import com.example.guowei.mvpdemo.bean.Student;

/**
 * view层提供的接口
 * Created by Guowei on 2017/6/14.
 */

public interface StudentInfoShowView {
    void loading();
    void loadCancel();
    void loadError(String error);
    void getStudentInfo(Student student);
}
