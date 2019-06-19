package bd.org.shibir.adapter;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import bd.org.shibir.syllabus.ProfileChoosing;
import bd.org.shibir.syllabus.R;
import bd.org.shibir.model.AllSyllabus;
import java.util.ArrayList;

public class AdapterForProfileList extends BaseAdapter {
    private Context context;
    Typeface myTypeface;
    private SharedPreferences profile;
    private ArrayList<Integer> profileIdList;
    private ArrayList<String> profileNameList;
    private ArrayList<String> profileStatusList;

    public AdapterForProfileList(Context context, ArrayList<String> profileNameList, ArrayList<String> profileStatusList, ArrayList<Integer> profileIdList) {
        this.context = context;
        this.profileNameList = profileNameList;
        this.profileStatusList = profileStatusList;
        this.profileIdList = profileIdList;
        this.profile = context.getSharedPreferences("profile", 0);
    }

    public int getCount() {
        return this.profileNameList.size();
    }

    public Object getItem(int arg0) {
        return null;
    }

    public long getItemId(int arg0) {
        return 0;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        View v;
        LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.myTypeface = Typeface.createFromAsset(this.context.getAssets(), "fonts/Siyamrupali.ttf");
        if (convertView == null) {
            v = new View(this.context);
            v = inflater.inflate(R.layout.li_profile_choosing_list, null);
      //      v = LayoutInflater.from(context).inflate(R.layout.li_profile_choosing_list,parent,false);
        } else {
            v = convertView;
        }
        TextView tvTargetNamePC = (TextView) v.findViewById(R.id.tvTargetNamePC);
        tvTargetNamePC.setTypeface(this.myTypeface);
        tvTargetNamePC.setText((CharSequence) this.profileNameList.get(position));
        ((TextView) v.findViewById(R.id.tvTargetStatusPC)).setText(AllSyllabus.statusArray[Integer.valueOf((String) this.profileStatusList.get(position)).intValue()]);
        ((ImageView) v.findViewById(R.id.ivDeletePC)).setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Builder alert = new Builder(AdapterForProfileList.this.context);
                alert.setTitle("Remove From List");
                alert.setMessage("Are you really sure to remove this list ?");
                final int i = position;
                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        Editor edit = AdapterForProfileList.this.profile.edit();
                        edit.putInt("target_exist_" + AdapterForProfileList.this.profileIdList.get(i), 0);
                        edit.commit();
                        AdapterForProfileList.this.context.startActivity(new Intent(AdapterForProfileList.this.context.getApplicationContext(), ProfileChoosing.class));
                        ((Activity) AdapterForProfileList.this.context).finish();
                    }
                });
                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                    }
                });
                alert.show();
            }
        });
        return v;
    }
}
