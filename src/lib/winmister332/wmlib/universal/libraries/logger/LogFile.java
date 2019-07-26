package lib.winmister332.wmlib.universal.libraries.logger;

import java.io.*;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public final class LogFile
{
    private File file = null;

    public LogFile(File file) throws IOException
    {
        if (file.isFile() && !file.isDirectory())
        {
            if (!file.getName().endsWith(".log"))
                file = new File(file.getParentFile().getAbsolutePath(), file.getName() + ".log");
            //Create file + parent dir.
            if (!file.getParentFile().exists())
            {
                file.getParentFile().mkdirs();
                if (!file.exists())
                    file.createNewFile();
            }
            else
            {
                if (!file.exists())
                    file.createNewFile();
            }
            this.file = file;
        }
        else if (file.isDirectory() && !file.isFile())
        {
            DateFormat dateFormat = new SimpleDateFormat("[yyyy_MM_dd]-HH_mm_ss_tt");
            Timestamp timestamp = new Timestamp(dateFormat.getCalendar().getTimeInMillis());
            File logFile = new File(file, timestamp.toString().toUpperCase() + ".log");
            if (!file.exists())
            {
                file.mkdirs();
                if (!logFile.exists())
                    logFile.createNewFile();
            }
            else
            {
                if (!logFile.exists())
                    logFile.createNewFile();
            }

            this.file = logFile;
        }
    }

    public void write(String text) throws IOException
    {
        try (OutputStream stream = new FileOutputStream(file.getAbsolutePath()); Writer writer = new OutputStreamWriter(stream))
        {
            writer.write(text);
            writer.flush();
        }
    }

    public void append(String text) throws IOException
    {
        String writeText = read() + "\n" + text;
        write(writeText);
    }

    private String read() throws IOException
    {
        String s= "";
        try (InputStream in = new FileInputStream(file.getAbsolutePath()); Reader reader = new InputStreamReader(in))
        {
            int data = reader.read();
            while(data != -1)
            {
                if (s.isEmpty())
                {
                    Character c = (char)data;
                    s = c.toString();
                }
                else
                {
                    Character c = (char)data;
                    s = s + c.toString();
                }
            }
            return s;
        }
    }
}
