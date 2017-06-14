package com.example.guowei.mvpdemo.presenter;

import android.os.Handler;

import com.example.guowei.mvpdemo.bean.Student;
import com.example.guowei.mvpdemo.model.StudentModel;
import com.example.guowei.mvpdemo.view.StudentInfoShowView;

/**
 * mvp模式中的presenter层
 * 起到view和model的沟通桥梁的作用
 * Created by Guowei on 2017/6/14.
 */

public class StudentPresenter {
    //presenter中包含的view的接口的引用
    private StudentInfoShowView studentInfoShowView;
    //presenter中包含的model的引用
    private StudentModel studentModel;
    private Handler handler = new Handler();

    public StudentPresenter(StudentInfoShowView studentInfoShowView) {
        this.studentInfoShowView = studentInfoShowView;
        this.studentModel = new StudentModel();
    }

    /**
     * 该方法用于view视图中调用
     * @param studentId
     */
    public void getStudentInfo(int studentId){
        //调用model中的业务逻辑
        studentModel.getStudentInfo(studentId, new GetStudentInfoListener() {
            @Override
            public void loading() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        studentInfoShowView.loading();
                    }
                });
            }

            //model获取数据成功，回调数据
            @Override
            public void success(final Student student) {
                //该ui要在ui线程中更新ui
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        studentInfoShowView.loadCancel();
                        studentInfoShowView.getStudentInfo(student);
                    }
                });

            }
            //model获取数据失败,回调失败原因
            @Override
            public void failed(final String error) {
                //该ui要在ui线程中更新ui
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        studentInfoShowView.loadCancel();
                        studentInfoShowView.loadError(error);
                    }
                });

            }
        });

    }

}
