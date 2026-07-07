package ec.com.uce.application.service;

import ec.com.uce.domain.model.Mail;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class MailServiceTarea implements Runnable {

    @Inject
    private MailService mailService;

    private Mail mail;

    public MailServiceTarea() {
    }

    public Mail getMail() {
        return mail;
    }

    public void setMail(Mail mail) {
        this.mail = mail;
    }

    @Override
    public void run() {
        this.mailService.guardar(this.mail);
    }

}
