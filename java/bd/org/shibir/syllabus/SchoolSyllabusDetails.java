package bd.org.shibir.syllabus;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import bd.org.shibir.adapter.AdapterForSchoolSyllabus;
import bd.org.shibir.model.AllCompletedNoData;
import bd.org.shibir.model.SchoolSyllabus;

public class SchoolSyllabusDetails extends Activity implements OnItemClickListener {
    private int id;
    private String keyName;
    private ListView lvSchoolStudySyllabus;
    private SharedPreferences school;
    private TextView tvSchoolStudySyllabus;
    private TextView tvTotalCompleted;
    private TextView tvTotalNo;

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.syllabus_overview);
        this.id = getIntent().getIntExtra("id", 0);
        this.school = getSharedPreferences("school", 0);
        this.tvSchoolStudySyllabus = (TextView) findViewById(R.id.tvSyllabusOverview);
        this.tvTotalNo = (TextView) findViewById(R.id.tvTotalNoSO);
        this.tvTotalCompleted = (TextView) findViewById(R.id.tvTotalCompletedSO);
        this.lvSchoolStudySyllabus = (ListView) findViewById(R.id.lvSyllabusOverview);
        if (getIntent().getStringExtra("from").equals("school_overview_0")) {
            this.keyName = this.id + "school_quran";
            this.tvSchoolStudySyllabus.setText("আল-কুরআন");
            this.tvTotalNo.setText("6");
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberForSchool(this, this.keyName, this.id))).toString());
            this.lvSchoolStudySyllabus.setAdapter(new AdapterForSchoolSyllabus(this, SchoolSyllabus.schoolQuranBooks, SchoolSyllabus.schoolQuranWriters, this.keyName));
        }
        if (getIntent().getStringExtra("from").equals("school_overview_1")) {
            this.keyName = this.id + "school_hadith";
            this.tvSchoolStudySyllabus.setText("আল-হাদীস");
            this.tvTotalNo.setText("6");
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberForSchool(this, this.keyName, this.id))).toString());
            this.lvSchoolStudySyllabus.setAdapter(new AdapterForSchoolSyllabus(this, SchoolSyllabus.schoolHadithBooks, SchoolSyllabus.schoolHadithWriters, this.keyName));
        }
        if (getIntent().getStringExtra("from").equals("school_overview_2")) {
            this.keyName = this.id + "school_islmaic_ideoloay";
            this.tvSchoolStudySyllabus.setText("ইসলামী জীবন আদর্শ ");
            this.tvTotalNo.setText("7");
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberForSchool(this, this.keyName, this.id))).toString());
            this.lvSchoolStudySyllabus.setAdapter(new AdapterForSchoolSyllabus(this, SchoolSyllabus.schoolIslamicIdeology, SchoolSyllabus.schoolIslamicIdeologyWriters, this.keyName));
        }
        if (getIntent().getStringExtra("from").equals("school_overview_3")) {
            this.keyName = this.id + "school_prophet_life";
            this.tvSchoolStudySyllabus.setText("নবী-জীবন ও সাহাবা চরিত্র");
            this.tvTotalNo.setText("12");
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberForSchool(this, this.keyName, this.id))).toString());
            this.lvSchoolStudySyllabus.setAdapter(new AdapterForSchoolSyllabus(this, SchoolSyllabus.schoolProphetLife, SchoolSyllabus.schoolProphetLifeWriters, this.keyName));
        }
        if (getIntent().getStringExtra("from").equals("school_overview_4")) {
            this.keyName = this.id + "school_history";
            this.tvSchoolStudySyllabus.setText("ইতিহাস");
            this.tvTotalNo.setText("3");
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberForSchool(this, this.keyName, this.id))).toString());
            this.lvSchoolStudySyllabus.setAdapter(new AdapterForSchoolSyllabus(this, SchoolSyllabus.schoolHistory, SchoolSyllabus.schoolHistoryWriters, this.keyName));
        }
        if (getIntent().getStringExtra("from").equals("school_overview_5")) {
            this.keyName = this.id + "school_life";
            this.tvSchoolStudySyllabus.setText("জীবন কথা");
            this.tvTotalNo.setText("17");
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberForSchool(this, this.keyName, this.id))).toString());
            this.lvSchoolStudySyllabus.setAdapter(new AdapterForSchoolSyllabus(this, SchoolSyllabus.schoolLifeHistory, SchoolSyllabus.schoolLifeHistoryWriters, this.keyName));
        }
        if (getIntent().getStringExtra("from").equals("school_overview_6")) {
            this.keyName = this.id + "school_masyala";
            this.tvSchoolStudySyllabus.setText("মাসয়ালা");
            this.tvTotalNo.setText("2");
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberForSchool(this, this.keyName, this.id))).toString());
            this.lvSchoolStudySyllabus.setAdapter(new AdapterForSchoolSyllabus(this, SchoolSyllabus.schoolMasyalaMasayel, SchoolSyllabus.schoolMasyalaMasayelWriters, this.keyName));
        }
        if (getIntent().getStringExtra("from").equals("school_overview_7")) {
            this.keyName = this.id + "school_newspaper";
            this.tvSchoolStudySyllabus.setText("পত্র-পত্রিকা এবং অন্যান্য");
            this.tvTotalNo.setText("6");
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberForSchool(this, this.keyName, this.id))).toString());
            this.lvSchoolStudySyllabus.setAdapter(new AdapterForSchoolSyllabus(this, SchoolSyllabus.schoolNewspaper, SchoolSyllabus.schoolNewspaperWriters, this.keyName));
        }
        this.lvSchoolStudySyllabus.setOnItemClickListener(this);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int position, long ld) {
        CheckBox cb = (CheckBox) view.findViewById(R.id.cbBookStatus);
        Editor edit = this.school.edit();
        if (cb.isChecked()) {
            cb.setChecked(false);
            edit.putInt(this.keyName + position, 0);
        } else {
            cb.setChecked(true);
            edit.putInt(this.keyName + position, 1);
        }
        edit.commit();
        this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberForSchool(this, this.keyName, this.id))).toString());
    }
}
