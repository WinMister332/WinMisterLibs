package lib.winmister332.wmlib.bungee.libraries.mysql;

public enum DataType
{
    INT("INT"),
    TINYINT("TINYINT"),
    SMALLINT("SMALLINT"),
    MEDIUMINT("MEDIUMINT"),
    BIGINT("BIGINT"),
    FLOAT("FLOAT"),
    DOUBLE("DOUBLE"),
    DECIMAL("DECIMAL"),

    DATE("DATE"),
    DATETIME("DATETIME"),
    TIMESTAMP("DATE"),
    TIME("DATE"),

    CHAR("CHAR"),
    VARCHAR("VARCHAR"),
    BLOB("BLOB"),
    TEXT("TEXT"),
    TINYBLOB("TINYBLOB"),
    TINYTEXT("TINYTEXT"),
    MEDIUMBLOB("MEDIUMBLOB"),
    MEDIUMTEXT("MEDIUMTEXT"),
    LONGBLOB("LONGBLOB"),
    LONGTEXT("LONGTEXT"),
    ENUM("ENUM");

    private String ix = "";

    DataType(String ix)
    {
        this.ix = ix;
    }

    public String toString()
    {
        return ix;
    }
}
