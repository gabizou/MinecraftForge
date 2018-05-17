package net.minecraftforge.event.entity;

public interface UpdateEntityEvent extends TargetEntityEvent
{

    boolean getCanUpdate();

    void setCanUpdate(boolean canUpdate);

}
