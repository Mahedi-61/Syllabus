package bd.org.shibir.syllabus;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import bd.org.shibir.adapter.AdapterForOnlyBooksInAssociate;
import bd.org.shibir.model.AllCompletedNoData;
import bd.org.shibir.model.AssociateSyllabus;

public class AssociateLiteratureRelatedAllSyllabus extends Activity implements OnItemClickListener {
    private SharedPreferences associate;
    private int id;
    private String keyName;
    private ListView lvAssociateStudySyllabus;
    private TextView tvAssociateStudySyllabus;
    private TextView tvTotalCompleted;
    private TextView tvTotalNo;

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.syllabus_overview);
        this.associate = getSharedPreferences("associate", 0);
        this.id = getIntent().getIntExtra("id", 0);
        this.tvAssociateStudySyllabus = (TextView) findViewById(R.id.tvSyllabusOverview);
        this.tvTotalNo = (TextView) findViewById(R.id.tvTotalNoSO);
        this.tvTotalCompleted = (TextView) findViewById(R.id.tvTotalCompletedSO);
        this.lvAssociateStudySyllabus = (ListView) findViewById(R.id.lvSyllabusOverview);
        if (getIntent().getStringExtra("from").equals("associate_literature_0")) {
            this.keyName = this.id + "associate_ls_quran";
            this.tvAssociateStudySyllabus.setText("আল-কুরআন");
            this.tvTotalNo.setText("4");
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberAssociateLiterature(this, this.keyName, this.id))).toString());
            this.lvAssociateStudySyllabus.setAdapter(new AdapterForOnlyBooksInAssociate(this, AssociateSyllabus.associateLSQuranBooks, AssociateSyllabus.associateLSQuranWriters, this.keyName, this.id));
        }
        if (getIntent().getStringExtra("from").equals("associate_literature_1")) {
            this.keyName = this.id + "associate_ls_hadith";
            this.tvAssociateStudySyllabus.setText("আল-হাদীস");
            this.tvTotalNo.setText("2");
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberAssociateLiterature(this, this.keyName, this.id))).toString());
            this.lvAssociateStudySyllabus.setAdapter(new AdapterForOnlyBooksInAssociate(this, AssociateSyllabus.associateLSHadithBooks, AssociateSyllabus.associateLSHadithWriters, this.keyName, this.id));
        }
        if (getIntent().getStringExtra("from").equals("associate_literature_2")) {
            this.keyName = this.id + "associate_ls_organization";
            this.tvAssociateStudySyllabus.setText("সংগঠন ও দাওয়াত ");
            this.tvTotalNo.setText("6");
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberAssociateLiterature(this, this.keyName, this.id))).toString());
            this.lvAssociateStudySyllabus.setAdapter(new AdapterForOnlyBooksInAssociate(this, AssociateSyllabus.associateLSOrganization, AssociateSyllabus.associateLSOrganizationWriters, this.keyName, this.id));
        }
        if (getIntent().getStringExtra("from").equals("associate_literature_3")) {
            this.keyName = this.id + "associate_ls_ideology";
            this.tvAssociateStudySyllabus.setText("ইসলামী আদর্শ");
            this.tvTotalNo.setText("5");
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberAssociateLiterature(this, this.keyName, this.id))).toString());
            this.lvAssociateStudySyllabus.setAdapter(new AdapterForOnlyBooksInAssociate(this, AssociateSyllabus.associateLSIslamicIdeology, AssociateSyllabus.associateLSIslamicIdeologyWriters, this.keyName, this.id));
        }
        if (getIntent().getStringExtra("from").equals("associate_literature_4")) {
            this.keyName = this.id + "associate_ls_ibadah";
            this.tvAssociateStudySyllabus.setText("ইবাদত সংক্রান্ত");
            this.tvTotalNo.setText("6");
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberAssociateLiterature(this, this.keyName, this.id))).toString());
            this.lvAssociateStudySyllabus.setAdapter(new AdapterForOnlyBooksInAssociate(this, AssociateSyllabus.associateLSIbadah, AssociateSyllabus.associateLSIbadahWriters, this.keyName, this.id));
        }
        if (getIntent().getStringExtra("from").equals("associate_literature_5")) {
            this.keyName = this.id + "associate_ls_life";
            this.tvAssociateStudySyllabus.setText("ইসলামী জীবন ব্যবস্থা");
            this.tvTotalNo.setText("7");
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberAssociateLiterature(this, this.keyName, this.id))).toString());
            this.lvAssociateStudySyllabus.setAdapter(new AdapterForOnlyBooksInAssociate(this, AssociateSyllabus.associateLSIslamicLifeStyle, AssociateSyllabus.associateLSIslamicLifeStyleWriters, this.keyName, this.id));
        }
        if (getIntent().getStringExtra("from").equals("associate_literature_6")) {
            this.keyName = this.id + "associate_ls_movement";
            this.tvAssociateStudySyllabus.setText("ইসলামী আন্দোলন");
            this.tvTotalNo.setText("11");
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberAssociateLiterature(this, this.keyName, this.id))).toString());
            this.lvAssociateStudySyllabus.setAdapter(new AdapterForOnlyBooksInAssociate(this, AssociateSyllabus.associateLSIslamicMovement, AssociateSyllabus.associateLSIslamicMovementWriters, this.keyName, this.id));
        }
        if (getIntent().getStringExtra("from").equals("associate_literature_7")) {
            this.keyName = this.id + "associate_ls_masyala";
            this.tvAssociateStudySyllabus.setText("মাসয়ালা-মাসায়েল");
            this.tvTotalNo.setText("1");
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberAssociateLiterature(this, this.keyName, this.id))).toString());
            this.lvAssociateStudySyllabus.setAdapter(new AdapterForOnlyBooksInAssociate(this, AssociateSyllabus.associateLSMasyalaMasayel, AssociateSyllabus.associateLSMasyalaMasayelWriters, this.keyName, this.id));
        }
        if (getIntent().getStringExtra("from").equals("associate_literature_8")) {
            this.keyName = this.id + "associate_ls_miscellaneous";
            this.tvAssociateStudySyllabus.setText("বিবিধ");
            this.tvTotalNo.setText("6");
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberAssociateLiterature(this, this.keyName, this.id))).toString());
            this.lvAssociateStudySyllabus.setAdapter(new AdapterForOnlyBooksInAssociate(this, AssociateSyllabus.associateLSMiscellianeous, AssociateSyllabus.associateLSMiscellaneousWriters, this.keyName, this.id));
        }
        this.lvAssociateStudySyllabus.setOnItemClickListener(this);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int position, long ld) {
        CheckBox cb = (CheckBox) view.findViewById(R.id.cbBookStatus);
        Editor edit = this.associate.edit();
        if (cb.isChecked()) {
            cb.setChecked(false);
            edit.putInt(this.keyName + position, 0);
        } else {
            cb.setChecked(true);
            edit.putInt(this.keyName + position, 1);
        }
        edit.commit();
        this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberAssociateLiterature(this, this.keyName, this.id))).toString());
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
        Intent i7 = new Intent(this, AssociateSyllabusSubCategory.class);
        i7.putExtra("id", this.id);
        i7.putExtra("from", "associate_overview_7");
        startActivity(i7);
    }
}
