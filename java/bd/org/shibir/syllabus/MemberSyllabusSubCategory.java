package bd.org.shibir.syllabus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import bd.org.shibir.adapter.AdapterForMemberSubCategorySyllabus;
import bd.org.shibir.model.AllCompletedNoData;

public class MemberSyllabusSubCategory extends Activity implements OnItemClickListener {
    private int id;
    private String[] keyList;
    private ListView lvMemberSyllabusSubCategory;
    private int[] totalNumber;
    private TextView tvMemberSyllabusSubCategory;
    private TextView tvTotalCompleted;
    private TextView tvTotalNo;
    private String[] viewList;

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.syllabus_overview);
        this.id = getIntent().getIntExtra("id", 0);
        this.tvMemberSyllabusSubCategory = (TextView) findViewById(R.id.tvSyllabusOverview);
        this.tvTotalNo = (TextView) findViewById(R.id.tvTotalNoSO);
        this.tvTotalCompleted = (TextView) findViewById(R.id.tvTotalCompletedSO);
        this.lvMemberSyllabusSubCategory = (ListView) findViewById(R.id.lvSyllabusOverview);
        if (getIntent().getStringExtra("from").equals("memeber_overview_5")) {
            this.viewList = new String[]{"কুরআন তেলাওয়াত(অর্থসহ)", "কুরআন হতে অধ্যয়ন (তাফসীর সহ)"};
            this.tvMemberSyllabusSubCategory.setText("কুরআন অধ্যয়ন");
            this.keyList = new String[]{this.id + "member_quran_sura", this.id + "member_quran_tafsir"};
            this.totalNumber = new int[]{114, 24};
            this.tvMemberSyllabusSubCategory.setText("কুরআন অধ্যয়ন");
            this.tvTotalNo.setText("138");
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getSumOfMemberQuranStudy(this, this.id))).toString());
        }
        if (getIntent().getStringExtra("from").equals("memeber_overview_7")) {
            this.viewList = new String[]{"আল-কুরআন", "আল-হাদীস", "মৌলিক তত্ত্ব", "ইসলামী আন্দোলন ", "সংগঠন ও দাওয়াত ", "ইসলামী জীবন ব্যাবস্থা", "ফিকাহ ও প্রাথমিক উসূলে ফিকাহ", "অন্যান্য মতবাদ"};
            this.keyList = new String[]{this.id + "member_ls_quran", this.id + "member_ls_hadith", this.id + "member_ls_principle", this.id + "member_ls_movement", this.id + "member_ls_organization", this.id + "member_ls_life", this.id + "member_ls_fikah", this.id + "member_ls_other"};
            this.totalNumber = new int[]{5, 4, 7, 30, 10, 22, 6, 5};
            this.tvMemberSyllabusSubCategory.setText("সাহিত্য অধ্যয়ন");
            this.tvTotalNo.setText("89");
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getSumOfMemberLiteratureStudy(this, this.id))).toString());
        }
        this.lvMemberSyllabusSubCategory.setAdapter(new AdapterForMemberSubCategorySyllabus(this, this.viewList, this.keyList, this.totalNumber, this.id));
        this.lvMemberSyllabusSubCategory.setOnItemClickListener(this);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int position, long ld) {
        if (getIntent().getStringExtra("from").equals("memeber_overview_5")) {
            if (position == 0) {
                Intent i50 = new Intent(this, MemberQuranSuraSyllabus.class);
                i50.putExtra("id", this.id);
                startActivity(i50);
            }
            if (position == 1) {
                Intent i51 = new Intent(this, MemberSyllabusForBooks.class);
                i51.putExtra("id", this.id);
                i51.putExtra("from", "member_qs_tafsir");
                startActivity(i51);
            }
        }
        if (getIntent().getStringExtra("from").equals("memeber_overview_7")) {
            Intent i = new Intent(this, MemberLiteratureRelatedAllSyllabus.class);
            if (position == 0) {
                i.putExtra("from", "member_literature_0");
            } else if (position == 1) {
                i.putExtra("from", "member_literature_1");
            } else if (position == 2) {
                i.putExtra("from", "member_literature_2");
            } else if (position == 3) {
                i.putExtra("from", "member_literature_3");
            } else if (position == 4) {
                i.putExtra("from", "member_literature_4");
            } else if (position == 5) {
                i.putExtra("from", "member_literature_5");
            } else if (position == 6) {
                i.putExtra("from", "member_literature_6");
            } else if (position == 7) {
                i.putExtra("from", "member_literature_7");
            }
            i.putExtra("id", this.id);
            startActivity(i);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onPause() {
        super.onPause();
        finish();
    }
}
