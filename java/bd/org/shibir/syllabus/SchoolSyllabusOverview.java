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

public class SchoolSyllabusOverview extends AppCompatActivity implements OnItemClickListener {
    private int id;
    private ListView lvSchoolSyllabus;
    private String[] syllabusList;

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.syllabus_overview_with_ab);
        this.id = getIntent().getIntExtra("id", 0);
        this.syllabusList = new String[]{"আল-কুরআন", "আল-হাদীস", "ইসলামী জীবন আদর্শ", "নবী-জীবন ও সাহাবা চরিত্র", "ইতিহাস", "জীবন কথা", "মাসয়ালা", "পত্র-পত্রিকা এবং অন্যান্য"};
        getSupportActionBar().setTitle(Html.fromHtml("<h3>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<b><font color=\"#008000\">স্কুল পাঠ্য</font></b></h3>"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#DCDCDC")));
        this.lvSchoolSyllabus = (ListView) findViewById(R.id.lvSyllabusOverview);
        this.lvSchoolSyllabus.setAdapter(new AdapterForSyllabusOverview(this, this.syllabusList));
        this.lvSchoolSyllabus.setOnItemClickListener(this);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int position, long ld) {
        Intent i = new Intent(this, SchoolSyllabusDetails.class);
        if (position == 0) {
            i.putExtra("from", "school_overview_0");
        }
        if (position == 1) {
            i.putExtra("from", "school_overview_1");
        }
        if (position == 2) {
            i.putExtra("from", "school_overview_2");
        }
        if (position == 3) {
            i.putExtra("from", "school_overview_3");
        }
        if (position == 4) {
            i.putExtra("from", "school_overview_4");
        }
        if (position == 5) {
            i.putExtra("from", "school_overview_5");
        }
        if (position == 6) {
            i.putExtra("from", "school_overview_6");
        }
        if (position == 7) {
            i.putExtra("from", "school_overview_7");
        }
        i.putExtra("id", this.id);
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
                i.putExtra("from", "school_syllabus_overview");
                i.putExtra("id", this.id);
                startActivity(i);
                break;
        }
        return true;
    }
}
