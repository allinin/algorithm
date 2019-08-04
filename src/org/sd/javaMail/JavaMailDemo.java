package org.sd.javaMail;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

public class JavaMailDemo {

    public static String sendEmailAccount = "813321674@qq.com";
    public static String sendEmailPwd = "pgbpbzdvghojbfee";
    public static String receiveMailAccount = "3060346221@qq.com";
    //发件人邮箱服务器地址
    private static String emaiProtocolType="smtp";
    private static String sendEmailSMTPHost="smtp.qq.com";
    private static String smtpPort="465";
    private static String sslSocketFactory="javax.net.ssl.SSLSocketFactory";

    public static void main(String[] args) throws Exception {
        //设置配置参数，用于连接邮箱服务器的配置参数
        Properties pro=new Properties();
        pro.setProperty("mail.transport.protocol",emaiProtocolType); //使用的协议
        pro.setProperty("mail.smtp.host",sendEmailSMTPHost);//发件人的邮箱饿smtp服务器地址
        pro.setProperty("mail.smtp.auth","true");//需要请求认证


        //SSL安全认证
        pro.setProperty("mail.smpt.port",smtpPort);
        //设置socketFactory
        pro.setProperty("mail.smtp.socketFactory",sslSocketFactory);

        //只处理ssl的连接，对于非ssl的连接不做处理
        pro.setProperty("mail.smtp.socketFactory.fallback","false");
        pro.setProperty("mail.smtp.socketFactory.port",smtpPort);
        //创建回话对象，用于和邮箱服务器交互
        Session session=Session.getInstance(pro);
        session.setDebug(true);//设置为debug模式，可以查看详细的发送log

        //创建一封邮件
        MimeMessage mimeMessage = createMimeMessage(session, sendEmailAccount, receiveMailAccount);
        //根据session获取邮件传输对象
        Transport transport=session.getTransport();
        //使用邮箱账号，密码连接邮件服务器，这里认证的邮箱必须与message中的发件人的邮箱一直

        transport.connect(sendEmailAccount,sendEmailPwd);
        //发送邮件
        transport.sendMessage(mimeMessage,mimeMessage.getAllRecipients());
        //关闭连接
        transport.close();




    }
    public static MimeMessage createMimeMessage(Session session,String sendMail,String receiveMail) throws Exception {
        //创建一封邮件
        MimeMessage message=new MimeMessage(session);
        //设置发件人
        message.setFrom(new InternetAddress(sendMail,"UTF-8"));
        //设置收件人。可以增加多个收件人，抄送，密送
        message.setRecipient(MimeMessage.RecipientType.TO,new InternetAddress(receiveMail,"xxxx用户", "UTF-8"));
        message.setRecipient(MimeMessage.RecipientType.CC,new InternetAddress("3060346221@qq.com","xx用户","UTF-8"));

        //设置邮件主题
        message.setSubject("subject","UTF-8");
        //设置正文
        message.setContent("正文dddddd4444","text/html;charset=utf-8");

        //设置发送事件
        message.setSentDate(new Date());

        //保存设置
        message.saveChanges();
        return message;

    }
}
