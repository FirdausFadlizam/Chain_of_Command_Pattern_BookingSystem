public class Suite extends BidHandler {
    protected static int numOfSuite = 10;
    public String bidRequest(double bidPrice, int totalAvailableRoom){

        //if Suite room is available and bid price is acceptable.
        if(numOfSuite > 0 && bidPrice >= 280){
            numOfSuite--;
            return "Bid $" + bidPrice + " has been accepted. One Suite room for you!";
        }
        //pass it to the successor if Suite class cannot handle the request
        else if(successor != null) {

            return successor.bidRequest(bidPrice, totalAvailableRoom + numOfSuite);
        }

        else {
            return "No room is available at the moment";
        }
    }
}
