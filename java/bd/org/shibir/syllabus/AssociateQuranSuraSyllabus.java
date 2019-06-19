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
import bd.org.shibir.adapter.AdapterForQuranSuraSyllabus;
import bd.org.shibir.model.AllCompletedNoData;
import bd.org.shibir.model.AssociateSyllabus;

public class AssociateQuranSuraSyllabus extends Activity implements OnItemClickListener {
    private SharedPreferences associate;
    private int id;
    private String keyName;
    private ListView lvAssociateQuranSuraSyllabus;
    private TextView tvAssoicateQuanSuraSyllabus;
    private TextView tvTotalCompleted;
    private TextView tvTotalNo;

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.syllabus_overview);
        this.id = getIntent().getIntExtra("id", 0);
        this.keyName = this.id + "associate_quran_sura";
        this.associate = getSharedPreferences("associate", 0);
        this.tvAssoicateQuanSuraSyllabus = (TextView) findViewById(R.id.tvSyllabusOverview);
        this.tvTotalNo = (TextView) findViewById(R.id.tvTotalNoSO);
        this.tvTotalCompleted = (TextView) findViewById(R.id.tvTotalCompletedSO);
        this.lvAssociateQuranSuraSyllabus = (ListView) findViewById(R.id.lvSyllabusOverview);
        this.tvAssoicateQuanSuraSyllabus.setText("অর্থসহ সূরা মুখস্ত");
        this.tvTotalNo.setText("11");
        this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberForAssociate(this, this.keyName, this.id))).toString());
        this.lvAssociateQuranSuraSyllabus.setAdapter(new AdapterForQuranSuraSyllabus(this, AssociateSyllabus.associateQuranSuraMemorizationList, this.keyName, this.id));
        this.lvAssociateQuranSuraSyllabus.setOnItemClickListener(this);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int position, long ld) {
        CheckBox cb = (CheckBox) view.findViewById(R.id.cbSuraSyllabus);
        Editor edit = this.associate.edit();
        if (cb.isChecked()) {
            cb.setChecked(false);
            edit.putInt(this.keyName + position, 0);
        } else {
            cb.setChecked(true);
            edit.putInt(this.keyName + position, 1);
        }
        edit.commit();
        this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberForAssociate(this, this.keyName, this.id))).toString());
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
        Intent i7 = new Intent(this, AssociateSyllabusSubCategory.class);
        i7.putExtra("id", this.id);
        i7.putExtra("from", "associate_overview_5");
        startActivity(i7);
    }
}
