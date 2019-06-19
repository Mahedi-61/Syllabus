package bd.org.shibir.syllabus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import bd.org.shibir.adapter.AdapterForAssociateSubCategorySyllabus;
import bd.org.shibir.model.AllCompletedNoData;

public class AssociateSyllabusSubCategory extends Activity implements OnItemClickListener {
    private int id;
    private String[] keyList;
    private ListView lvAssociateSyllabusSubCategory;
    private int[] totalNumber;
    private TextView tvAssociateSyllabusSubCategory;
    private TextView tvTotalCompleted;
    private TextView tvTotalNo;
    private String[] viewList;

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.syllabus_overview);
        this.id = getIntent().getIntExtra("id", 0);
        this.tvAssociateSyllabusSubCategory = (TextView) findViewById(R.id.tvSyllabusOverview);
        this.tvTotalNo = (TextView) findViewById(R.id.tvTotalNoSO);
        this.tvTotalCompleted = (TextView) findViewById(R.id.tvTotalCompletedSO);
        this.lvAssociateSyllabusSubCategory = (ListView) findViewById(R.id.lvSyllabusOverview);
        if (getIntent().getStringExtra("from").equals("associate_overview_5")) {
            this.viewList = new String[]{"অর্থসহ সূরা মুখস্ত", "কুরআন হতে অধ্যয়ন (তাফসীর সহ)"};
            this.tvAssociateSyllabusSubCategory.setText("কুরআন অধ্যয়ন");
            this.keyList = new String[]{this.id + "associate_quran_sura", this.id + "associate_quran_tafsir"};
            this.totalNumber = new int[]{11, 16};
            this.tvAssociateSyllabusSubCategory.setText("কুরআন অধ্যয়ন");
            this.tvTotalNo.setText("27");
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getSumOfAssociateQuranStudy(this, this.id))).toString());
        }
        if (getIntent().getStringExtra("from").equals("associate_overview_7")) {
            this.viewList = new String[]{"আল-কুরআন", "আল-হাদীস", "সংগঠন ও দাওয়াত ", "ইসলামী আদর্শ", "ইবাদত সংক্রান্ত", "ইসলামী জীবন ব্যবস্থা", "ইসলামী আন্দোলন ", "মাসয়ালা-মাসায়েল", "বিবিধ"};
            this.keyList = new String[]{this.id + "associate_ls_quran", this.id + "associate_ls_hadith", this.id + "associate_ls_organization", this.id + "associate_ls_ideology", this.id + "associate_ls_ibadah", this.id + "associate_ls_life", this.id + "associate_ls_movement", this.id + "associate_ls_masyala", this.id + "associate_ls_miscellaneous"};
            this.totalNumber = new int[]{4, 2, 6, 5, 6, 7, 11, 1, 6};
            this.tvAssociateSyllabusSubCategory.setText("সাহিত্য অধ্যয়ন");
            this.tvTotalNo.setText("48");
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getSumOfAssociateLiteratureStudy(this, this.id))).toString());
        }
        this.lvAssociateSyllabusSubCategory.setAdapter(new AdapterForAssociateSubCategorySyllabus(this, this.viewList, this.keyList, this.totalNumber, this.id));
        this.lvAssociateSyllabusSubCategory.setOnItemClickListener(this);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int position, long ld) {
        if (getIntent().getStringExtra("from").equals("associate_overview_5")) {
            if (position == 0) {
                Intent i50 = new Intent(this, AssociateQuranSuraSyllabus.class);
                i50.putExtra("id", this.id);
                startActivity(i50);
            }
            if (position == 1) {
                Intent i51 = new Intent(this, AssociateSyllabusForBooks.class);
                i51.putExtra("id", this.id);
                i51.putExtra("from", "associate_overview_5");
                startActivity(i51);
            }
        }
        if (getIntent().getStringExtra("from").equals("associate_overview_7")) {
            Intent i = new Intent(this, AssociateLiteratureRelatedAllSyllabus.class);
            if (position == 0) {
                i.putExtra("from", "associate_literature_0");
            } else if (position == 1) {
                i.putExtra("from", "associate_literature_1");
            } else if (position == 2) {
                i.putExtra("from", "associate_literature_2");
            } else if (position == 3) {
                i.putExtra("from", "associate_literature_3");
            } else if (position == 4) {
                i.putExtra("from", "associate_literature_4");
            } else if (position == 5) {
                i.putExtra("from", "associate_literature_5");
            } else if (position == 6) {
                i.putExtra("from", "associate_literature_6");
            } else if (position == 7) {
                i.putExtra("from", "associate_literature_7");
            } else if (position == 8) {
                i.putExtra("from", "associate_literature_8");
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
