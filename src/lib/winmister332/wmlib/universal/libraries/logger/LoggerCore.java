package lib.winmister332.wmlib.universal.libraries.logger;

import java.io.*;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

final class LoggerCore
{
    public static void log()
    {
        log(" ");
    }

    public static void log(String message)
    {
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        System.out.println(message);
    }

    public static void log(String sender, boolean debug, int status, String message, String logFilePath) throws IOException
    {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Timestamp timestamp = new Timestamp(dateFormat.getCalendar().getTimeInMillis());
        LogFile LF = null;
        if (!(logFilePath == null))
            LF = new LogFile(new File(logFilePath));
        if (!(status == -5))
            if (status == -4 && debug)
            {
                String output = "[" + timestamp.toString().toUpperCase() + "][" + sender.toUpperCase() + "][DEBUG][SEVERE] " + message;
                log(output);
                if (!(LF == null))
                    LF.append(output);
            }
            else if (status == -3 && debug)
            {
                String output = "[" + timestamp.toString().toUpperCase() + "][" + sender.toUpperCase() + "][DEBUG][ERROR] " + message;
                log(output);
                if (!(LF == null))
                    LF.append(output);
            }
            else if (status == -2 && debug)
            {
                String output = "[" + timestamp.toString().toUpperCase() + "][" + sender.toUpperCase() + "][DEBUG][WARNING] " + message;
                log(output);
                if (!(LF == null))
                    LF.append(output);
            }
            else if (status == -1 && debug)
            {
                String output = "[" + timestamp.toString().toUpperCase() + "][" + sender.toUpperCase() + "][DEBUG][INFO] " + message;
                log(output);
                if (!(LF == null))
                    LF.append(output);
            }
            else if (status == 0)
            {
                String output = "[" + timestamp.toString().toUpperCase() + "][" + sender.toUpperCase() + "][INFO] " + message;
                log(output);
                if (!(LF == null))
                    LF.append(output);
            }
            else if (status == 1)
            {
                String output = "[" + timestamp.toString().toUpperCase() + "][" + sender.toUpperCase() + "][WARNING] " + message;
                log(output);
                if (!(LF == null))
                    LF.append(output);
            }
            else if (status == 2)
            {
                String output = "[" + timestamp.toString().toUpperCase() + "][" + sender.toUpperCase() + "][ERROR] " + message;
                log(output);
                if (!(LF == null))
                    LF.append(output);
            }
            else
            {
                String output = "[" + timestamp.toString().toUpperCase() + "][" + sender.toUpperCase() + "][SEVERE] " + message;
                log(output);
                if (!(LF == null))
                    LF.append(output);
            }
    }

    public static void log(String sender, boolean debug, int status, String message, String logFilePath, List<String> output) throws IOException
    {
        String s = "";
        for (String sx : output) {
            if (s.isEmpty())
                s = "    - " + sx;
            else
                s = s + "    - " + sx;
        }
        log(sender, debug, status, (message + "\n" + s), logFilePath);
    }

    LoggerCore() {}

    void logOut(String out)
    {
        log(out, 0, null);
    }

    void logWarning(String out)
    {
        log(out, 1,null);
    }

    void logError(String out, Throwable t)
    {
        log(out, 2, t);
    }

    private void log(String out, int status, Throwable t)
    {
        try
        {
            if (!(t == null && status == 2))
                log("LOGGER", false, 2, (out + ": -> " + t.toString()), null);
            else
                log("LOGGER", false, status, out, null);
        }
        catch (Exception ex) {return;}
    }

    static LoggerCore getInstance() { return new LoggerCore(); }
}
