package bd.org.shibir.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import bd.org.shibir.syllabus.R;
import bd.org.shibir.model.AllCompletedNoData;

public class AdapterForAssociateSubCategorySyllabus extends BaseAdapter {
    private Context context;
    private int id;
    private String[] keyList;
    private int[] totalNumber;
    private String[] viewList;

    public AdapterForAssociateSubCategorySyllabus(Context context, String[] viewList, String[] keyList, int[] totalNumber, int id) {
        this.context = context;
        this.viewList = viewList;
        this.keyList = keyList;
        this.totalNumber = totalNumber;
        this.id = id;
    }

    public int getCount() {
        return this.viewList.length;
    }

    public Object getItem(int arg0) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View v;
        LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            v = new View(this.context);
            v = inflater.inflate(R.layout.li_syllabus_sub_category, null);
            //v = LayoutInflater.from(context).inflate(R.layout.li_syllabus_sub_category,parent,false);
        } else {
            v = convertView;
        }
        ((TextView) v.findViewById(R.id.tvItemHeadingSubCategory)).setText(this.viewList[position]);
        ((TextView) v.findViewById(R.id.tvItemNoSubCategory)).setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberAssociateLiterature(this.context, this.keyList[position], this.id))).append("/").append(this.totalNumber[position]).toString());
        return v;
    }
}
