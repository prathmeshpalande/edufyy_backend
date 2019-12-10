package com.edufyy.backend.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Random;

public class Emailer extends Thread {

    static Logger logger = LoggerFactory.getLogger(Emailer.class);

    public static String sendOTP(String email, String name) {

        logger.info("Generating and Sending OTP");
        final String username = "palande1996@gmail.com";
        final String password = "iovsqbtfrcxdhcen";

        String subject = "Edufyy: OTP";

        Random random = new Random();
        String otp = String.format("%04d", random.nextInt(10000));

        String text = "Hello " + name.split(" ")[0] + ",\n\n" +
                "Your Edufyy OTP is: " + otp + ".\n\n" +
                "Regards,\n" +
                "Edufyy";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("edufyy@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(email)
            );
            message.setSubject(subject);
            message.setText(text);

            Transport.send(message);

            logger.info("OTP Sent: " + otp + " to " + email);

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.toString());
            return "error";
        }

        return otp;
    }
}
