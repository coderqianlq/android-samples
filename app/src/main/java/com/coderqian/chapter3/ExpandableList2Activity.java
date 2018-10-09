package com.coderqian.chapter3;

import android.app.ExpandableListActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.coderqian.R;


/**
 * @author qianliqing
 * @since 2018-10-09 下午6:34
 * mail: qianlq0824@gmail.com
 */
public class ExpandableList2Activity extends ExpandableListActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ExpandableListAdapter adapter = new BaseExpandableListAdapter() {

            int[] logos = new int[]{
                    R.drawable.java,
                    R.drawable.database,
                    R.drawable.service
            };

            private String[] types = new String[]{"Java语言", "数据库", "微服务"};

            private String[][] titles = new String[][]{
                    {"线程生命周期以及线程创建的三种方式（面试必考题）", "Java线程池全面解析（面试必考题）", "Java类加载的过程和双亲委派机制"},
                    {"MySQL 乐观锁与悲观锁"},
                    {"Spring Cloud构建微服务架构（一）：服务注册与发现（Eureka）", "Spring Cloud构建微服务架构（二）：路由网关（Zuul）"}
            };

            private String[][] urls = new String[][]{
                    {"https://blog.csdn.net/weixin_36759405/article/details/82843399", "https://blog.csdn.net/weixin_36759405/article/details/82825634", "https://blog.csdn.net/weixin_36759405/article/details/82891712"},
                    {"https://blog.csdn.net/weixin_36759405/article/details/82780743"},
                    {"https://blog.csdn.net/weixin_36759405/article/details/82900121", "https://blog.csdn.net/weixin_36759405/article/details/82919686"}
            };

            public Object getChild(int groupPosition, int childPosition) {
                return titles[groupPosition][childPosition];
            }

            public long getChildId(int groupPosition, int childPosition) {
                return childPosition;
            }

            public int getChildrenCount(int groupPosition) {
                return titles[groupPosition].length;
            }

            ClickableSpan clickableSpan = new ClickableSpan() {
                @Override
                public void onClick(View view) {

                }

                @Override
                public void updateDrawState(TextPaint tp) {
                    tp.setUnderlineText(false);
                }
            };

            private TextView getTextView() {
                AbsListView.LayoutParams lp = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 64);
                TextView textView = new TextView(ExpandableList2Activity.this);
                textView.setLayoutParams(lp);
                textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.START);
                textView.setPadding(36, 0, 0, 0);
                textView.setTextSize(20);
                return textView;
            }

            public View getChildView(int groupPosition, int childPosition,
                                     boolean isLastChild, View convertView, ViewGroup parent) {
                TextView textView = getTextView();
                String title = getChild(groupPosition, childPosition).toString();
                SpannableString spannableString = new SpannableString(title);
                spannableString.setSpan(new URLSpan(urls[groupPosition][childPosition]), 0, title.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                spannableString.setSpan(clickableSpan, 0, title.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                spannableString.setSpan(new ForegroundColorSpan(Color.BLACK), 0, title.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                textView.setText(spannableString);
                textView.setTextColor(Color.BLACK);
                textView.setMovementMethod(LinkMovementMethod.getInstance());
                return textView;
            }

            public Object getGroup(int groupPosition) {
                return types[groupPosition];
            }

            public int getGroupCount() {
                return types.length;
            }

            public long getGroupId(int groupPosition) {
                return groupPosition;
            }

            public View getGroupView(int groupPosition, boolean isExpanded,
                                     View convertView, ViewGroup parent) {
                LinearLayout ll = new LinearLayout(ExpandableList2Activity.this);
                ll.setOrientation(LinearLayout.HORIZONTAL);
                ImageView logo = new ImageView(ExpandableList2Activity.this);
                logo.setImageResource(logos[groupPosition]);
                ll.addView(logo);
                TextView textView = getTextView();
                textView.setText(getGroup(groupPosition).toString());
                ll.addView(textView);
                return ll;
            }

            public boolean hasStableIds() {
                return true;
            }

            public boolean isChildSelectable(int groupPosition, int childPosition) {
                return true;
            }
        };

        setListAdapter(adapter);
    }

}
