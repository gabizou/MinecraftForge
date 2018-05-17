package net.minecraftforge.event.entity;

public interface EnterChunkEvent extends TargetEntityEvent
{

    int getNewChunkX();

    void setNewChunkX(int newChunkX);

    int getNewChunkZ();

    void setNewChunkZ(int newChunkZ);

    int getOldChunkX();

    void setOldChunkX(int oldChunkX);

    int getOldChunkZ();

    void setOldChunkZ(int oldChunkZ);

}
