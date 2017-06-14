package com.example.guowei.mvpdemo;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.guowei.mvpdemo.bean.Student;
import com.example.guowei.mvpdemo.presenter.StudentPresenter;
import com.example.guowei.mvpdemo.view.StudentInfoShowView;

/**
 * Activity充当mvp模式中view层的作用，该层包含对视图的处理
 */
public class MainActivity extends AppCompatActivity implements StudentInfoShowView {
    //view层中对presenter的引用
    private StudentPresenter presenter;
    private TextView tvName,tvAge,tvGender;
    private ProgressBar mProgressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        presenter = new StudentPresenter(this);
        presenter.getStudentInfo(1);
    }

    private void initView() {
        tvName = (TextView) findViewById(R.id.tv_name);
        tvAge = (TextView) findViewById(R.id.tv_age);
        tvGender = (TextView) findViewById(R.id.tv_gender);
        mProgressBar = (ProgressBar) findViewById(R.id.progress);
    }

    @Override
    public void loading() {
        mProgressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void loadCancel() {
        mProgressBar.setVisibility(View.GONE);

    }

    @Override
    public void loadError(String error) {
        Toast.makeText(this,error,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getStudentInfo(Student student) {
        tvName.setText(student.getName());
        tvAge.setText(student.getAge()+"");
        tvGender.setText(student.getGender());

    }
}
