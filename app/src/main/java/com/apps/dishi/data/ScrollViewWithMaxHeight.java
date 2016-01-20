package com.apps.dishi.data;

import android.content.Context;
import android.widget.ScrollView;


public class ScrollViewWithMaxHeight extends ScrollView {

    public ScrollViewWithMaxHeight(Context context) {
        super(context);
    }
    @Override
    protected void onMeasure ( int widthMeasureSpec, int heightMeasureSpec){

        heightMeasureSpec = MeasureSpec.makeMeasureSpec(400, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }
}
