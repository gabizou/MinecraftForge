package net.minecraftforge.event;

public interface ResultFocused
{

    enum Result
    {
        DENY,
        DEFAULT,
        ALLOW
    }

    Result getResult();

    void setResult(Result result);

}
