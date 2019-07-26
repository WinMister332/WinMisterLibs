package lib.winmister332.wmlib.utils;

import lib.winmister332.wmlib.universal.libraries.logger.LogStatus;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public final class GlobalUtils
{
    public static int getArraySafeInt(int rawInt, int maxInt)
    {
        if (rawInt > 1)
            return rawInt -1;
        if (rawInt <= 0)
            return 0;
        if (rawInt > maxInt)
        {
            rawInt = maxInt;
            return rawInt -1;
        }
        return 0;
    }

    public static int getArraySafeInt(int rawInt)
    {
        if (rawInt > 1)
            return rawInt -1;
        return 0;
    }

    public static <T> List<T> toList(T[] array)
    {
        List<T> tList = new ArrayList<>(array.length);
        for (T t : array)
        {
            tList.add(t);
        }
        return tList;
    }
}
