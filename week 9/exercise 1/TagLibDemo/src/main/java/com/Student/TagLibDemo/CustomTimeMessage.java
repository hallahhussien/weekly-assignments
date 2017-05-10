package com.Student.TagLibDemo;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Created by student on 3/21/17.
 */
@SuppressWarnings("Since15")
public class CustomTimeMessage extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();
        LocalDateTime currentDateTime = LocalDateTime.now();;
        int hour = currentDateTime.getHour();
        String message = "Have a good ";
        if (hour < 6 || hour > 21) {
            message += "night";
        } else if (hour >= 17) {
            message += "evening";
        } else if (hour >= 12) {
            message += "afternoon";
        } else if (hour >= 6) {
            message += "morning";
        }

        int month = currentDateTime.getMonthValue();
        int day = currentDateTime.getDayOfMonth();

        if (month == 10 && day == 31) {
            message += ", and a Happy Halloween!";
        } else if (month == 12 && day == 25) {
            message += ", and a Happy Holidays!";
        } else if (month == 12 && day == 25) {
            message += ", and a Happy New Year!";
        } else {
            message += ".";
        }

        JspWriter out = getJspContext().getOut();
        out.print(message);
    }
}
