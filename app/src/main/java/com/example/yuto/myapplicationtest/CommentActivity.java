package com.example.yuto.myapplicationtest;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuto on 2016/01/31.
 */

public class CommentActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comment);

        // データの作成
        List<CommentListData> objects = new ArrayList<CommentListData>();
        CommentListData item1 = new CommentListData();
        item1.setsComment("image");
        item1.setsTaste("１つ目〜");

        CommentListData item2 = new CommentListData();
        item2.setsComment("もちごめ");
        item2.setsTaste("The second");

        CommentListData item3 = new CommentListData();
        item3.setsComment("popopo");
        item3.setsTaste("Il terzo");

        objects.add(item1);
        objects.add(item2);
        objects.add(item3);

        CustomAdapter customAdapater = new CustomAdapter(this, 0, objects);

        ListView listView = (ListView)findViewById(R.id.comment_list);
        listView.setAdapter(customAdapater);
    }
}

