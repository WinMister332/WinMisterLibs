package lib.winmister332.wmlib.bungee.libraries.commands;

import lib.winmister332.wmlib.utils.GlobalUtils;

import java.util.ArrayList;
import java.util.List;

public final class CommandArguments
{
    private List<String> args = null;

    public CommandArguments(String[] args)
    {
        this.args = new ArrayList<>(args.length);
        for (String s : args)
            this.args.add(s);
    }

    public CommandArguments(List<String> args)
    {
        if (!(args == null && args.size() <= 0))
            this.args = args;
    }

    public boolean isEmpty() { return args.isEmpty(); }
    public int count() { return args.size(); }

    public String getArgumentAtPosition(int position)
    {
        return (String) args.toArray()[position];
    }

    public boolean contains(String arg)
    {
        return args.contains(arg);
    }

    public int indexOf(String arg)
    {
        return args.indexOf(arg);
    }

    public boolean startsWith(String arg)
    {
        return ((String) args.toArray()[0]).equalsIgnoreCase(arg);
    }

    public boolean startsWithExact(String arg)
    {
        return args.toArray()[0].equals(arg);
    }

    public boolean endsWith(String arg)
    {
        return ((String) args.toArray()[GlobalUtils.getArraySafeInt(args.size())]).equalsIgnoreCase(arg);
    }

    public boolean endsWithExact(String arg)
    {
        return args.toArray()[GlobalUtils.getArraySafeInt(args.size())].equals(arg);
    }

    public String previousArgOf(String arg)
    {
        int rawIndex = indexOf(arg);
        rawIndex = rawIndex -1;
        if (!(rawIndex < 0))
            return getArgumentAtPosition(rawIndex);
        else
            return "";
    }

    public String nextArgOf(String arg)
    {
        int rawIndex = indexOf(arg);
        rawIndex = rawIndex +1;
        if (!(rawIndex >= args.size()))
            return getArgumentAtPosition(rawIndex);
        else
            return "";
    }

    @Override
    public String toString()
    {
        String s = "";
        for (String sx : args)
        {
            if (s.isEmpty())
                s = sx;
            else
                s += " " + sx;
        }
        return s;
    }
}
