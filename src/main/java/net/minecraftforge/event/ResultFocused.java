package net.minecraftforge.event;

import java.util.function.Supplier;

public interface ResultFocused
{

    Result getResult();

    void setResult(Result result);

    enum Result
    {
        DENY()
                {
                    @Override
                    public boolean ifAllowed(Supplier<Boolean> supplier)
                    {
                        return false;
                    }
                },
        DEFAULT()
                {
                    @Override
                    public boolean ifAllowed(Supplier<Boolean> supplier)
                    {
                        return supplier.get();
                    }
                },
        ALLOW()
                {
                    @Override
                    public boolean ifAllowed(Supplier<Boolean> supplier)
                    {
                        return true;
                    }
                };

        public abstract boolean ifAllowed(Supplier<Boolean> supplier);
    }

}
