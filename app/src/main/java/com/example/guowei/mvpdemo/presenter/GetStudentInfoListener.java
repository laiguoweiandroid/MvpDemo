package com.example.guowei.mvpdemo.presenter;

import com.example.guowei.mvpdemo.bean.Student;

/**
 * 该接口用于model与presenter的交互
 * 是对model数据的回调
 * Created by Guowei on 2017/6/14.
 */

public interface GetStudentInfoListener {
    void loading();
    void success(Student student);
    void failed(String error);
}
