package th.ac.ku.swt012020;

import java.time.LocalTime;

public class StubTime implements Time {
    private final LocalTime time;

    public StubTime(String text) {
        time = LocalTime.parse(text);
    }

    @Override
    public LocalTime now() {
        return time;
    }
}
