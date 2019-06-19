package bd.org.shibir.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;

public class AllCompletedNoData {
    public static int getCompletdNumberForWorker(Context context, String keyName, int id) {
        SharedPreferences worker = context.getSharedPreferences("worker", 0);
        int completedNumber = 0;
        int position;
        if (keyName.equals(new StringBuilder(String.valueOf(id)).append("worker_masyala").toString())) {
            position = 0;
            while (position <= 1) {
                if ((position == 0 || position == 1) && worker.getInt(new StringBuilder(String.valueOf(keyName)).append(position).toString(), 3) == 1) {
                    completedNumber = 1;
                }
                position++;
            }
        } else {
            for (position = 0; position <= 15; position++) {
                if (worker.getInt(new StringBuilder(String.valueOf(keyName)).append(position).toString(), 3) == 1) {
                    completedNumber++;
                }
            }
        }
        return completedNumber;
    }

    public static int getCompletdNumberForAssociate(Context context, String keyName, int id) {
        int position;
        SharedPreferences associate = context.getSharedPreferences("associate", 0);
        int completedNumber = 0;
        if (keyName.equals(new StringBuilder(String.valueOf(id)).append("associate_darsul_quran").toString()) || keyName.equals(new StringBuilder(String.valueOf(id)).append("associate_darsul_hadith").toString()) || keyName.equals(new StringBuilder(String.valueOf(id)).append("associate_alocona_note").toString()) || keyName.equals(new StringBuilder(String.valueOf(id)).append("associate_book_note").toString()) || keyName.equals(new StringBuilder(String.valueOf(id)).append("associate_quran_sura").toString()) || keyName.equals(new StringBuilder(String.valueOf(id)).append("associate_quran_tafsir").toString()) || keyName.equals(new StringBuilder(String.valueOf(id)).append("associate_hadith_study").toString())) {
            for (position = 0; position <= 30; position++) {
                if (associate.getInt(new StringBuilder(String.valueOf(keyName)).append(position).toString(), 3) == 1) {
                    completedNumber++;
                }
            }
        }
        if (keyName.equals(new StringBuilder(String.valueOf(id)).append("associate_ayat_memorization").toString()) || keyName.equals(new StringBuilder(String.valueOf(id)).append("associate_hadith_memorization").toString())) {
            for (position = 0; position <= 60; position++) {
                if (!associate.getString(new StringBuilder(String.valueOf(keyName)).append(position).toString(), "0").equals("")) {
                    completedNumber += Integer.parseInt(associate.getString(new StringBuilder(String.valueOf(keyName)).append(position).toString(), "0"));
                }
            }
        }
        if (keyName.equals(new StringBuilder(String.valueOf(id)).append("associate_literature_study").toString())) {
            return associate.getInt(keyName, 3);
        }
        return completedNumber;
    }

    public static int getSumOfAssociateLiteratureStudy(Context context, int id) {
        SharedPreferences associate = context.getSharedPreferences("associate", 0);
        associate = context.getSharedPreferences("associate", 0);
        int sum = 0;
        for (String completdNumberAssociateLiterature : new String[]{new StringBuilder(String.valueOf(id)).append("associate_ls_quran").toString(), new StringBuilder(String.valueOf(id)).append("associate_ls_hadith").toString(), new StringBuilder(String.valueOf(id)).append("associate_ls_organization").toString(), new StringBuilder(String.valueOf(id)).append("associate_ls_ideology").toString(), new StringBuilder(String.valueOf(id)).append("associate_ls_ibadah").toString(), new StringBuilder(String.valueOf(id)).append("associate_ls_life").toString(), new StringBuilder(String.valueOf(id)).append("associate_ls_movement").toString(), new StringBuilder(String.valueOf(id)).append("associate_ls_masyala").toString(), new StringBuilder(String.valueOf(id)).append("associate_ls_miscellaneous").toString()}) {
            sum += getCompletdNumberAssociateLiterature(context, completdNumberAssociateLiterature, id);
        }
        Log.e("allah me", new StringBuilder(String.valueOf(sum)).toString());
        Editor edit = associate.edit();
        edit.putInt(new StringBuilder(String.valueOf(id)).append("associate_literature_study").toString(), sum);
        edit.commit();
        return sum;
    }

    public static int getSumOfAssociateQuranStudy(Context context, int id) {
        int sum = 0;
        for (String completdNumberForAssociate : new String[]{new StringBuilder(String.valueOf(id)).append("associate_quran_sura").toString(), new StringBuilder(String.valueOf(id)).append("associate_quran_tafsir").toString()}) {
            sum += getCompletdNumberForAssociate(context, completdNumberForAssociate, id);
        }
        return sum;
    }

    public static int getCompletdNumberAssociateLiterature(Context context, String keyName, int id) {
        int position;
        SharedPreferences associate = context.getSharedPreferences("associate", 0);
        int completedNumber = 0;
        int extra1 = 0;
        if (keyName.equals(new StringBuilder(String.valueOf(id)).append("associate_ls_quran").toString())) {
            position = 0;
            while (position < 5) {
                if (position == 2 || position == 3) {
                    if (associate.getInt(new StringBuilder(String.valueOf(keyName)).append(position).toString(), 3) == 1) {
                        extra1 = 1;
                    }
                } else if (associate.getInt(new StringBuilder(String.valueOf(keyName)).append(position).toString(), 3) == 1) {
                    completedNumber++;
                }
                position++;
            }
            completedNumber += (extra1 + 0) + 0;
        }
        if (keyName.equals(new StringBuilder(String.valueOf(id)).append("associate_ls_hadith").toString()) || keyName.equals(new StringBuilder(String.valueOf(id)).append("associate_ls_organization").toString()) || keyName.equals(new StringBuilder(String.valueOf(id)).append("associate_ls_ideology").toString()) || keyName.equals(new StringBuilder(String.valueOf(id)).append("associate_ls_ibadah").toString()) || keyName.equals(new StringBuilder(String.valueOf(id)).append("associate_ls_life").toString()) || keyName.equals(new StringBuilder(String.valueOf(id)).append("associate_ls_movement").toString()) || keyName.equals(new StringBuilder(String.valueOf(id)).append("associate_ls_miscellaneous").toString())) {
            for (position = 0; position <= 50; position++) {
                if (associate.getInt(new StringBuilder(String.valueOf(keyName)).append(position).toString(), 3) == 1) {
                    completedNumber++;
                }
            }
        }
        if (keyName.equals(new StringBuilder(String.valueOf(id)).append("associate_ls_masyala").toString())) {
            position = 0;
            while (position < 2) {
                if ((position == 0 || position == 1) && associate.getInt(new StringBuilder(String.valueOf(keyName)).append(position).toString(), 3) == 1) {
                    extra1 = 1;
                }
                position++;
            }
            completedNumber += (extra1 + 0) + 0;
        }
        if (keyName.equals(new StringBuilder(String.valueOf(id)).append("associate_quran_sura").toString()) || keyName.equals(new StringBuilder(String.valueOf(id)).append("associate_quran_tafsir").toString())) {
            for (position = 0; position <= 50; position++) {
                if (associate.getInt(new StringBuilder(String.valueOf(keyName)).append(position).toString(), 3) == 1) {
                    completedNumber++;
                }
            }
        }
        return completedNumber;
    }

    public static int getCompletdNumberForMember(Context context, String keyName, int id) {
        int position;
        SharedPreferences member = context.getSharedPreferences("member", 0);
        int completedNumber = 0;
        if (keyName.equals(new StringBuilder(String.valueOf(id)).append("member_darsul_quran").toString()) || keyName.equals(new StringBuilder(String.valueOf(id)).append("member_darsul_hadith").toString()) || keyName.equals(new StringBuilder(String.valueOf(id)).append("member_alocona_note").toString()) || keyName.equals(new StringBuilder(String.valueOf(id)).append("member_book_note").toString()) || keyName.equals(new StringBuilder(String.valueOf(id)).append("member_quran_sura").toString()) || keyName.equals(new StringBuilder(String.valueOf(id)).append("member_quran_tafsir").toString()) || keyName.equals(new StringBuilder(String.valueOf(id)).append("member_hadith_study").toString())) {
            for (position = 0; position <= 115; position++) {
                if (member.getInt(new StringBuilder(String.valueOf(keyName)).append(position).toString(), 3) == 1) {
                    completedNumber++;
                }
            }
        }
        if (keyName.equals(new StringBuilder(String.valueOf(id)).append("member_ayat_memorization").toString()) || keyName.equals(new StringBuilder(String.valueOf(id)).append("member_hadith_memorization").toString())) {
            for (position = 0; position <= 60; position++) {
                if (!member.getString(new StringBuilder(String.valueOf(keyName)).append(position).toString(), "0").equals("")) {
                    completedNumber += Integer.parseInt(member.getString(new StringBuilder(String.valueOf(keyName)).append(position).toString(), "0"));
                }
            }
        }
        if (keyName.equals(new StringBuilder(String.valueOf(id)).append("member_literature_study").toString())) {
            return member.getInt(keyName, 3);
        }
        return completedNumber;
    }

    public static int getSumOfMemberLiteratureStudy(Context context, int id) {
        SharedPreferences member = context.getSharedPreferences("member", 0);
        int sum = 0;
        String[] meKeyList = new String[]{new StringBuilder(String.valueOf(id)).append("member_ls_quran").toString(), new StringBuilder(String.valueOf(id)).append("member_ls_hadith").toString(), new StringBuilder(String.valueOf(id)).append("member_ls_principle").toString(), new StringBuilder(String.valueOf(id)).append("member_ls_movement").toString(), new StringBuilder(String.valueOf(id)).append("member_ls_organization").toString(), new StringBuilder(String.valueOf(id)).append("member_ls_life").toString(), new StringBuilder(String.valueOf(id)).append("member_ls_fikah").toString(), new StringBuilder(String.valueOf(id)).append("member_ls_other").toString()};
        for (int i = 0; i < meKeyList.length; i++) {
            Log.e("Allah helps me", meKeyList[i]);
            sum += getCompletedNumberForMemberLiterature(context, meKeyList[i], id);
        }
        Log.e("allah me", new StringBuilder(String.valueOf(sum)).toString());
        Editor edit = member.edit();
        edit.putInt(new StringBuilder(String.valueOf(id)).append("member_literature_study").toString(), sum);
        edit.commit();
        return sum;
    }

    public static int getSumOfMemberQuranStudy(Context context, int id) {
        int sum = 0;
        for (String completdNumberForMember : new String[]{new StringBuilder(String.valueOf(id)).append("member_quran_sura").toString(), new StringBuilder(String.valueOf(id)).append("member_quran_tafsir").toString()}) {
            sum += getCompletdNumberForMember(context, completdNumberForMember, id);
        }
        return sum;
    }

    public static int getCompletedNumberForMemberLiterature(Context context, String keyName, int id) {
        int position;
        SharedPreferences member = context.getSharedPreferences("member", 0);
        int completedNumber = 0;
        int extra1 = 0;
        int extra2 = 0;
        int extra3 = 0;
        if (keyName.equals(new StringBuilder(String.valueOf(id)).append("member_ls_quran").toString())) {
            position = 0;
            while (position < 8) {
                if (position == 1 || position == 2) {
                    if (member.getInt(new StringBuilder(String.valueOf(keyName)).append(position).toString(), 3) == 1) {
                        extra1 = 1;
                    }
                } else if (position == 3 || position == 4) {
                    if (member.getInt(new StringBuilder(String.valueOf(keyName)).append(position).toString(), 3) == 1) {
                        extra2 = 1;
                    }
                } else if (position == 5 || position == 6) {
                    if (member.getInt(new StringBuilder(String.valueOf(keyName)).append(position).toString(), 3) == 1) {
                        extra3 = 1;
                    }
                } else if (member.getInt(new StringBuilder(String.valueOf(keyName)).append(position).toString(), 3) == 1) {
                    completedNumber++;
                }
                position++;
            }
            completedNumber += (extra1 + extra2) + extra3;
        }
        if (keyName.equals(new StringBuilder(String.valueOf(id)).append("member_ls_hadith").toString()) || keyName.equals(new StringBuilder(String.valueOf(id)).append("member_ls_principle").toString()) || keyName.equals(new StringBuilder(String.valueOf(id)).append("member_ls_organization").toString()) || keyName.equals(new StringBuilder(String.valueOf(id)).append("member_ls_other").toString())) {
            for (position = 0; position <= 115; position++) {
                if (member.getInt(new StringBuilder(String.valueOf(keyName)).append(position).toString(), 3) == 1) {
                    completedNumber++;
                }
            }
        }
        if (keyName.equals(new StringBuilder(String.valueOf(id)).append("member_ls_movement").toString())) {
            position = 0;
            while (position < 34) {
                if (position == 3 || position == 4) {
                    if (member.getInt(new StringBuilder(String.valueOf(keyName)).append(position).toString(), 3) == 1) {
                        extra1 = 1;
                    }
                } else if (position == 7 || position == 8 || position == 9 || position == 10) {
                    if (member.getInt(new StringBuilder(String.valueOf(keyName)).append(position).toString(), 3) == 1) {
                        extra2 = 1;
                    }
                } else if (member.getInt(new StringBuilder(String.valueOf(keyName)).append(position).toString(), 3) == 1) {
                    completedNumber++;
                }
                position++;
            }
            completedNumber += (extra1 + extra2) + extra3;
        }
        if (keyName.equals(new StringBuilder(String.valueOf(id)).append("member_ls_life").toString())) {
            position = 0;
            while (position < 24) {
                if (position == 3 || position == 4) {
                    if (member.getInt(new StringBuilder(String.valueOf(keyName)).append(position).toString(), 3) == 1) {
                        extra1 = 1;
                    }
                } else if (position == 8 || position == 9) {
                    if (member.getInt(new StringBuilder(String.valueOf(keyName)).append(position).toString(), 3) == 1) {
                        extra2 = 1;
                    }
                } else if (member.getInt(new StringBuilder(String.valueOf(keyName)).append(position).toString(), 3) == 1) {
                    completedNumber++;
                }
                position++;
            }
            completedNumber += (extra1 + extra2) + extra3;
        }
        if (!keyName.equals(new StringBuilder(String.valueOf(id)).append("member_ls_fikah").toString())) {
            return completedNumber;
        }
        position = 0;
        while (position < 8) {
            if (position == 0 || position == 1) {
                if (member.getInt(new StringBuilder(String.valueOf(keyName)).append(position).toString(), 3) == 1) {
                    extra1 = 1;
                }
            } else if (position == 3 || position == 4) {
                if (member.getInt(new StringBuilder(String.valueOf(keyName)).append(position).toString(), 3) == 1) {
                    extra2 = 1;
                }
            } else if (member.getInt(new StringBuilder(String.valueOf(keyName)).append(position).toString(), 3) == 1) {
                completedNumber++;
            }
            position++;
        }
        return completedNumber + ((extra1 + extra2) + extra3);
    }

    public static int getCompletdNumberForSchool(Context context, String keyName, int id) {
        SharedPreferences school = context.getSharedPreferences("school", 0);
        int completedNumber = 0;
        for (int position = 0; position <= 20; position++) {
            if (school.getInt(new StringBuilder(String.valueOf(keyName)).append(position).toString(), 3) == 1) {
                completedNumber++;
            }
        }
        return completedNumber;
    }

    public static int getCompletdNumberForHigher(Context context, String keyName) {
        SharedPreferences higher = context.getSharedPreferences("higher", 0);
        int completedNumber = 0;
        for (int position = 0; position <= 30; position++) {
            if (higher.getInt(new StringBuilder(String.valueOf(keyName)).append(position).toString(), 3) == 1) {
                completedNumber++;
            }
        }
        return completedNumber;
    }
}
