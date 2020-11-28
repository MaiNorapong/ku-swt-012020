package th.ac.ku.swt012020;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Person {
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private Date dateOfBirth;

    public Person(String dateOfBirth) {
        try {
            this.dateOfBirth = dateFormat.parse(dateOfBirth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }
}
