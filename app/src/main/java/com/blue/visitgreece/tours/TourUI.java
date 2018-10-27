package com.blue.visitgreece.tours;

public class TourUI {

        private String tourId;
        private String tourName;
        private String tourDesc;
        private int descTextSize;


        public TourUI(String tourId, String tourName, String tourDesc, int descTextSize) {
            this.tourId   = tourId;
            this.tourName = tourName;
            this.tourDesc = tourDesc;
            this.descTextSize = descTextSize;
        }

        public String getTourName() {
            return tourName;
        }

        public void setTourId(String tourId) {
            this.tourId = tourId;
        }

        public void setDescTextSize(int descTextSize) {
            this.descTextSize = descTextSize;
        }

        public String getTourId() { return tourId; }

        public int getDescTextSize() {
            return descTextSize;
        }

        public void setTourName(String tourName) {
                this.tourName = tourName;
            }

        public String getTourDesc() {
            return tourDesc;
        }

        public void setTourDesc(String tourDesc) {
            this.tourDesc = tourDesc;
        }

}


