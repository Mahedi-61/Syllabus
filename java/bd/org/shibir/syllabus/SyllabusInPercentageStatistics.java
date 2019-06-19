package bd.org.shibir.syllabus;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import bd.org.shibir.adapter.AdapterForSyllabusInPercentageStatistics;
import bd.org.shibir.model.AllCompletedNoData;

public class SyllabusInPercentageStatistics extends Activity {
    private int id;
    private String[] keyList;
    private ListView lvPercentageReport;
    private int[] totalNumber;
    private TextView tvHeading;
    private String type;
    private String[] viewList;

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus_percentage_report);
        this.tvHeading = (TextView) findViewById(R.id.tvHeadingPercentageReport);
        this.lvPercentageReport = (ListView) findViewById(R.id.lvPercentageReport);
        if (getIntent().getStringExtra("from").equals("worker_syllabus_overview")) {
            this.id = getIntent().getIntExtra("id", 0);
            this.viewList = new String[]{"আল-কুরআন", "আল-হাদীস", "সংগঠন ও ইসলামী আন্দোলন", "ইসলামী আদর্শ", "মাসয়ালা-মাসায়েল", "বিবিধ"};
            this.keyList = new String[]{this.id + "worker_quran", this.id + "worker_hadith", this.id + "worker_organization", this.id + "worker_islamic_ideology", this.id + "worker_masyala", this.id + "worker_miscellaneous"};
            this.totalNumber = new int[]{13, 1, 2, 6, 1, 2};
            this.type = "worker";
            this.tvHeading.setText("কর্মী সিলেবাস");
        }
        if (getIntent().getStringExtra("from").equals("associate_syllabus_overview")) {
            this.id = getIntent().getIntExtra("id", 0);
            this.viewList = new String[]{"দারসুল কোরআন", "দারসুল হাদীস", "আলোচনা নোট", "আয়াত মুখস্থকরন ", "হাদীস মুখস্তকরন", "বই নোট", "অর্থসহ সূরা মুখস্ত", "কুরআন  অধ্যয়ন ", "হাদীস অধ্যয়ন", "সাহিত্য অধ্যয়ন"};
            this.keyList = new String[]{this.id + "associate_darsul_quran", this.id + "associate_darsul_hadith", this.id + "associate_alocona_note", this.id + "associate_ayat_memorization", this.id + "associate_hadith_memorization", this.id + "associate_book_note", this.id + "associate_quran_sura", this.id + "associate_quran_tafsir", this.id + "associate_hadith_study", this.id + "associate_literature_study"};
            this.totalNumber = new int[]{2, 1, 2, 30, 15, 4, 11, 16, 4, 48};
            this.type = "associate";
            this.tvHeading.setText("সাথী সিলেবাস");
            AllCompletedNoData.getSumOfAssociateLiteratureStudy(this, this.id);
        }
        if (getIntent().getStringExtra("from").equals("member_syllabus_overview")) {
            this.id = getIntent().getIntExtra("id", 0);
            this.viewList = new String[]{"দারসুল কোরআন", "দারসুল হাদীস", "আলোচনা নোট", "আয়াত মুখস্থকরন ", "হাদীস মুখস্তকরন", "বই নোট", "কুরআন তিলাওয়াত", "কুরআন অধ্যয়ন", "হাদীস অধ্যয়ন", "সাহিত্য অধ্যয়ন"};
            this.keyList = new String[]{this.id + "member_darsul_quran", this.id + "member_darsul_hadith", this.id + "member_alocona_note", this.id + "member_ayat_memorization", this.id + "member_hadith_memorization", this.id + "member_book_note", this.id + "member_quran_sura", this.id + "member_quran_tafsir", this.id + "member_hadith_study", this.id + "member_literature_study"};
            this.totalNumber = new int[]{10, 7, 10, 100, 35, 12, 114, 24, 19, 89};
            this.type = "member";
            this.tvHeading.setText("সদস্য সিলেবাস");
            AllCompletedNoData.getSumOfMemberLiteratureStudy(this, this.id);
        }
        if (getIntent().getStringExtra("from").equals("school_syllabus_overview")) {
            this.id = getIntent().getIntExtra("id", 0);
            this.viewList = new String[]{"আল-কুরআন", "আল-হাদীস", "ইসলামী জীবন আদর্শ", "নবী-জীবন ও সাহাবা চরিত্র", "ইতিহাস", "জীবন কথা", "মাসয়ালা", "পত্র-পত্রিকা এবং অন্যান্য"};
            this.keyList = new String[]{this.id + "school_quran", this.id + "school_hadith", this.id + "school_islmaic_ideoloay", this.id + "school_prophet_life", this.id + "school_history", this.id + "school_life", this.id + "school_masyala", this.id + "school_newspaper"};
            this.totalNumber = new int[]{6, 6, 7, 12, 3, 17, 2, 6};
            this.type = "school";
            this.tvHeading.setText("স্কুল পাঠ্য");
        }
        if (getIntent().getStringExtra("from").equals("higher_syllabus_overview")) {
            this.viewList = new String[]{"আল-কুরআন", "আল-হাদীস", "ইসলামী দর্শন ", "ইসলামের সমাজ বিধান", "ইসলামী অর্থনীতি", "ইসলামের রাজনৈতিক অবস্থা", "ইসলামী শিক্ষা ব্যবস্থা", "তূলনামূলক অধ্যয়ন", "ইসলাম ও বিজ্ঞান", "বিশ্ব সাহিত্যঃ ইসলামী পরিপ্রেক্ষিত", "সমাজতন্ত্র", "বাংলাদেশের সমাজ ও সংস্কৃতি", "বাংলাদেশের সাহিত্য ও সাংস্কৃতিক আন্দোলন", "বাংলাদেশের রাজনীতি ও তার গতিধারা", "বাংলাদেশের  সামাজিক সমস্যা ও সমাধান", "বর্তমান দুনিয়ার ইসলামী আন্দোলন", "মুসলিম বিশ্ব", "আন্তর্জাতিক রাজনীতি", "আকায়েদ", "মাসয়ালা-মাসায়েল", "ফিকাহ ও ইসলামী আইন"};
            this.keyList = new String[]{"higher_quran", "higher_hadith", "higher_islmaic_philosophy", "higher_social_binding", "higher_economy", "higher_political_situation", "higher_educational_system", "higher_comparative_study", "higher_islam_science", "higher_world_literature", "higher_communism", "higher_society_culture", "higher_literature_culture", "higher_bangladesh_politics", "higher_social_problems", "higher_islamic_movement", "higher_muslim_world", "higher_international_politics", "higher_akayed", "higher_masyala_masayel", "higher_fikah"};
            this.totalNumber = new int[]{18, 9, 12, 21, 17, 13, 12, 27, 10, 6, 18, 13, 17, 22, 10, 13, 15, 9, 19, 10, 16};
            this.type = "higher";
            this.tvHeading.setText("উচ্চতর সিলেবাস");
        }
        this.lvPercentageReport.setAdapter(new AdapterForSyllabusInPercentageStatistics(this, this.viewList, this.keyList, this.totalNumber, this.type, this.id));
    }
}
