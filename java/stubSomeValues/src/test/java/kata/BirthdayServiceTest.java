package kata;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import clients.ClientRepository;
import org.junit.Test;
import org.mockito.Mockito;

public class BirthdayServiceTest {
    ClientRepository clientRepositoryMock = Mockito.mock(ClientRepository.class);
    //ClientRepository clientRepository = new ClientRepository();

    BirthdayService birthdayService = new BirthdayService(clientRepositoryMock);

    @Test
    public void sayGoodMorningBob() {
        assertThat(birthdayService.greeting("Bob")).isEqualTo("Good morning Bob.");
    }

    @Test
    public void sayHappyBirthdayBob() {
        Mockito.when(clientRepositoryMock.birthdayIsTodayFor("Bob")).thenReturn(true);
        assertThat(birthdayService.greeting("Bob")).isEqualTo("Happy birthday Bob!");
    }
}
