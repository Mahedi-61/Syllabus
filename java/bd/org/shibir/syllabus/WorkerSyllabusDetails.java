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
import bd.org.shibir.adapter.AdapterForWorkerSyllabus;
import bd.org.shibir.model.AllCompletedNoData;
import bd.org.shibir.model.WorkerSyllabus;

public class WorkerSyllabusDetails extends Activity implements OnItemClickListener {
    private int id;
    private String keyName;
    private ListView lvWorkerStudySyllabus;
    private TextView tvTotalCompleted;
    private TextView tvTotalNo;
    private TextView tvWorkerStudySyllabus;
    private SharedPreferences worker;

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.syllabus_overview);
        this.worker = getSharedPreferences("worker", 0);
        this.id = getIntent().getIntExtra("id", 0);
        this.tvWorkerStudySyllabus = (TextView) findViewById(R.id.tvSyllabusOverview);
        this.tvTotalNo = (TextView) findViewById(R.id.tvTotalNoSO);
        this.tvTotalCompleted = (TextView) findViewById(R.id.tvTotalCompletedSO);
        this.lvWorkerStudySyllabus = (ListView) findViewById(R.id.lvSyllabusOverview);
        if (getIntent().getStringExtra("from").equals("worker_overview_0")) {
            this.keyName = this.id + "worker_quran";
            this.tvWorkerStudySyllabus.setText("আল-কুরআন");
            this.tvTotalNo.setText("13");
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberForWorker(this, this.keyName, this.id))).toString());
            this.lvWorkerStudySyllabus.setAdapter(new AdapterForWorkerSyllabus(this, WorkerSyllabus.workerQuran, WorkerSyllabus.workerQuranWriters, this.keyName, this.id));
        }
        if (getIntent().getStringExtra("from").equals("worker_overview_1")) {
            this.keyName = this.id + "worker_hadith";
            this.tvWorkerStudySyllabus.setText("আল-হাদীস");
            this.tvTotalNo.setText("1");
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberForWorker(this, this.keyName, this.id))).toString());
            this.lvWorkerStudySyllabus.setAdapter(new AdapterForWorkerSyllabus(this, WorkerSyllabus.workerHadith, WorkerSyllabus.workerHadithWriters, this.keyName, this.id));
        }
        if (getIntent().getStringExtra("from").equals("worker_overview_2")) {
            this.keyName = this.id + "worker_organization";
            this.tvWorkerStudySyllabus.setText("সংগঠন ও ইসলামী আন্দোলন");
            this.tvTotalNo.setText("2");
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberForWorker(this, this.keyName, this.id))).toString());
            this.lvWorkerStudySyllabus.setAdapter(new AdapterForWorkerSyllabus(this, WorkerSyllabus.workerOrganization, WorkerSyllabus.workerOrganizationWriters, this.keyName, this.id));
        }
        if (getIntent().getStringExtra("from").equals("worker_overview_3")) {
            this.keyName = this.id + "worker_islamic_ideology";
            this.tvWorkerStudySyllabus.setText("ইসলামী আদর্শ");
            this.tvTotalNo.setText("6");
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberForWorker(this, this.keyName, this.id))).toString());
            this.lvWorkerStudySyllabus.setAdapter(new AdapterForWorkerSyllabus(this, WorkerSyllabus.workerIslamicIdeology, WorkerSyllabus.workerIslamicIdeologyWriters, this.keyName, this.id));
        }
        if (getIntent().getStringExtra("from").equals("worker_overview_4")) {
            this.keyName = this.id + "worker_masyala";
            this.tvWorkerStudySyllabus.setText("মাসয়ালা-মাসায়েল");
            this.tvTotalNo.setText("1");
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberForWorker(this, this.keyName, this.id))).toString());
            this.lvWorkerStudySyllabus.setAdapter(new AdapterForWorkerSyllabus(this, WorkerSyllabus.workerMasyalaMasayel, WorkerSyllabus.workerMasyalaMasayelWriters, this.keyName, this.id));
        }
        if (getIntent().getStringExtra("from").equals("worker_overview_5")) {
            this.keyName = this.id + "worker_miscellaneous";
            this.tvWorkerStudySyllabus.setText("বিবিধ");
            this.tvTotalNo.setText("2");
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberForWorker(this, this.keyName, this.id))).toString());
            this.lvWorkerStudySyllabus.setAdapter(new AdapterForWorkerSyllabus(this, WorkerSyllabus.workerMiscellaneous, WorkerSyllabus.workerMiscellaneousWriters, this.keyName, this.id));
        }
        this.lvWorkerStudySyllabus.setOnItemClickListener(this);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int position, long ld) {
        CheckBox cb = (CheckBox) view.findViewById(R.id.cbBookStatus);
        Editor edit = this.worker.edit();
        if (cb.isChecked()) {
            cb.setChecked(false);
            edit.putInt(this.keyName + position, 0);
        } else {
            cb.setChecked(true);
            edit.putInt(this.keyName + position, 1);
        }
        edit.commit();
        this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberForWorker(this, this.keyName, this.id))).toString());
    }
}
