package bd.org.shibir.syllabus;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import bd.org.shibir.adapter.AdapterForSyllabusOverview;

public class MemberSyllabusOverview extends AppCompatActivity implements OnItemClickListener {
    private int id;
    private ListView lvMemberSyllabus;
    private String[] syllabusList;

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.syllabus_overview_with_ab);
        this.id = getIntent().getIntExtra("id", 0);
        this.syllabusList = new String[]{"দারসুল কুরআন", "দারসুল হাদীস", "আলোচনা নোট", "আয়াত হাদীস মুখস্থকরন ", "বই নোট", "কুরআন অধ্যয়ন", "হাদীস অধ্যয়ন", "সাহিত্য অধ্যয়ন"};
        getSupportActionBar().setTitle(Html.fromHtml("<h3>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<b><font color=\"#008000\">সদস্য সিলেবাস</font></b></h3>"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#DCDCDC")));
        this.lvMemberSyllabus = (ListView) findViewById(R.id.lvSyllabusOverview);
        this.lvMemberSyllabus.setAdapter(new AdapterForSyllabusOverview(this, this.syllabusList));
        this.lvMemberSyllabus.setOnItemClickListener(this);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int position, long ld) {
        if (position == 0) {
            Intent i0 = new Intent(this, MemberSyllabusAlocona.class);
            i0.putExtra("from", "memeber_overview_0");
            i0.putExtra("id", this.id);
            startActivity(i0);
        }
        if (position == 1) {
            Intent i1 = new Intent(this, MemberSyllabusAlocona.class);
            i1.putExtra("from", "memeber_overview_1");
            i1.putExtra("id", this.id);
            startActivity(i1);
        }
        if (position == 2) {
            Intent i2 = new Intent(this, MemberSyllabusAlocona.class);
            i2.putExtra("from", "memeber_overview_2");
            i2.putExtra("id", this.id);
            startActivity(i2);
        }
        if (position == 3) {
            Intent i3 = new Intent(this, MemberAyatHadithMemorization.class);
            i3.putExtra("id", this.id);
            startActivity(i3);
        }
        if (position == 4) {
            Intent i4 = new Intent(this, SyllabusForBookNote.class);
            i4.putExtra("from", "memeber_overview_4");
            i4.putExtra("id", this.id);
            startActivity(i4);
        }
        if (position == 5) {
            Intent i5 = new Intent(this, MemberSyllabusSubCategory.class);
            i5.putExtra("from", "memeber_overview_5");
            i5.putExtra("id", this.id);
            startActivity(i5);
        }
        if (position == 6) {
            Intent i6 = new Intent(this, MemberSyllabusForBooks.class);
            i6.putExtra("from", "memeber_overview_6");
            i6.putExtra("id", this.id);
            startActivity(i6);
        }
        if (position == 7) {
            Intent i7 = new Intent(this, MemberSyllabusSubCategory.class);
            i7.putExtra("from", "memeber_overview_7");
            i7.putExtra("id", this.id);
            startActivity(i7);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.syllabus_overview_percentage, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuActionSettings /*2131034277*/:
                Intent i = new Intent(this, SyllabusInPercentageStatistics.class);
                i.putExtra("id", this.id);
                i.putExtra("from", "member_syllabus_overview");
                startActivity(i);
                break;
        }
        return true;
    }
}
