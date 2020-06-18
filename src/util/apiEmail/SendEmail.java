package util.apiEmail;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class SendEmail {
    
    private String meuEmail = "5headenterpriseltda@gmail.com";
    private String minhaSenha = "5HeadFernando";
    private HtmlEmail email;
    private String emailCliente;
    private String stringNome;
    private String conteudo;
    private String stringFinal;
    
    public SendEmail(String emailCliente, String nome) throws EmailException {
        
        this.emailCliente = emailCliente;
        stringNome = "Senhor(a) " + nome + ",segue o token necessário para a validação:\n";
        
        email = new HtmlEmail();
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator(meuEmail, minhaSenha));
        email.setSSLOnConnect(true);

        email.setFrom(meuEmail);
        
    }

    public void sendEmailToken(String token) throws EmailException {
        
        this.conteudo = token;
        stringFinal = "Copie e cole na área de texto!\n";

        email.setSubject("Recuperação de Senha");
        email.setHtmlMsg(gerarHtml());
        email.addTo(emailCliente);
        email.send();
    }
    
    public void sendEmailSenha(String senha) throws EmailException {
        
        this.conteudo = senha;
        stringFinal = "Utilize ao logar no sistema!\n";

        email.setSubject("Envio de Senha");
        email.setHtmlMsg(gerarHtml());
        email.addTo(emailCliente);
        email.send();
    }

    private String gerarHtml() {
        String html = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n"
                + "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n"
                + " <head>\n"
                + "  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n"
                + "  <title>Demystifying Email Design</title>\n"
                + "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n"
                + "</head>\n"
                + "<body style=\"margin: 0; padding: 0;color: #153643; font-family: Arial, sans-serif;\">\n"
                + "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" style=\"border: 1px solid #cccccc;\">\n"
                + " <tr>\n"
                + "  <td align=\"center\" bgcolor=\"#70bbd9\" style=\"padding: 20px 0 30px 0; text-align:center;\">\n"
                + " <h1>\n"
                + "     5Head Enterprise\n"
                + " </h1>\n"
                + "</td>\n"
                + " </tr>\n"
                + " <tr>\n"
                + "<td bgcolor=\"#ffffff\" style=\"padding: 40px 30px 40px 30px; text-align:center;\">\n"
                + " <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n"
                + "  <tr>\n"
                + "   <td style=\"color: #153643; font-size: 20px;\">\n"
                + stringNome
                + "   </td>\n"
                + "  </tr>\n"
                + "  <tr>\n"
                + "   <td style=\"color: #153643; font-size: 24px; line-height: 20px;\">\n"
                + "       <br>\n"
                + conteudo
                + "   </td>\n"
                + "  </tr>\n"
                + "  <tr>\n"
                + "   <td>\n"
                + "       <br>\n"
                + stringFinal
                + "   </td>\n"
                + "  </tr>\n"
                + " </table>\n"
                + "</td>\n"
                + " </tr>\n"
                + " <tr>\n"
                + "  <td bgcolor=\"#ee4c50\" style=\"padding: 30px 30px 30px 30px;\">\n"
                + " &reg; 5Head Enterprise, Goiânia, Goiás 2020<br/>\n"
                + " Fernando, Carlos e Raphael\n"
                + "  </td>\n"
                + " </tr>\n"
                + "</table>\n"
                + "</body>\n"
                + "</html>";

        return html;
    }

}
