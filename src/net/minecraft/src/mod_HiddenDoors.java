package net.minecraft.src;

import net.minecraft.client.Minecraft;
import bspkrs.hiddendoors.HiddenDoors;
import bspkrs.util.ModVersionChecker;

public class mod_HiddenDoors extends BaseMod
{
    public static boolean     allowUpdateCheck;
    private ModVersionChecker versionChecker;
    private String            versionURL = "http://bspk.rs/Minecraft/1.5.1/hiddenDoors.version";
    private String            mcfTopic   = "http://www.minecraftforum.net/topic/1773498-";
    
    public mod_HiddenDoors()
    {}
    
    @Override
    public String getName()
    {
        return "HiddenDoors";
    }
    
    @Override
    public String getVersion()
    {
        return "ML " + HiddenDoors.VERSION_NUMBER;
    }
    
    @Override
    public String getPriorities()
    {
        return "required-after:mod_bspkrsCore";
    }
    
    @Override
    public void load()
    {
        HiddenDoors.init();
        
        allowUpdateCheck = mod_bspkrsCore.allowUpdateCheck;
        
        if (allowUpdateCheck)
        {
            versionChecker = new ModVersionChecker(getName(), getVersion(), versionURL, mcfTopic);
            versionChecker.checkVersionWithLogging();
            ModLoader.setInGameHook(this, true, true);
        }
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
