package com.kevin.app;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.kevin.app.module.login1.view.LoginActivity;
import com.kevin.app.module.login2.view.LoginMvpActivity;
import com.kevin.app.module.profit.view.ProfitMvpActivity;
import com.kevin.app.module.register.view.RegisterMvpActivity;

import java.io.File;
import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    protected File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_login,R.id.btn_login_mvp,R.id.btn_register_mvp,R.id.btn_list_mvp,R.id.btn_system_share})
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.btn_login:
                intent.setClass(this, LoginActivity.class);
                break;
            case R.id.btn_login_mvp:
                intent.setClass(this, LoginMvpActivity.class);
                break;
            case R.id.btn_register_mvp:
                intent.setClass(this, RegisterMvpActivity.class);
                break;
            case R.id.btn_list_mvp:
                intent.setClass(this, ProfitMvpActivity.class);
                break;
            case R.id.btn_system_share:
//                第一种分享
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        file = SaveNetImageUtil.saveImageToSdCard(MainActivity.this, "http://test.jubao56.com/res/2018/03/23/16/3421242/2K18.png");
//                        shareMultiplePictureToTimeLine(file);
//                    }
//                }).start();
//                /** 第二种分享 */
//                shareWeixin();

                break;
        }
        // 跳转其它activity
//        startActivity(intent);
    }

    /** the first mode*/
    private void shareMultiplePictureToTimeLine(File... files) {
        Intent intent = new Intent();
        ComponentName comp = new ComponentName("com.tencent.mm",
                "com.tencent.mm.ui.tools.ShareToTimeLineUI");
        intent.setComponent(comp);
        intent.setAction(Intent.ACTION_SEND_MULTIPLE);
        intent.setType("image/*");

        ArrayList<Uri> imageUris = new ArrayList<>();
        for (File f : files) {
            Uri contentUri = FileProvider.getUriForFile(this, BuildConfig.APPLICATION_ID + ".fileProvider", f);
            imageUris.add(contentUri);
        }
        intent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, imageUris);
        intent.putExtra("Kdescription", "系统测试分享");
        startActivity(intent);
    }


    /** the second mode*/
    private String getResourcesUri(@DrawableRes int id) {
        Resources resources = getResources();
        String uriPath = ContentResolver.SCHEME_ANDROID_RESOURCE + "://" +
                resources.getResourcePackageName(id) + "/" +
                resources.getResourceTypeName(id) + "/" +
                resources.getResourceEntryName(id);
        return uriPath;
    }

    private void shareWeixin() {
        ArrayList<Uri> imageUris = new ArrayList<>();
        Uri uri1 = Uri.parse(getResourcesUri(R.mipmap.ic_launcher));
        Uri uri2 = Uri.parse(getResourcesUri(R.mipmap.ic_launcher));
        imageUris.add(uri1);
        imageUris.add(uri2);
        Intent mulIntent = new Intent(Intent.ACTION_SEND_MULTIPLE);
        mulIntent.setPackage("com.tencent.mm");
        mulIntent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, imageUris);
        mulIntent.setType("image/jpeg");
//        mulIntent.putExtra("Kdescription", "系统测试分享");
        // 分享手机支持分享的App
//        startActivity(Intent.createChooser(mulIntent,"多文件分享"));
        startActivity(mulIntent);

//         // 分享到微信好友(文字)
//        Intent wechatIntent = new Intent(Intent.ACTION_SEND);
//        wechatIntent.setPackage("com.tencent.mm");
//        wechatIntent.setType("text/plain");
//        wechatIntent.putExtra(Intent.EXTRA_TEXT, "分享到微信的内容");
//        startActivity(wechatIntent);

    }

}
