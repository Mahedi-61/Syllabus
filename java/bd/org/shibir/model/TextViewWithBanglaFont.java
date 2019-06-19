package bd.org.shibir.model;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class TextViewWithBanglaFont extends android.support.v7.widget.AppCompatTextView {
    private Context c;

    public TextViewWithBanglaFont(Context c) {
        super(c);
        this.c = c;
        setTypeface(Typeface.createFromAsset(c.getAssets(), "fonts/Siyamrupali.ttf"));
    }

    public TextViewWithBanglaFont(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.c = context;
        setTypeface(Typeface.createFromAsset(this.c.getAssets(), "fonts/Siyamrupali.ttf"));
    }

    public TextViewWithBanglaFont(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.c = context;
        setTypeface(Typeface.createFromAsset(this.c.getAssets(), "fonts/Siyamrupali.ttf"));
    }
}
