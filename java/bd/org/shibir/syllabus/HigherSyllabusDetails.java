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
import bd.org.shibir.adapter.AdapterForHigherSyllabus;
import bd.org.shibir.model.AllCompletedNoData;
import bd.org.shibir.model.HigherSyllabus;

public class HigherSyllabusDetails extends Activity implements OnItemClickListener {
    private SharedPreferences higher;
    private String keyName;
    private ListView lvHigherStudySyllabus;
    private TextView tvHigherStudySyllabus;
    private TextView tvTotalCompleted;
    private TextView tvTotalNo;

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.syllabus_overview);
        this.higher = getSharedPreferences("higher", 0);
        this.tvHigherStudySyllabus = (TextView) findViewById(R.id.tvSyllabusOverview);
        this.tvTotalNo = (TextView) findViewById(R.id.tvTotalNoSO);
        this.tvTotalCompleted = (TextView) findViewById(R.id.tvTotalCompletedSO);
        this.lvHigherStudySyllabus = (ListView) findViewById(R.id.lvSyllabusOverview);
        if (getIntent().getStringExtra("from").equals("higher_overview_0")) {
            this.keyName = "higher_quran";
            this.tvHigherStudySyllabus.setText("আল-কুরআন");
            this.tvTotalNo.setText("18");
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberForHigher(this, this.keyName))).toString());
            this.lvHigherStudySyllabus.setAdapter(new AdapterForHigherSyllabus(this, HigherSyllabus.higherQuran, HigherSyllabus.higherQuranWriters, this.keyName));
        }
        if (getIntent().getStringExtra("from").equals("higher_overview_1")) {
            this.keyName = "higher_hadith";
            this.tvHigherStudySyllabus.setText("আল-হাদীস");
            this.tvTotalNo.setText("9");
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberForHigher(this, this.keyName))).toString());
            this.lvHigherStudySyllabus.setAdapter(new AdapterForHigherSyllabus(this, HigherSyllabus.higherHadith, HigherSyllabus.higherHadithWriters, this.keyName));
        }
        if (getIntent().getStringExtra("from").equals("higher_overview_2")) {
            this.keyName = "higher_islmaic_philosophy";
            this.tvHigherStudySyllabus.setText("ইসলামী দর্শণ ");
            this.tvTotalNo.setText("12");
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberForHigher(this, this.keyName))).toString());
            this.lvHigherStudySyllabus.setAdapter(new AdapterForHigherSyllabus(this, HigherSyllabus.higherPhilosophy, HigherSyllabus.higherPhilosophyWriters, this.keyName));
        }
        if (getIntent().getStringExtra("from").equals("higher_overview_3")) {
            this.keyName = "higher_social_binding";
            this.tvHigherStudySyllabus.setText("ইসলামের সমাজ বিধান");
            this.tvTotalNo.setText("21");
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberForHigher(this, this.keyName))).toString());
            this.lvHigherStudySyllabus.setAdapter(new AdapterForHigherSyllabus(this, HigherSyllabus.higherSocialBinding, HigherSyllabus.higherSocialBindingWriters, this.keyName));
        }
        if (getIntent().getStringExtra("from").equals("higher_overview_4")) {
            this.keyName = "higher_economy";
            this.tvHigherStudySyllabus.setText("ইসলামী অর্থনীতি");
            this.tvTotalNo.setText("17");
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberForHigher(this, this.keyName))).toString());
            this.lvHigherStudySyllabus.setAdapter(new AdapterForHigherSyllabus(this, HigherSyllabus.higherEconomics, HigherSyllabus.higherEconomicsWriters, this.keyName));
        }
        if (getIntent().getStringExtra("from").equals("higher_overview_5")) {
            this.keyName = "higher_political_situation";
            this.tvHigherStudySyllabus.setText("ইসলামের রাজনৈতিক অবস্থা");
            this.tvTotalNo.setText("13");
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberForHigher(this, this.keyName))).toString());
            this.lvHigherStudySyllabus.setAdapter(new AdapterForHigherSyllabus(this, HigherSyllabus.higherPoliticalSituation, HigherSyllabus.higherPoliticalSituationWriters, this.keyName));
        }
        if (getIntent().getStringExtra("from").equals("higher_overview_6")) {
            this.keyName = "higher_educational_system";
            this.tvHigherStudySyllabus.setText("ইসলামী শিক্ষা ব্যবস্থা");
            this.tvTotalNo.setText("12");
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberForHigher(this, this.keyName))).toString());
            this.lvHigherStudySyllabus.setAdapter(new AdapterForHigherSyllabus(this, HigherSyllabus.higherEducationalSystem, HigherSyllabus.higherEducationalSystemWriters, this.keyName));
        }
        if (getIntent().getStringExtra("from").equals("higher_overview_7")) {
            this.keyName = "higher_comparative_study";
            this.tvHigherStudySyllabus.setText("তূলনামূরক অধ্যয়নঃ (অন্যান্য মতবাদ ও ইসলাম)");
            this.tvTotalNo.setText("27");
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberForHigher(this, this.keyName))).toString());
            this.lvHigherStudySyllabus.setAdapter(new AdapterForHigherSyllabus(this, HigherSyllabus.higherComparativeStudy, HigherSyllabus.higherComparativeStudyWriters, this.keyName));
        }
        if (getIntent().getStringExtra("from").equals("higher_overview_8")) {
            this.keyName = "higher_islam_science";
            this.tvHigherStudySyllabus.setText("ইসলাম ও বিজ্ঞান");
            this.tvTotalNo.setText("10");
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberForHigher(this, this.keyName))).toString());
            this.lvHigherStudySyllabus.setAdapter(new AdapterForHigherSyllabus(this, HigherSyllabus.higherIslamAndScience, HigherSyllabus.higherIslamAndScienceWriters, this.keyName));
        }
        if (getIntent().getStringExtra("from").equals("higher_overview_9")) {
            this.keyName = "higher_world_literature";
            this.tvHigherStudySyllabus.setText("বিশ্ব সাহিত্যঃ ইসলামী পরিপ্রেক্ষিত");
            this.tvTotalNo.setText("6");
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberForHigher(this, this.keyName))).toString());
            this.lvHigherStudySyllabus.setAdapter(new AdapterForHigherSyllabus(this, HigherSyllabus.higherWorldLiterature, HigherSyllabus.higherWorldLiteratureWriters, this.keyName));
        }
        if (getIntent().getStringExtra("from").equals("higher_overview_10")) {
            this.keyName = "higher_communism";
            this.tvHigherStudySyllabus.setText("সমাজতন্ত্র");
            this.tvTotalNo.setText("18");
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberForHigher(this, this.keyName))).toString());
            this.lvHigherStudySyllabus.setAdapter(new AdapterForHigherSyllabus(this, HigherSyllabus.higherCommunism, HigherSyllabus.higherCommunismWriters, this.keyName));
        }
        if (getIntent().getStringExtra("from").equals("higher_overview_11")) {
            this.keyName = "higher_society_culture";
            this.tvHigherStudySyllabus.setText("বাংলাদেশের সমাজ ও সংস্কৃতি");
            this.tvTotalNo.setText("13");
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberForHigher(this, this.keyName))).toString());
            this.lvHigherStudySyllabus.setAdapter(new AdapterForHigherSyllabus(this, HigherSyllabus.higherSocietyAndCulture, HigherSyllabus.higherSocietyAndCultureWriters, this.keyName));
        }
        if (getIntent().getStringExtra("from").equals("higher_overview_12")) {
            this.keyName = "higher_literature_culture";
            this.tvHigherStudySyllabus.setText("বাংলাদেশের সাহিত্য ও সাংস্কৃতিক আন্দোলন");
            this.tvTotalNo.setText("17");
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberForHigher(this, this.keyName))).toString());
            this.lvHigherStudySyllabus.setAdapter(new AdapterForHigherSyllabus(this, HigherSyllabus.higherLiteratureAndCulture, HigherSyllabus.higherLiteratureAndCultureWriters, this.keyName));
        }
        if (getIntent().getStringExtra("from").equals("higher_overview_13")) {
            this.keyName = "higher_bangladesh_politics";
            this.tvHigherStudySyllabus.setText("বাংলাদেশের রাজনীতি ও তার গতিধারা");
            this.tvTotalNo.setText("22");
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberForHigher(this, this.keyName))).toString());
            this.lvHigherStudySyllabus.setAdapter(new AdapterForHigherSyllabus(this, HigherSyllabus.higherPoliticsInBangladesh, HigherSyllabus.higherPoliticsInBangladeshWriters, this.keyName));
        }
        if (getIntent().getStringExtra("from").equals("higher_overview_14")) {
            this.keyName = "higher_social_problems";
            this.tvHigherStudySyllabus.setText("বাংলাদেশের সমসামিয়ক সামাজিক সমস্যা ও সমাধান");
            this.tvTotalNo.setText("10");
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberForHigher(this, this.keyName))).toString());
            this.lvHigherStudySyllabus.setAdapter(new AdapterForHigherSyllabus(this, HigherSyllabus.higherSocialProblems, HigherSyllabus.higherSocialProblemsWriters, this.keyName));
        }
        if (getIntent().getStringExtra("from").equals("higher_overview_15")) {
            this.keyName = "higher_islamic_movement";
            this.tvHigherStudySyllabus.setText("বর্তমান দুনিয়ার ইসলামী আন্দোলন");
            this.tvTotalNo.setText("13");
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberForHigher(this, this.keyName))).toString());
            this.lvHigherStudySyllabus.setAdapter(new AdapterForHigherSyllabus(this, HigherSyllabus.higherPresentIslamicMovement, HigherSyllabus.higherPresentIslamicMovementWriters, this.keyName));
        }
        if (getIntent().getStringExtra("from").equals("higher_overview_16")) {
            this.keyName = "higher_muslim_world";
            this.tvHigherStudySyllabus.setText("মুসলিম বিশ্ব");
            this.tvTotalNo.setText("15");
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberForHigher(this, this.keyName))).toString());
            this.lvHigherStudySyllabus.setAdapter(new AdapterForHigherSyllabus(this, HigherSyllabus.higherMuslimWorld, HigherSyllabus.higherMuslimWorldWriters, this.keyName));
        }
        if (getIntent().getStringExtra("from").equals("higher_overview_17")) {
            this.keyName = "higher_international_politics";
            this.tvHigherStudySyllabus.setText("আন্তর্জাতিক রাজনীতি");
            this.tvTotalNo.setText("9");
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberForHigher(this, this.keyName))).toString());
            this.lvHigherStudySyllabus.setAdapter(new AdapterForHigherSyllabus(this, HigherSyllabus.higherInternationalPolitics, HigherSyllabus.higherInternationalPoliticsWriters, this.keyName));
        }
        if (getIntent().getStringExtra("from").equals("higher_overview_18")) {
            this.keyName = "higher_akayed";
            this.tvHigherStudySyllabus.setText("আকায়েদ");
            this.tvTotalNo.setText("19");
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberForHigher(this, this.keyName))).toString());
            this.lvHigherStudySyllabus.setAdapter(new AdapterForHigherSyllabus(this, HigherSyllabus.higherAkayed, HigherSyllabus.higherAkayedWriters, this.keyName));
        }
        if (getIntent().getStringExtra("from").equals("higher_overview_19")) {
            this.keyName = "higher_masyala_masayel";
            this.tvHigherStudySyllabus.setText("মাসয়ালা-মাসায়েল");
            this.tvTotalNo.setText("10");
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberForHigher(this, this.keyName))).toString());
            this.lvHigherStudySyllabus.setAdapter(new AdapterForHigherSyllabus(this, HigherSyllabus.higherMasyalaMasayel, HigherSyllabus.higherMasyalaMasayelWriters, this.keyName));
        }
        if (getIntent().getStringExtra("from").equals("higher_overview_20")) {
            this.keyName = "higher_fikah";
            this.tvHigherStudySyllabus.setText("ফিকাহ ও ইসলামী আইন");
            this.tvTotalNo.setText("16");
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberForHigher(this, this.keyName))).toString());
            this.lvHigherStudySyllabus.setAdapter(new AdapterForHigherSyllabus(this, HigherSyllabus.higherFikah, HigherSyllabus.higherFikahWriters, this.keyName));
        }
        this.lvHigherStudySyllabus.setOnItemClickListener(this);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int position, long ld) {
        CheckBox cb = (CheckBox) view.findViewById(R.id.cbBookStatus);
        Editor edit = this.higher.edit();
        if (cb.isChecked()) {
            cb.setChecked(false);
            edit.putInt(this.keyName + position, 0);
        } else {
            cb.setChecked(true);
            edit.putInt(this.keyName + position, 1);
        }
        edit.commit();
        this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberForHigher(this, this.keyName))).toString());
    }
}
