package th.ac.ku.swt012020;

import java.time.LocalTime;

public class RealTime implements Time {
    public LocalTime now() {
        return LocalTime.now();
    }
}
