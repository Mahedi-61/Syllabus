package bd.org.shibir.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import bd.org.shibir.syllabus.R;

public class AdapterForActivityProfile extends BaseAdapter {
    private Context context;
    private String[] syllabusList;
    private Typeface tfs;

    public AdapterForActivityProfile(Context context, String[] syllabusList) {
        this.context = context;
        this.syllabusList = syllabusList;
        this.tfs = Typeface.createFromAsset(context.getAssets(), "fonts/Durga_03-09-2005.ttf");
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
           v = inflater.inflate(R.layout.li_activity_profile, null);
           // v = LayoutInflater.from(context).inflate(R.layout.li_activity_profile,parent,false);
        } else {
            v = convertView;
        }
        TextView tvHeading = (TextView) v.findViewById(R.id.tvItemHeading);
        tvHeading.setTypeface(this.tfs);
        tvHeading.setText(this.syllabusList[position]);
        return v;
    }
}
