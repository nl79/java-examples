import java.util.ArrayList;
import java.util.Collections;
import java.util.*;


public class Theatre {
    private final String theatreName;
    public List<Seat> seats = new ArrayList<>();

    static final Comparator<Seat> PRICE_ORDER = new Comparator<Seat>() {
        @Override
        public int compare(Seat seat1, Seat seat2) {
            if(seat1.getPrice() < seat2.getPrice()) {
                return -1;
            } else if( seat1.getPrice() > seat2.getPrice()) {
                return 1;
            } else {
                return 0;
            }
        }
    };

    public Theatre (String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;

        int lastRow = 'A' + (numRows -1);
        for(char row = 'A'; row <= lastRow; row++) {

            for(int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                double price = 12.00;

                if((row < 'D') && (seatNum >= 4 && seatNum <= 9)) {
                    price = 14.00;
                } else if((row > 'F') || (seatNum < 4 || seatNum > 9)) {
                    price = 7.00;
                }
                Seat seat = new Seat(row + String.format("%02d", seatNum), price);
                seats.add(seat);
            }
        }
    }

    public String getTheatreName() {
        return theatreName;
    }

    public boolean reserveSeat(String number) {
        Seat requestedSeat = new Seat(number, 0);
        int foundSeat = Collections.binarySearch(seats, requestedSeat, null);

        if(foundSeat >= 0) {
            return this.seats.get(foundSeat).reserve();
        } else {
            System.out.println("There is no seat " + number);
            return false;
        }
    }

    public Collection<Seat> getSeats() {
        for(Seat seat : seats) {
            System.out.print(seat.getSeatNumber() + " ");
        }

        return seats;
    }

    public class Seat implements Comparable<Seat> {
        private final String seatNumber;
        private boolean reserved = false;
        private double price;

        public Seat(String number, double price) {
            this.seatNumber = number;
            this.price = price;
        }

        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }

        public boolean reserve() {
            if(!this.reserved) {
                this.reserved = true;
                System.out.println("Seat + " + this.seatNumber + " reserve");
                return true;
            }
            return false;
        }

        public boolean cancel() {
            if(this.reserved) {
                this.reserved = false;
                return true;
            }

            return false;

        }

        public String getSeatNumber() {
            return this.seatNumber;
        }
        public double getPrice() {
            return price;
        }
    }
}
