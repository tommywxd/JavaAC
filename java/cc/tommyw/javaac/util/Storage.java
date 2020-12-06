package cc.tommyw.javaac.util;

import java.util.HashMap;
import java.util.UUID;

public class Storage {
    public static HashMap<UUID, Long> joinDates = new HashMap<>();
    public static HashMap<UUID, Long> lastOnGround = new HashMap<>();
}