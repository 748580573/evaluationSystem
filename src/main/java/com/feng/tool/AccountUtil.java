package com.feng.tool;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountUtil {

    /**
     *
     * @param account
     * @return       获取第几学期
     */
    public static String getPeriod(String account){
        Pattern pattern = Pattern.compile("\\d{4}");
        Matcher matcher = pattern.matcher(account);
        matcher.find();
        Integer entrance = Integer.valueOf(matcher.group());            //入学时间
        LocalDate date = LocalDate.now();                               //获取当前
        int year = date.getYear();
        int mouth = date.getMonthValue();
        int period = (year - entrance) ;
        if (period <= 4){
            if (mouth > 9){
                return  String.valueOf(period * 2 + 1);
            }else {
                return  String.valueOf(period * 2);
            }
        }else {
            return String.valueOf(8);
        }

    }

    public static String getClazz(String account){
        String clazz = null;
        Pattern pattern = Pattern.compile("(\\d{4})(\\d{2})(\\d{3})(\\d{1})(\\d{2})");
        Matcher matcher = pattern.matcher("201510414418");
        while (matcher.find()){
            clazz = matcher.group(4);
        }
        return "0" + clazz;
    }
}
