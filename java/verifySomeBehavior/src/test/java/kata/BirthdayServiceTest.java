package kata;

import clients.ClientRepository;
import notification.Mailer;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Matchers;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BirthdayServiceTest {
    ClientRepository clientRepositoryMock = Mockito.mock(ClientRepository.class);
    Mailer mailerSpy = Mockito.mock(Mailer.class);
    BirthdayService birthdayService = new BirthdayService(clientRepositoryMock, mailerSpy);

    @Test
    public void sayGoodMorningBob() {
        birthdayService.greeting("Bob");
        //verify(mailerSpy).send("Good morning Bob.");
        verify(mailerSpy).send(Mockito.contains("Good morning"));
        verify(mailerSpy).send(argThat(message -> message.contains("Good morning")));
    }

    @Test
    public void sayHappyBirthdayBob() {
        Mockito.when(clientRepositoryMock.birthdayIsTodayFor("Bob")).thenReturn(true);
        birthdayService.greeting("Bob");
        verify(mailerSpy).send("Happy birthday Bob!");
    }

    @Test
    public void sayHappyBirthdayBobWithCaptor() {
        Mockito.when(clientRepositoryMock.birthdayIsTodayFor("Bob")).thenReturn(true);
        birthdayService.greeting("Bob");


        ArgumentCaptor<String> messageCaptor = ArgumentCaptor.forClass(String.class);
        verify(mailerSpy).send(messageCaptor.capture());

        String message = messageCaptor.getValue();
        assertThat(message).startsWith("Happy");

    }



}
