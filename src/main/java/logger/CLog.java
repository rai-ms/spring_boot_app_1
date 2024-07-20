package logger;

import io.micrometer.common.lang.Nullable;

public class CLog {
    public static void log(@Nullable Object data){
        System.out.println(data);
    }
}
