package lib.winmister332.wmlib.bungee.libraries.mysql;

public final class DataTypeValue
{
    private DataType type;
    private int dataSize;

    DataTypeValue(DataType type, int dataSize)
    {
        this.type = type;
        this.dataSize = dataSize;
    }

    @Override
    public String toString()
    {
        return type.toString().toUpperCase() + "(" + dataSize + ")";
    }

    public static DataTypeValue INT(int width) { return new DataTypeValue(DataType.INT, width); }
    public static DataTypeValue TINYINT(int width) { return new DataTypeValue(DataType.TINYINT, width); }
    public static DataTypeValue SMALLINT(int width) { return new DataTypeValue(DataType.SMALLINT, width); }
    public static DataTypeValue MEDIUMINT(int width) { return new DataTypeValue(DataType.MEDIUMINT, width); }
    public static DataTypeValue BIGINT(int width) { return new DataTypeValue(DataType.BIGINT, width); }
    public static DataTypeValue FLOAT(int width) { return new DataTypeValue(DataType.FLOAT, width); }
    public static DataTypeValue DOUBLE(int width) { return new DataTypeValue(DataType.DOUBLE, width); }
    public static DataTypeValue DECIMAL(int width) { return new DataTypeValue(DataType.DECIMAL, width); }

    public static DataTypeValue CHAR(int width) { return new DataTypeValue(DataType.CHAR, width); }
    public static DataTypeValue VARCHAR(int width) { return new DataTypeValue(DataType.VARCHAR, width); }
}
