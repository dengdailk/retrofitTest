package com.retrofit.lk.retrofittest;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.retrofit.lk.retrofittest.Util.SystemUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "MainActivity";
    @BindView(R2.id.btn_download_picture)
    Button mDownloadPicture;//下载图片按钮;
    @BindView(R2.id.btn_download_video)
    Button mDownloadVideo;//下载视频按钮;
    private Unbinder unbinder;


    //    private Context mContext;
    @BindView(R2.id.btn_back)
    FrameLayout backLayout;
    @BindView(R2.id.tv_toolbar_title)
    TextView toolbarTitle;


//    @OnClick({R.id.btn_download_picture, R.id.btn_download_video})
//    public void onViewClicked(View view) {
//        switch (view.getId()) {
//            case R.id.btn_download_picture:
////                Intent downloadPictureIntent = new Intent(MainActivity.this, DownloadPictureActivity.class);
////                startActivity(downloadPictureIntent);
//                break;
//            case R.id.btn_download_video:
////                Intent downloadVideoIntent = new Intent(MainActivity.this, DownloadVideoActivity.class);
////                startActivity(downloadVideoIntent);
//                break;
//        }
//    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //绑定初始化ButterKnife
        unbinder = ButterKnife.bind(this);

        //设置状态栏颜色
        SystemUtil.setLightStatusBar(MainActivity.this, Color.WHITE);

//        mContext = this;


        backLayout.setVisibility(View.GONE);


        toolbarTitle.setText(R.string.main_activity_title);

//        mDownloadPicture = findViewById(R.id.btn_download_picture);

        mDownloadPicture.setOnClickListener(this);

//        mDownloadVideo = findViewById(R.id.btn_download_video);
        mDownloadVideo.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v == mDownloadPicture) {
            Intent downloadPictureIntent = new Intent(MainActivity.this, DownloadPictureActivity.class);
            startActivity(downloadPictureIntent);
        } else if (v == mDownloadVideo) {
            Intent downloadVideoIntent = new Intent(MainActivity.this, DownloadVideoActivity.class);
            startActivity(downloadVideoIntent);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }


}
