package ch.swindiatours.model;

public enum BookingState {
    CREATED("C"), PLACED("PL"), PAID("P"), BOOKED("B");
    private final String shortname;

    BookingState(String sn) {
        this.shortname = sn;
    }

    public static BookingState getStatusfromShort(String shortname){
        switch (shortname){
            default:
            case "C":
                return BookingState.CREATED;
            case "PL":
                return BookingState.PLACED;
            case "P":
                return BookingState.PAID;
            case "B":
                return BookingState.BOOKED;
        }
    }

    public static String getShortfromStatus(BookingState bookingState) {
        return bookingState.shortname;
    }

    public static String getDescription(BookingState bookingState) {
        String output;
        switch(bookingState){
            default:
            case CREATED:
                output= "created";
                break;
            case PLACED:
                output= "placed";
                break;
            case PAID:
                output= "paid";
                break;
            case BOOKED:
                output= "booked";
                break;
        }
        return output;
    }

    @Override
    public String toString() {
        return "Role{" +
                "shortname='" + shortname + '\'' +
                '}';
    }
}
