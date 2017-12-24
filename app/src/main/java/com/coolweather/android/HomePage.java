package com.coolweather.android;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.coolweather.android.util.Data;
import com.coolweather.android.util.GlideImageLoader;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by mr.c on 2017/12/22.
 */

public class HomePage extends AppCompatActivity{
    private Integer[] image={R.drawable.timg,R.drawable.timg1,
            R.drawable.timg2};
    private List<Data> list=new ArrayList<>();
    List<Uri> uri=new ArrayList<>();
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        ButterKnife.bind(this);
        for(int i=0;i<image.length;i++){
            Uri uri1 = resourceIdToUri(this, image[i]);
            uri.add(uri1);
        }
        setImage();
        setBanner();
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent=new Intent(getApplicationContext(),WeatherActivity.class);
                    startActivity(intent);
                    finish();

            }
        });
    }

    public static final String ANDROID_RESOURCE = "android.resource://";
    public static final String FOREWARD_SLASH = "/";
    private static Uri resourceIdToUri(Context context, int resourceId) {
        String s=ANDROID_RESOURCE + context.getPackageName() + FOREWARD_SLASH + resourceId;
        return Uri.parse(ANDROID_RESOURCE + context.getPackageName() + FOREWARD_SLASH + resourceId);
    }
    public void setImage(){
        for(int i=0;i<image.length;i++){
            Data d=new Data(image[i]);
            list.add(d);
        }
    }
    @BindView(R.id.banner_id)
    Banner br;
    public  void setBanner(){
        br.setImageLoader(new GlideImageLoader()).setImages(uri).start();
    }
    @BindView(R.id.tv_launcher_timer)
    TextView tv;
}
