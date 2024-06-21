ppackage org.example;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class RadioTest {
    private Radio radio;

    @Before
    public void setUp() {
        radio = new Radio();
    }

    @Test
    public void shouldStartAtStationZero() {
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldStartAtMidVolume() {
        assertEquals(50, radio.getCurrentVolume());
    }

    @Test
    public void shouldIncreaseStation() {
        radio.next();
        assertEquals(1, radio.getCurrentStation());
    }

    @Test
    public void shouldDecreaseStation() {
        radio.setStation(5);
        radio.prev();
        assertEquals(4, radio.getCurrentStation());
    }

    @Test
    public void shouldLoopToStationNineWhenPrevFromZero() {
        radio.prev();
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    public void shouldLoopToStationZeroWhenNextFromNine() {
        radio.setStation(9);
        radio.next();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldNotSetStationAboveNine() {
        radio.setStation(10);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldNotSetStationBelowZero() {
        radio.setStation(-1);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldIncreaseVolume() {
        radio.increaseVolume();
        assertEquals(51, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotIncreaseVolumeAboveMax() {
        for (int i = 0; i < 51; i++) {
            radio.increaseVolume();
        }
        assertEquals(100, radio.getCurrentVolume());
    }
}
