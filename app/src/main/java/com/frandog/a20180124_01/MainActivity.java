package com.frandog.a20180124_01;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//    要用23的模擬器，不能用26
//    可參考綠豆湯的"android 6.0 權限"文章

//    存取外部除存空間資料夾
    public void click1(View v)
    {
        File f = Environment.getExternalStorageDirectory();     //存取外部非受限制的儲存空間，跟getExternalFilesDir不同，即使在Manifestvu,寫入READ_EXTERNAL_STORAGE權限，不寫請求權對話框的話，還是無法讀寫

        File nf = new File(f,"DCIM" + File.separator + "myfile.txt");   //自己創一個myfile.txt丟進(在device monitor點右上角push a file)
        Log.d("FILE",nf.getAbsolutePath());
        if(nf.exists())
        {
            Log.d("FILE","nf 存在");
        }
        else
        {
            Log.d("FILE","nf 不存在");
        }
        try {
            FileReader fr = new FileReader(nf);
            BufferedReader br = new BufferedReader(fr);
            String str = br.readLine();
            Log.d("FILE", "Read:" + str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


//    存取"受限制"(android訂好的，也只能在該位置存取)的外部資料夾，與Environment.getExternalStorageDirectory()不同
    public void click2(View v)
    {
        File f = getExternalFilesDir("data");
        Log.d("FILE",f.getAbsolutePath());
    }
}

