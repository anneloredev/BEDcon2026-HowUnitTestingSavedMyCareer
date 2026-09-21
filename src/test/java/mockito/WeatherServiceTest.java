package mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WeatherServiceTest {

    @InjectMocks
    private WeatherService weatherService;

    @Mock
    private WeatherClient mockClient;

    @Test
    void getWeather() throws Exception {
        // given
        when(mockClient.getCurrentTemperature(49.82,6.13))
                .thenReturn(Optional.of(28.0));

        // when
        String jacketRecommendation =
                weatherService.giveJacketRecommendation(49.82,6.13);

        // then
        assertEquals("You definitely do not need a jacket, stay in the shade!", jacketRecommendation);
    }

}