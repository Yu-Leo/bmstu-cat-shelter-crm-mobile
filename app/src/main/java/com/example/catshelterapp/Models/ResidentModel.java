package com.example.catshelterapp.Models;

// Класс, описывающий сущность "Постоялец"
//TODO: у photoURL нужно изменить тип на String (Integer нужен для демонстрации работоспособности)
public class ResidentModel {
    private String VKAlbumURL;
    private Integer age;
    private boolean aggressiveness;
    private boolean booking;
    private String chipNumber;
    private String gender;
    private Integer guardianId;
    private Integer photoURL;
    private String nickname;
    private String roomNumber;
    private String dateOfAdmissionToShelter;


    public ResidentModel(int photoURL, String nickname, String roomNumber, String dateOfAdmissionToShelter) {
        this.photoURL = photoURL;
        this.nickname = nickname;
        this.roomNumber = roomNumber;
        this.dateOfAdmissionToShelter = dateOfAdmissionToShelter;
    }

    public Integer getPhotoURL() {
        return photoURL;
    }

    public String getNickname() {
        return nickname;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getDateOfAdmissionToShelter() {
        return dateOfAdmissionToShelter;
    }
}
