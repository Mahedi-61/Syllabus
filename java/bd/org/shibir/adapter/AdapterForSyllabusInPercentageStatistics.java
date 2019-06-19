package bd.org.shibir.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import bd.org.shibir.syllabus.R;
import bd.org.shibir.model.AllCompletedNoData;

public class AdapterForSyllabusInPercentageStatistics extends BaseAdapter {
    private Context context;
    private int id;
    private String[] keyList;
    private int[] totalNumber;
    private String type;
    private String[] viewList;

    public AdapterForSyllabusInPercentageStatistics(Context context, String[] viewList, String[] keyList, int[] totalNumber, String type, int id) {
        this.context = context;
        this.viewList = viewList;
        this.keyList = keyList;
        this.totalNumber = totalNumber;
        this.id = id;
        this.type = type;
    }

    public String getPercentage(int nRequired, int nCompleted) {
        double dRequired = (double) nRequired;
        double dCompleted = (double) nCompleted;
        if (dCompleted == 0.0d) {
            return "0%";
        }
        if (dCompleted >= dRequired) {
            return "100%";
        }
        return new StringBuilder(String.valueOf(String.valueOf((100.0d * dCompleted) / dRequired).substring(0, 2))).append("%").toString();
    }

    public int getCount() {
        return this.viewList.length;
    }

    public Object getItem(int arg0) {
        return null;
    }

    public long getItemId(int arg0) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View v;
        int done;
        LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            v = new View(this.context);
            v = inflater.inflate(R.layout.list_item_percentage_report, null);
 //          v = LayoutInflater.from(context).inflate(R.layout.list_item_percentage_report,parent,false);
        } else {
            v = convertView;
        }
        ((TextView) v.findViewById(R.id.tvTaskName)).setText(this.viewList[position]);
        ((TextView) v.findViewById(R.id.tvTotalRequired)).setText(new StringBuilder(String.valueOf(this.totalNumber[position])).toString());
        if (this.type.equals("worker")) {
            done = AllCompletedNoData.getCompletdNumberForWorker(this.context, this.keyList[position], this.id);
            ((TextView) v.findViewById(R.id.tvTotalCompleted)).setText(new StringBuilder(String.valueOf(done)).toString());
            ((TextView) v.findViewById(R.id.tvPercentage)).setText(getPercentage(this.totalNumber[position], done));
        }
        if (this.type.equals("associate")) {
            done = AllCompletedNoData.getCompletdNumberForAssociate(this.context, this.keyList[position], this.id);
            ((TextView) v.findViewById(R.id.tvTotalCompleted)).setText(new StringBuilder(String.valueOf(done)).toString());
            ((TextView) v.findViewById(R.id.tvPercentage)).setText(getPercentage(this.totalNumber[position], done));
        }
        if (this.type.equals("member")) {
            done = AllCompletedNoData.getCompletdNumberForMember(this.context, this.keyList[position], this.id);
            ((TextView) v.findViewById(R.id.tvTotalCompleted)).setText(new StringBuilder(String.valueOf(done)).toString());
            ((TextView) v.findViewById(R.id.tvPercentage)).setText(getPercentage(this.totalNumber[position], done));
        }
        if (this.type.equals("school")) {
            done = AllCompletedNoData.getCompletdNumberForSchool(this.context, this.keyList[position], this.id);
            ((TextView) v.findViewById(R.id.tvTotalCompleted)).setText(new StringBuilder(String.valueOf(done)).toString());
            ((TextView) v.findViewById(R.id.tvPercentage)).setText(getPercentage(this.totalNumber[position], done));
        }
        if (this.type.equals("higher")) {
            done = AllCompletedNoData.getCompletdNumberForHigher(this.context, this.keyList[position]);
            ((TextView) v.findViewById(R.id.tvTotalCompleted)).setText(new StringBuilder(String.valueOf(done)).toString());
            ((TextView) v.findViewById(R.id.tvPercentage)).setText(getPercentage(this.totalNumber[position], done));
        }
        return v;
    }
}
