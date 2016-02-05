package com.example.yuto.myapplicationtest;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    Boolean buttonflg = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comment);

        LayoutInflater inflater = (LayoutInflater)this.getSystemService(LAYOUT_INFLATER_SERVICE);
        final View layout = inflater.inflate(R.layout.comment_dialog,(ViewGroup)findViewById(R.id.comment_dialog));

        // commentボタン押した時の処理
        final Button comment_button = (Button)findViewById(R.id.comment_button);
        comment_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showToast();
                commentDialog();
            }
        });

        // mapボタンを押した時の処理
        final Button map_button = (Button)findViewById(R.id.map_button);
        map_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // 明示的intent でMAP起動
                Uri uri = Uri.parse("geo:0,0?q=東京駅");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

//                // ブラウザからMAPを表示する方法
//                Uri uri = Uri.parse("https://www.google.co.jp/maps/");
//                Intent i = new Intent(Intent.ACTION_VIEW, uri);
//                startActivity(i);
            }
        });

    }

    // アラートダイアログでコメント入力するよ
    private void commentDialog(){

        // カスタムビューを設定
        LayoutInflater inflater = (LayoutInflater)this.getSystemService(LAYOUT_INFLATER_SERVICE);
        final View layout = inflater.inflate(R.layout.comment_dialog, (ViewGroup)findViewById(R.id.comment_dialog));

        // アラートダイアログ を生成
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("コメンコ");
        builder.setView(layout);
        builder.setPositiveButton("OK", new OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // OK ボタン処理
                showToast();
                comment_add();
            }
        });
        builder.setNegativeButton("Cancel", new OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // Cancel ボタン処理
                // 現状 特に無し
                list_add();
            }
        });

        // 表示
        builder.create().show();
    }

    // toast出すよ
    private void showToast(){
        if (buttonflg) {
            Toast.makeText(this, "押したね！？父さんにも押されたことがないのに！！", Toast.LENGTH_LONG).show();
            buttonflg = false;
        }else{
            Toast.makeText(this, "2度も押したね！！", Toast.LENGTH_LONG).show();
            buttonflg = true;
        }
    }

    // comment_list
    private void comment_add(){
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        adapter.add("listview item 1");
        adapter.add("listview item 2");
        adapter.add("listview item 3");

        // リストビューにデータを設定
        ListView listView1 = (ListView)findViewById(R.id.comment_list);
        listView1.setAdapter(adapter);
    }

    // comment_list
    private void list_add(){
    // データの作成
        List<CommentListData> objects = new ArrayList<CommentListData>();
        CommentListData item1 = new CommentListData();

        CommentListData item2 = new CommentListData();

        CommentListData item3 = new CommentListData();

        objects.add(item1);
        objects.add(item2);
        objects.add(item3);

        CustomAdapter customAdapater = new CustomAdapter(this, 0, objects);

        ListView listView = (ListView)findViewById(R.id.comment_list);
        listView.setAdapter(customAdapater);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
