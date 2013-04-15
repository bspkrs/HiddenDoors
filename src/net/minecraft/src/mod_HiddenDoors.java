package net.minecraft.src;

import net.minecraft.client.Minecraft;
import bspkrs.hiddendoors.HiddenDoors;
import bspkrs.util.ModVersionChecker;

public class mod_HiddenDoors extends BaseMod
{
    public static boolean     allowUpdateCheck;
    private ModVersionChecker versionChecker;
    private String            versionURL = "http://bspk.rs/Minecraft/1.5.1/crystalWing.version";
    private String            mcfTopic   = "http://www.minecraftforum.net/topic/1009577-";
    
    public mod_HiddenDoors()
    {
        allowUpdateCheck = mod_bspkrsCore.allowUpdateCheck;
        
        if (allowUpdateCheck)
            versionChecker = new ModVersionChecker(getName(), getVersion(), versionURL, mcfTopic);
    }
    
    @Override
    public String getName()
    {
        return "HiddenDoors";
    }
    
    @Override
    public String getVersion()
    {
        return "ML 1.5.1.r01";
    }
    
    @Override
    public String getPriorities()
    {
        return "required-after:mod_bspkrsCore";
    }
    
    @Override
    public void load()
    {
        if (allowUpdateCheck)
        {
            versionChecker.checkVersionWithLogging();
            ModLoader.setInGameHook(this, true, true);
        }
        
        HiddenDoors.init();
    }
    
    @Override
    public boolean onTickInGame(float f, Minecraft mc)
    {
        if (allowUpdateCheck)
        {
            if (!versionChecker.isCurrentVersion())
                for (String msg : versionChecker.getInGameMessage())
                    mc.thePlayer.addChatMessage(msg);
        }
        return false;
    }
}
