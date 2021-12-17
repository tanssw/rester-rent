package com.example.backend.service.mongodb;

import com.example.backend.pojo.mongodb.Orders;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.MimeMessage;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class MailService {

    private static final String SENDER = "rester.rent@gmail.com";
    private static final String PWD = "KLMssj@1038";

    public boolean sendMail(String receiver, String subject, String mailBody) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.starttls.enable","true");
        Session session = Session.getInstance(props, null);

        try {
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(SENDER);
            msg.setRecipients(Message.RecipientType.TO, receiver);
            msg.setSubject(subject);
            msg.setText(mailBody);
            Transport.send(msg, SENDER, PWD);
            return true;
        } catch (MessagingException e) {
            System.out.println(e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean sendMail(Orders order, boolean isApproved) {

        String header, body;

        if (isApproved) {
            header = "คำสั่งจองของคุณได้รับการอนุมัติ";
            body = String.format(
                    "สวัสดีค่ะ คุณ %s\n" +
                    "รายการจองห้องสำหรับการจัดอีเวนท์ในวันที่ %s ถึงวันที่ %s ได้รับการอนุมัติแล้ว\n" +
                    "กรุณาดำเนินการชำระเงินจำนวน %d บาท และส่งหลักฐานการชำระเงินมาทางลิงค์นี้\n" +
                    "http://localhost:8080/evidence\n",
                    order.getFullname(),
                    order.getStart_date(),
                    order.getEnd_date(),
                    order.getIncome()
            );
        } else {
            header = "คำสั่งจองของคุณถูกปฏิเสธ";
            body = String.format(
                    "สวัสดีค่ะ คุณ %s\n" +
                    "ขออภัยเป็นอย่างสูง ทางเราไม่สามารถอนุมัติคำสั่งจองของท่านในวันที่ %s ถึงวันที่ %s\n" +
                    "ขอบคุณที่สนใจในบริการของเราค่ะ",
                    order.getFullname(),
                    order.getStart_date(),
                    order.getEnd_date()
            );
        }

        return this.sendMail(order.getMail(), header, body);
    }

}
