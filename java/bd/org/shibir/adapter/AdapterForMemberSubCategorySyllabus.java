package bd.org.shibir.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import bd.org.shibir.syllabus.R;

public class AdapterForMemberSubCategorySyllabus extends BaseAdapter {
    private Context context;
    private int id;
    private String[] keyList;
    private SharedPreferences member;
    private int[] totalNumber;
    private String[] viewList;

    public AdapterForMemberSubCategorySyllabus(Context context, String[] viewList, String[] keyList, int[] totalNumber, int id) {
        this.context = context;
        this.viewList = viewList;
        this.keyList = keyList;
        this.member = context.getSharedPreferences("member", 0);
        this.id = id;
        this.totalNumber = totalNumber;
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
           // v = LayoutInflater.from(context).inflate(R.layout.li_syllabus_sub_category,parent,false);
        } else {
            v = convertView;
        }
        ((TextView) v.findViewById(R.id.tvItemHeadingSubCategory)).setText(this.viewList[position]);
        ((TextView) v.findViewById(R.id.tvItemNoSubCategory)).setText(getCompletdNumber(this.keyList[position]) + "/" + this.totalNumber[position]);
        return v;
    }

    public int getCompletdNumber(String keyName) {
        int position;
        int completedNumber = 0;
        int extra1 = 0;
        int extra2 = 0;
        int extra3 = 0;
        if (keyName.equals(this.id + "member_ls_quran")) {
            position = 0;
            while (position < 8) {
                if (position == 1 || position == 2) {
                    if (this.member.getInt(new StringBuilder(String.valueOf(keyName)).append(position).toString(), 3) == 1) {
                        extra1 = 1;
                    }
                } else if (position == 3 || position == 4) {
                    if (this.member.getInt(new StringBuilder(String.valueOf(keyName)).append(position).toString(), 3) == 1) {
                        extra2 = 1;
                    }
                } else if (position == 5 || position == 6) {
                    if (this.member.getInt(new StringBuilder(String.valueOf(keyName)).append(position).toString(), 3) == 1) {
                        extra3 = 1;
                    }
                } else if (this.member.getInt(new StringBuilder(String.valueOf(keyName)).append(position).toString(), 3) == 1) {
                    completedNumber++;
                }
                position++;
            }
            completedNumber += (extra1 + extra2) + extra3;
        }
        if (keyName.equals(this.id + "member_ls_hadith") || keyName.equals(this.id + "member_ls_principle") || keyName.equals(this.id + "member_ls_organization") || keyName.equals(this.id + "member_ls_other") || keyName.equals(this.id + "member_quran_sura") || keyName.equals(this.id + "member_quran_tafsir")) {
            for (position = 0; position <= 115; position++) {
                if (this.member.getInt(new StringBuilder(String.valueOf(keyName)).append(position).toString(), 3) == 1) {
                    completedNumber++;
                }
            }
        }
        if (keyName.equals(this.id + "member_ls_movement")) {
            position = 0;
            while (position < 34) {
                if (position == 3 || position == 4) {
                    if (this.member.getInt(new StringBuilder(String.valueOf(keyName)).append(position).toString(), 3) == 1) {
                        extra1 = 1;
                    }
                } else if (position == 7 || position == 8 || position == 9 || position == 10) {
                    if (this.member.getInt(new StringBuilder(String.valueOf(keyName)).append(position).toString(), 3) == 1) {
                        extra2 = 1;
                    }
                } else if (this.member.getInt(new StringBuilder(String.valueOf(keyName)).append(position).toString(), 3) == 1) {
                    completedNumber++;
                }
                position++;
            }
            completedNumber += (extra1 + extra2) + extra3;
        }
        if (keyName.equals(this.id + "member_ls_life")) {
            position = 0;
            while (position < 24) {
                if (position == 3 || position == 4) {
                    if (this.member.getInt(new StringBuilder(String.valueOf(keyName)).append(position).toString(), 3) == 1) {
                        extra1 = 1;
                    }
                } else if (position == 8 || position == 9) {
                    if (this.member.getInt(new StringBuilder(String.valueOf(keyName)).append(position).toString(), 3) == 1) {
                        extra2 = 1;
                    }
                } else if (this.member.getInt(new StringBuilder(String.valueOf(keyName)).append(position).toString(), 3) == 1) {
                    completedNumber++;
                }
                position++;
            }
            completedNumber += (extra1 + extra2) + extra3;
        }
        if (!keyName.equals(this.id + "member_ls_fikah")) {
            return completedNumber;
        }
        position = 0;
        while (position < 8) {
            if (position == 0 || position == 1) {
                if (this.member.getInt(new StringBuilder(String.valueOf(keyName)).append(position).toString(), 3) == 1) {
                    extra1 = 1;
                }
            } else if (position == 3 || position == 4) {
                if (this.member.getInt(new StringBuilder(String.valueOf(keyName)).append(position).toString(), 3) == 1) {
                    extra2 = 1;
                }
            } else if (this.member.getInt(new StringBuilder(String.valueOf(keyName)).append(position).toString(), 3) == 1) {
                completedNumber++;
            }
            position++;
        }
        return completedNumber + ((extra1 + extra2) + extra3);
    }
}
