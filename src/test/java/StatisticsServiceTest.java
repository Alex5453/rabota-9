package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    @Test
    void shouldWrapAroundToFirstStationFromLast() {
        Radio radio = new Radio();
        radio.setStation(9); // Установка на последнюю станцию
        radio.next(); // Переключение на следующую станцию
        assertEquals(0, radio.getCurrentStation()); // Должно переключиться на первую станцию
    }

    @Test
    void shouldWrapAroundToLastStationFromFirst() {
        Radio radio = new Radio();
        radio.setStation(0); // Установка на первую станцию
        radio.prev(); // Переключение на предыдущую станцию
        assertEquals(9, radio.getCurrentStation()); // Должно переключиться на последнюю станцию
    }

    @Test
    void shouldIncreaseVolume() {
        Radio radio = new Radio();
        radio.increaseVolume(); // Увеличение громкости
        assertEquals(51, radio.getCurrentVolume()); // Громкость должна увеличиться на 1
    }

    @Test
    void shouldNotIncreaseVolumeAboveMax() {
        Radio radio = new Radio();
        for (int i = 0; i < 100; i++) {
            radio.increaseVolume(); // Попытка увеличить громкость выше максимальной
        }
        assertEquals(100, radio.getCurrentVolume()); // Громкость не должна превышать 100
    }

    @Test
    void shouldSetStationWithinRange() {
        Radio radio = new Radio();
        radio.setStation(5); // Установка радиостанции в пределах допустимого диапазона
        assertEquals(5, radio.getCurrentStation()); // Станция должна быть установлена
    }

    @Test
    void shouldNotSetStationOutsideRange() {
        Radio radio = new Radio();
        radio.setStation(10); // Попытка установить станцию за пределами допустимого диапазона
        assertEquals(0, radio.getCurrentStation()); // Станция не должна измениться
    }
}
