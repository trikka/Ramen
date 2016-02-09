package com.example.yuto.myapplicationtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by yuto on 2016/01/31.
 */
public class CustomAdapter extends ArrayAdapter<CommentList> {
    private LayoutInflater layoutInflater_;

    public CustomAdapter(Context context, int textViewResourceId, List<CommentList> objects) {
        super(context, textViewResourceId, objects);
        layoutInflater_ = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 特定の行(position)のデータを得る
        CommentList item = (CommentList)getItem(position);

        // convertViewは使い回しされている可能性があるのでnullの時だけ新しく作る
        if (null == convertView) {
            convertView = layoutInflater_.inflate(R.layout.comment_list, null);
        }

        // CustomDataのデータをViewの各Widgetにセットする
//        ImageView imageView;
//        imageView = (ImageView)convertView.findViewById(R.id.image);
//        imageView.setImageBitmap(item.getImageData());

        TextView sTaste;
        sTaste = (TextView)convertView.findViewById(R.id.noodle);
        sTaste.setText(item.getsTaste());

        TextView sTopping;
        sTopping = (TextView)convertView.findViewById(R.id.topping);
        sTopping.setText(item.getsTopping());

        TextView sPrice;
        sPrice = (TextView)convertView.findViewById(R.id.price);
        sPrice.setText(item.getsPrice());

        TextView sComment;
        sComment = (TextView)convertView.findViewById(R.id.noodle_comment);
        sComment.setText(item.getsComment());

        return convertView;
    }
}
