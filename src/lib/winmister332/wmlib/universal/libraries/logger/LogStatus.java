package lib.winmister332.wmlib.universal.libraries.logger;

public enum LogStatus
{
    OFF(-5),
    DEBUG_SEVERE(-4),
    DEBUG_ERROR(-3),
    DEBUG_WARNING(-2),
    DEBUG_INFO(-1),
    INFO(0),
    WARNING(1),
    ERROR(2),
    SEVERE(3);

    private int statusID = 0;

    LogStatus(int id)
    {
        statusID = id;
    }

    public int getStatusID() { return statusID; }
}
