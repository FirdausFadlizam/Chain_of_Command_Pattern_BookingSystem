public class Standard extends BidHandler {
    protected static int numOfStandard = 45;
    public String bidRequest(double bidPrice, int totalAvailableRoom) {

        //if Standard room is available and bid price is acceptable.
        if (numOfStandard > 0 && (bidPrice >= 80 && bidPrice <= 150)) {
            numOfStandard--;
            return "Bid $" + bidPrice + " has been accepted. One Standard room for you!";
        }

        //pass it to the successor if Standard class cannot handle the request
        else if (successor != null) {
            return successor.bidRequest(bidPrice, totalAvailableRoom + numOfStandard);
        }

        //if any of these three types of room is still available
        else if ((totalAvailableRoom + numOfStandard) > 0) {

            if (bidPrice >= 80) {
                return "Other rooms are still available. Please enter a new bid amount.";
            }

            else {
                return "The bid price is not enough for any rooms! Please enter a new bid price.";
            }
        }

        //all rooms are occupied
        else {
            return "No room is available at the moment";
        }



    }
}
