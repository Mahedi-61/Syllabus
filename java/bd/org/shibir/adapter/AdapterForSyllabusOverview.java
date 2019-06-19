package bd.org.shibir.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import bd.org.shibir.syllabus.R;
import bd.org.shibir.model.TextViewWithBanglaFont;

public class AdapterForSyllabusOverview extends BaseAdapter {
    private Context context;
    private String[] syllabusList;

    public AdapterForSyllabusOverview(Context context, String[] syllabusList) {
        this.context = context;
        this.syllabusList = syllabusList;
    }

    public int getCount() {
        return this.syllabusList.length;
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
            v = inflater.inflate(R.layout.li_syllabus_overview, null);
  //          v = LayoutInflater.from(context).inflate(R.layout.li_syllabus_overview,parent,false);
        } else {
            v = convertView;
        }
        ((TextView) v.findViewById(R.id.tvItemHeading)).setText(this.syllabusList[position]);
        return v;
    }
}
