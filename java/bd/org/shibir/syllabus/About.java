package bd.org.shibir.syllabus;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class About extends AppCompatActivity {
    private int position;
    private Spanned result;
    private TextView tvDetails;
    private TextView tvTitles;

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        this.tvDetails = (TextView) findViewById(R.id.tvDetailsAbout);
        this.tvDetails.setMovementMethod(LinkMovementMethod.getInstance());
        this.tvTitles = (TextView) findViewById(R.id.tvTitleAbout);
        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/Siyamrupali.ttf");
        this.tvDetails.setTypeface(tf);
        this.tvTitles.setTypeface(tf);
        this.result = Html.fromHtml(getResources().getString(R.string.about_syllabus));
        this.tvTitles.setText("ভূমিকা");
        this.tvDetails.setText(this.result);
    }
}
