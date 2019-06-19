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

public class HigherSyllabusOverview extends AppCompatActivity implements OnItemClickListener {
    private ListView lvSchoolSyllabus;
    private String[] syllabusList;

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.syllabus_overview_with_ab);
        this.syllabusList = new String[]{"আল-কুরআন", "আল-হাদীস", "ইসলামী দর্শন ", "ইসলামের সমাজ বিধান", "ইসলামী অর্থনীতি", "ইসলামের রাজনৈতিক অবস্থা", "ইসলামী শিক্ষা ব্যবস্থা", "তূলনামূরক অধ্যয়নঃ (ধর্মীয়, অন্যান্য মতবাদ ও ইসলাম)", "ইসলাম ও বিজ্ঞান", "বিশ্ব সাহিত্যঃ ইসলামী পরিপ্রেক্ষিতঃ তুলনামূলক অধ্যয়ন", "সমাজতন্ত্র", "বাংলাদেশের সমাজ ও সংস্কৃতি", "বাংলাদেশের সাহিত্য ও সাংস্কৃতিক আন্দোলন", "বাংলাদেশের রাজনীতি ও তার গতিধারা", "বাংলাদেশের সমসামিয়ক সামাজিক সমস্যা ও সমাধান", "বর্তমান দুনিয়ার ইসলামী আন্দোলন", "মুসলিম বিশ্ব", "আন্তর্জাতিক রাজনীতি", "আকায়েদ", "মাসয়ালা-মাসায়েল", "ফিকাহ ও ইসলামী আইন"};
        getSupportActionBar().setTitle(Html.fromHtml("<h3>&nbsp&nbsp&nbsp&nbsp<b><font color=\"#008000\">উচচতর সিলেবাস</font></b></h3>"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#DCDCDC")));
        this.lvSchoolSyllabus = (ListView) findViewById(R.id.lvSyllabusOverview);
        this.lvSchoolSyllabus.setAdapter(new AdapterForSyllabusOverview(this, this.syllabusList));
        this.lvSchoolSyllabus.setOnItemClickListener(this);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Intent i = new Intent(this, HigherSyllabusDetails.class);
        if (position == 0) {
            i.putExtra("from", "higher_overview_0");
        }
        if (position == 1) {
            i.putExtra("from", "higher_overview_1");
        }
        if (position == 2) {
            i.putExtra("from", "higher_overview_2");
        }
        if (position == 3) {
            i.putExtra("from", "higher_overview_3");
        }
        if (position == 4) {
            i.putExtra("from", "higher_overview_4");
        }
        if (position == 5) {
            i.putExtra("from", "higher_overview_5");
        }
        if (position == 6) {
            i.putExtra("from", "higher_overview_6");
        }
        if (position == 7) {
            i.putExtra("from", "higher_overview_7");
        }
        if (position == 8) {
            i.putExtra("from", "higher_overview_8");
        }
        if (position == 9) {
            i.putExtra("from", "higher_overview_9");
        }
        if (position == 10) {
            i.putExtra("from", "higher_overview_10");
        }
        if (position == 11) {
            i.putExtra("from", "higher_overview_11");
        }
        if (position == 12) {
            i.putExtra("from", "higher_overview_12");
        }
        if (position == 13) {
            i.putExtra("from", "higher_overview_13");
        }
        if (position == 14) {
            i.putExtra("from", "higher_overview_14");
        }
        if (position == 15) {
            i.putExtra("from", "higher_overview_15");
        }
        if (position == 16) {
            i.putExtra("from", "higher_overview_16");
        }
        if (position == 17) {
            i.putExtra("from", "higher_overview_17");
        }
        if (position == 18) {
            i.putExtra("from", "higher_overview_18");
        }
        if (position == 19) {
            i.putExtra("from", "higher_overview_19");
        }
        if (position == 20) {
            i.putExtra("from", "higher_overview_20");
        }
        startActivity(i);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.syllabus_overview_percentage, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuActionSettings /*2131034277*/:
                Intent i = new Intent(this, SyllabusInPercentageStatistics.class);
                i.putExtra("from", "higher_syllabus_overview");
                startActivity(i);
                break;
        }
        return true;
    }
}
