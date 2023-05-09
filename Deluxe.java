public class Deluxe extends BidHandler {
    protected static int numOfDeluxe = 15;

    @Override
    public String bidRequest(double bidPrice, int totalAvailableRoom) {

        //if Deluxe room is available and bid price is acceptable.
        if (numOfDeluxe > 0 && (bidPrice >= 150 && bidPrice <= 280)){
            numOfDeluxe--;
            return "Bid $" + bidPrice + " has been accepted. One Deluxe room for you!";
        }

        //pass it to the successor if Deluxe class cannot handle the request
        else if (successor != null) {

            return successor.bidRequest(bidPrice, totalAvailableRoom + numOfDeluxe );
        }

        else {
            return "No room is available at the moment";
        }

    }
}
