package org.example;

public class Radio {
    private int currentStation; // номер текущей радиостанции
    private int currentVolume; // уровень громкости звука

    public Radio() {
        this.currentStation = 0;
        this.currentVolume = 50; // начальный уровень громкости
    }

    // Метод для переключения на следующую радиостанцию
    public void next() {
        if (currentStation == 9) {
            currentStation = 0;
        } else {
            currentStation++;
        }
    }

    // Метод для переключения на предыдущую радиостанцию
    public void prev() {
        if (currentStation == 0) {
            currentStation = 9;
        } else {
            currentStation--;
        }
    }

    // Метод для увеличения уровня громкости на 1
    public void increaseVolume() {
        if (currentVolume < 100) {
            currentVolume++;
        }
    }

    // Метод для установки номера радиостанции с проверкой на допустимость
    public void setStation(int station) {
        if (station >= 0 && station <= 9) {
            currentStation = station;
        }
    }

    // Метод для получения текущей радиостанции
    public int getCurrentStation() {
        return currentStation;
    }

    // Метод для получения текущего уровня громкости
    public int getCurrentVolume() {
        return currentVolume;
    }