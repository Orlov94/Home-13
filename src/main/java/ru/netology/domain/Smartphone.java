package ru.netology.domain;


    public class Smartphone extends Product {

        private String manufacturer;


        public Smartphone(int SmartphoneId, String SmartphoneName, int SmartphoneCost, String manufacturer) {
            super.id = SmartphoneId;
            super.name = SmartphoneName;
            super.cost = SmartphoneCost;
            this.manufacturer = manufacturer;
        }

        @Override
        public boolean matches(String search){
            if (super.matches(search)){
                return true;
            }
            if (this.manufacturer.contains(search)){
                return true;
            }else {
                return false;
            }
        }
    }

