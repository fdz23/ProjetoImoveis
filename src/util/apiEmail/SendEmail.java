package util.apiEmail;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.SimpleEmail;

public class SendEmail {

    public void sendEmail(String emailCliente, String token) {

        String meuEmail = "email";
        String minhaSenha = "senha";

        SimpleEmail email = new SimpleEmail();
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator(meuEmail, minhaSenha));
        email.setSSLOnConnect(true);

        try {

            email.setFrom(meuEmail);
            email.setSubject("Recuperação de Senha");
            email.setMsg("Código para Redefinir a senha no sistema : " + token);
            email.addTo(emailCliente);
            email.send();

        } catch (Exception ex) {

            ex.printStackTrace();
        }
    }

}
