package com.afshin;

import com.ibm.icu.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Tagfunction {

    public static Integer multiple(Integer a,Integer b)
    {
        return a*b;
    }
    public static String convert2persian(Date miladyDate)
    {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy/MM/dd",new Locale("fa","IR"));
        return simpleDateFormat.format(miladyDate);
    }

}
