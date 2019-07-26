package lib.winmister332.wmlib.bungee.libraries.mysql;

import me.vagdedes.mysql.database.SQL;

import java.util.Collections;
import java.util.List;

public final class Table
{
    private String tableName = "";

    public Table(String name)
    {
        tableName = name;
    }

    public void insertData(Column[] columns)
    {
        String names = "";
        String values = "";
        for (Column c : columns)
        {
            String name = c.getColumnName();
            String value = c.getColumnValue();
            if (names.isEmpty())
                names = name;
            else
                names = names + ", " + name;

            if (values.isEmpty())
                values = value;
            else
                values = values + ", " + value;
        }
        SQL.insertData(names, values, tableName);
    }

    public void createTable(Column[] columns)
    {
        String s = "";
        for (Column c : columns)
        {
            if (s.isEmpty())
            {
                if (c.getRawDataType() instanceof DataType)
                    s = c.getColumnName() + " " + c.getDataType().toString();
                else if (c.getRawDataType() instanceof DataTypeValue)
                    s = c.getColumnName() + " " + c.getSpecificDataType().toString();
            }
            else
            {
                if (c.getRawDataType() instanceof DataType)
                    s = s + ", " + c.getColumnName() + " " + c.getDataType().toString();
                else if (c.getRawDataType() instanceof DataTypeValue)
                    s = s + ", " + c.getColumnName() + " " + c.getSpecificDataType().toString();
            }
        }
        SQL.createTable(tableName, s);
    }

    public void deleteTable()
    {
        SQL.deleteTable(tableName);
    }

    public boolean tableExists()
    {
        return SQL.tableExists(tableName);
    }

    public void deleteData(Column column, String data, String logic_gate)
    {
        SQL.deleteData(column.getColumnName(), logic_gate, data, tableName);
    }

    public void get(String selected, String data, String logic_gate, Column column)
    {
        SQL.get(selected, column.getColumnName(), logic_gate, data, tableName);
    }

    public <T> List<T> getList(String selected, String logic_gate, String data, Column column)
    {
        return Collections.unmodifiableList((List<T>)SQL.get(selected, column.getColumnName(), logic_gate, data, tableName));
    }
}
