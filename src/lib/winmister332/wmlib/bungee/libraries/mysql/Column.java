package lib.winmister332.wmlib.bungee.libraries.mysql;

public final class Column
{
    private String columnName = "";
    private String columnValue = "";
    private Object dataType = null;

    public Column(String name, String value, DataType dataType)
    {
        columnName = name;
        columnValue = value;
        this.dataType = dataType;
    }

    public Column(String name, String value, DataTypeValue dataType)
    {
        columnName = name;
        columnValue = value;
        this.dataType = dataType;
    }

    public String getColumnName() { return columnName; }
    public String getColumnValue() { return columnValue; }
    public DataType getDataType()
    {
        if (dataType instanceof DataType)
            return (DataType) dataType;
        else
            return null;
    }
    public DataTypeValue getSpecificDataType()
    {
        if (dataType instanceof DataTypeValue)
            return (DataTypeValue)dataType;
        else
            return null;
    }
    public Object getRawDataType() { return dataType; }
}
