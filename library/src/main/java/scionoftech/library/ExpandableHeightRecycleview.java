package scionoftech.library;

/**
 * Created by kshediv on 5/1/15.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class ExpandableHeightRecycleview extends RecyclerView {

    public ExpandableHeightRecycleview(Context context) {
        super(context);
    }

    public ExpandableHeightRecycleview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ExpandableHeightRecycleview(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        /** Calculate entire height by providing a very large height hint.
         But do not use the highest 2 bits of this integer; those are
         reserved for the MeasureSpec mode.**/
        int expandSpec = View.MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, View.MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);

        ViewGroup.LayoutParams params = getLayoutParams();
        params.height = getMeasuredHeight();

        setNestedScrollingEnabled(false);

    }
}
